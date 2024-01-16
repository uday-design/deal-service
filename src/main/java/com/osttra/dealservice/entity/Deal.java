package com.osttra.dealservice.entity;

import com.osttra.dealservice.dto.OrderMessage;
import com.osttra.dealservice.dto.OrderStatus;
import com.osttra.dealservice.dto.OrderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "deal")
@Getter
@Setter
@NoArgsConstructor
public class Deal {

    private String id;

    private Account account;

    private Asset asset;

    private Asset oldAsset;

    private OrderType type;

    private OrderStatus status;

    private String statusDetail;

    public Deal(OrderMessage message) {
        id = message.getId();
        account = Account.builder()
                .id(message.getAccount().getId())
                .balance(message.getAccount().getBalance())
                .build();
        asset = Asset.builder()
                .id(message.getAsset().getId())
                .name(message.getAsset().getName())
                .price(message.getAsset().getPrice())
                .build();
        if (message.getOldAsset() != null) {
            oldAsset = Asset.builder()
                    .id(message.getOldAsset().getId())
                    .name(message.getOldAsset().getName())
                    .price(message.getOldAsset().getPrice())
                    .build();
        }
        type = message.getType();
        status = message.getStatus();
        statusDetail = message.getStatusDetail();
    }
}
