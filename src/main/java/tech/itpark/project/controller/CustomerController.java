package tech.itpark.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.project.dto.CustomerDto;
import tech.itpark.project.manager.CustomerManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")

public class CustomerController {
    private final CustomerManager manager;

    @GetMapping()
    public List<CustomerDto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping()
    public CustomerDto save(@RequestBody CustomerDto dto) {
        return manager.save(dto);
    }

    @GetMapping("/search")
    public List<CustomerDto> search(@RequestParam String name) {
        return manager.search(name);
    }
    @DeleteMapping("/{id}")
    public CustomerDto removeById(@PathVariable long id) {
        return manager.removeById(id);
    }
}
