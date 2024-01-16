package com.osttra.dealservice.controller;

import com.osttra.dealservice.dto.DealDTO;
import com.osttra.dealservice.service.DealService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DealControllerTest {

    @Mock
    private DealService dealService;

    @InjectMocks
    private DealController dealController;

    @Test
    public void testGetAllDeals() {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setId("ABC");
        when(dealService.getAllDeals()).thenReturn(List.of(dealDTO));
        List<DealDTO> deals = dealController.getAllDeals();
        assertEquals(1, deals.size());
    }
}
