package tech.itpark.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookUpdateDto {
    private long id;
    private String name;
    private int price;
    private int quantity;
    private String author;
    private int weight;
}
