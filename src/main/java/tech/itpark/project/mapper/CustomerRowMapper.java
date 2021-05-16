package tech.itpark.project.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.CustomerDto;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component

public class CustomerRowMapper implements RowMapper<CustomerDto> {
    public CustomerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("delivery_address")
        );
    }

}
