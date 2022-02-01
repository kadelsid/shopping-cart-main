package com.Cart.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private long productId;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityAvailable;

}
