package tech.itpark.project.dto;

import lombok.Value;

@Value

public class OrderDto {
long order_id;
long customer_id;
long book_id;
int price;
int weight;
}
