package tech.itpark.project.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.CustomerDto;
import tech.itpark.project.mapper.CustomerRowMapper;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component

public class CustomerManager {
    private final NamedParameterJdbcTemplate template;
    private final CustomerRowMapper rowMapper = new CustomerRowMapper();

    public List<CustomerDto> getAll() {

        return template.query(
                "SELECT id, name, email, delivery_address FROM customers ORDER BY id LIMIT 50",
                rowMapper
        );
    }

    public CustomerDto getById(long id) {
        return template.queryForObject(
                "SELECT id, name, email, delivery_address FROM customers WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public CustomerDto save(CustomerDto dto) {
        if (dto.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO customers(name, email, delivery_address) VALUES (:name, :email, :delivery_address)",
                    new MapSqlParameterSource(Map.of(
                            "name", dto.getName(),
                            "email", dto.getEmail(),
                            "delivery_address", dto.getDelivery_address()
                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }
        template.update(
                "UPDATE customers SET name = :name, email = :email, delivery_address = :delivery_address WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "name", dto.getName(),
                        "email", dto.getEmail(),
                        "delivery_address", dto.getDelivery_address()
                )
        );
        return getById(dto.getId());
    }
    public List<CustomerDto> search(String name) {
        return template.query(
                "SELECT id, name, email, delivery_address FROM customers WHERE name = :name",
                Map.of("name", name),
                rowMapper
        );
    }
    public CustomerDto removeById(long id) {
        CustomerDto dto = getById(id);

        template.update(
                "DELETE FROM customers WHERE id = :id",
                Map.of("id", dto.getId())
        );

        return dto;
    }
}
