package tech.itpark.project.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.OrderDto;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Component

public class OrderRowMapper implements RowMapper<OrderDto> {
    public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderDto(
                rs.getLong("order_id"),
                rs.getLong("customer_id"),
                rs.getLong("book_id"),
                rs.getInt("order_price"),
                rs.getInt("order_weight")
        );
    }
}
