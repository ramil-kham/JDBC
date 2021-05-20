package tech.itpark.project.dto;

import lombok.Value;


@Value
public class BookDto {
    long id;
    String name;
    int price;
    int quantity;
    String author;
    int weight;


}
