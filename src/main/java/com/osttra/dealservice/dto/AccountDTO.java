package com.osttra.dealservice.dto;

import com.osttra.dealservice.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Integer id;

    private Double balance;

    public AccountDTO(Account account) {
        id = account.getId();
        balance = account.getBalance();
    }

}
