package tech.itpark.project.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.BookDto;
import tech.itpark.project.mapper.BookRowMapper;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component

public class BookManager {
    private final NamedParameterJdbcTemplate template;
    private final BookRowMapper rowMapper;

    public List<BookDto> getAll() {

        return template.query(
                "SELECT id, name, price, quantity, author, weight FROM books ORDER BY id LIMIT 50",
                rowMapper
        );
    }

    public BookDto getById(long id) {
        return template.queryForObject(
                "SELECT id, name, price, quantity, author, weight FROM books WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public BookDto save(BookDto dto) {
        if (dto.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO books(name, price, quantity, author, weight) VALUES (:name, :price, :quantity, :author, :weight)",
                    new MapSqlParameterSource(Map.of(
                            "name", dto.getName(),
                            "price", dto.getPrice(),
                            "quantity", dto.getQuantity(),
                            "author", dto.getAuthor(),
                            "weight", dto.getWeight()
                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }
        template.update(
                "UPDATE books SET name = :name, price = :price, quantity = :quantity, author = :author, weight = :weight WHERE id = :id",
                Map.of(
                        "id", dto.getId(),
                        "name", dto.getName(),
                        "price", dto.getPrice(),
                        "quantity", dto.getQuantity(),
                        "author", dto.getAuthor(),
                        "weight", dto.getWeight()
                )
        );

        return getById(dto.getId());
    }

    public List<BookDto> search(String name, String author) {
        return template.query(
                "SELECT id, name, price, quantity, author, weight FROM books WHERE name = :name AND author = :author",
                Map.of("name", name, "author", author),
                rowMapper
        );
    }

    public BookDto removeById(long id) {
        BookDto dto = getById(id);

        template.update(
                "DELETE FROM books WHERE id = :id",
                Map.of("id", dto.getId())
        );

        return dto;
    }
}
