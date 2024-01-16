package com.osttra.dealservice.dto;

import com.osttra.dealservice.entity.Deal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DealDTO {

    private String id;

    private AccountDTO account;

    private AssetDTO asset;

    private AssetDTO oldAsset;

    private OrderType type;

    private OrderStatus status;

    private String statusDetail;

    public DealDTO(Deal deal) {
        id = deal.getId();
        account = new AccountDTO(deal.getAccount());
        asset = new AssetDTO(deal.getAsset());
        if(deal.getOldAsset() != null) {
            oldAsset = new AssetDTO(deal.getOldAsset());
        }
        type = deal.getType();
        status = deal.getStatus();
        statusDetail = deal.getStatusDetail();
    }
}
