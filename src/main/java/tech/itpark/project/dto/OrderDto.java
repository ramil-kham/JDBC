package tech.itpark.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

//@Value
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto {
private long order_id;
private long customer_id;
private long book_id;
private int order_price;
private int order_weight;
}
