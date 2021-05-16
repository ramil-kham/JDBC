package tech.itpark.project.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.OrderDto;
import tech.itpark.project.mapper.OrderRowMapper;

import java.util.List;

@RequiredArgsConstructor
@Component

public class OrderManager {
    private final NamedParameterJdbcTemplate template;
    private final OrderRowMapper rowMapper;
/*
    public OrderDto getById(long id) {
        return template.queryForObject(
                "SELECT o.order_id, b.name FROM orders o JOIN books b ON o.book_id = b.id",
                Map.of("id", id),
                rowMapper
        );
    }*/
    public List<OrderDto> getAll() {

        return template.query(
                "SELECT o.order_id, b.name FROM orders o JOIN books b ON o.book_id = b.id",
                rowMapper
        );
    }
}
