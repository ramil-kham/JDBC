package tech.itpark.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.project.dto.OrderDto;
import tech.itpark.project.manager.OrderManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")

public class OrderController {
    private final OrderManager manager;

    @GetMapping()
    public List<OrderDto> getAll() {
        return manager.getAll();
    }

//    @GetMapping("/{id}")
//    public OrderDto getById(@PathVariable long id) {
//        return manager.getById(id);
//    }

}