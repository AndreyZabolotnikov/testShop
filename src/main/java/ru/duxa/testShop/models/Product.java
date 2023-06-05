package ru.duxa.testShop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "type_product")
    @NotBlank(message = "Type product should`t be empty")
    @Size(min = 2, max = 30, message = "Type product should be between 2 and 30")
    @Pattern(regexp = "[А-ЯЁA-Z]", message = "Type product in uppercase letters")
    private String typeProduct;

    @Column(name = "serial")
    @NotEmpty(message = "Serial number should`t be empty")
    @Positive
    private int serial;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private  int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private  String description;
}
