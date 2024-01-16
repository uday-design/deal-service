package com.osttra.dealservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    private Integer id;

    private String name;

    private Double price;
}
