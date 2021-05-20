package tech.itpark.project.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.OrderDto;
import tech.itpark.project.mapper.OrderRowMapper;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component

public class OrderManager {
    private final NamedParameterJdbcTemplate template;
    private final OrderRowMapper rowMapper = new OrderRowMapper();

    public List<OrderDto> getAll() {
        return template.query("SELECT o.order_id, o.customer_id, o.book_id, o.order_price, o.order_weight, b.name, b.author " +
                        "FROM orders o JOIN books b " +
                        "ON o.book_id = b.id",
                rowMapper
                        );
    }
}
