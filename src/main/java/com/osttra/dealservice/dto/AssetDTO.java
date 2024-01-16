package com.osttra.dealservice.dto;

import com.osttra.dealservice.entity.Asset;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssetDTO {

    private Integer id;

    private String name;

    private Double price;

    public AssetDTO(Asset asset) {
        id = asset.getId();
        name = asset.getName();
        price = asset.getPrice();
    }
}
