package tech.itpark.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.project.dto.OrderDto;
import tech.itpark.project.manager.OrderManager;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")

public class OrderController {
    private final OrderManager manager;

    @GetMapping()
    public List<OrderDto> getAll() throws SQLException{
        return manager.getAll();
    }
}