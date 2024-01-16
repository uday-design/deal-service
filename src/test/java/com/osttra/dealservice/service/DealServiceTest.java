package com.osttra.dealservice.service;

import com.osttra.dealservice.dto.DealDTO;
import com.osttra.dealservice.entity.Account;
import com.osttra.dealservice.entity.Asset;
import com.osttra.dealservice.entity.Deal;
import com.osttra.dealservice.repository.DealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DealServiceTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private DealServiceImpl dealService;

    @Test
    public void testGetAllDeals() {
        Account account = new Account();
        account.setId(1);
        account.setBalance(100.00);
        Asset asset = new Asset();
        asset.setId(1);
        asset.setName("Asset");
        asset.setPrice(20.00);
        Deal deal = new Deal();
        deal.setId("ABC");
        deal.setAccount(account);
        deal.setAsset(asset);
        when(dealRepository.findAll()).thenReturn(List.of(deal));
        List<DealDTO> deals = dealService.getAllDeals();
        assertEquals(1, deals.size());
    }
}
