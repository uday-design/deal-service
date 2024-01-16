package com.osttra.dealservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {

    private String id;

    private AccountDTO account;

    private AssetDTO asset;

    private AssetDTO oldAsset;

    private OrderType type;

    private OrderStatus status;

    private String statusDetail;
}
