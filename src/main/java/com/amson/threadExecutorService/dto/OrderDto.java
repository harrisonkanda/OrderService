package com.amson.threadExecutorService.dto;

import com.amson.threadExecutorService.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Long order_id;

    private int quantity;

    private Double unit_price;

    private ItemCategory itemCategory;
}
