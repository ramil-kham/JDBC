package tech.itpark.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.project.dto.BookDto;
import tech.itpark.project.manager.BookManager;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")

public class BookController {
    private final BookManager manager;

    @GetMapping()
    public List<BookDto> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @PostMapping()
    public BookDto save(@RequestBody BookDto dto) {
        return manager.save(dto);
    }

    @GetMapping("/search")
    public List<BookDto> search(@RequestParam String name, @RequestParam String author) {
        return manager.search(name, author);
    }

    @DeleteMapping("/{id}")
    public BookDto removeById(@PathVariable long id) {
        return manager.removeById(id);
    }
}
