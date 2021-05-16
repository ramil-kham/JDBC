package tech.itpark.project.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import tech.itpark.project.dto.BookDto;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component

public class BookRowMapper implements RowMapper<BookDto> {
    public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookDto(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("author"),
                rs.getInt("weight")
        );
    }

}


