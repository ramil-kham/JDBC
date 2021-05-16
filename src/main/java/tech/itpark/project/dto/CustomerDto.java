package tech.itpark.project.dto;

import lombok.Value;

@Value
public class CustomerDto {
    long id;
    String name;
    String email;
    String delivery_address;
}
