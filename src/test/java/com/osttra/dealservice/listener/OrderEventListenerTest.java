package com.osttra.dealservice.listener;

import com.osttra.dealservice.entity.Deal;
import com.osttra.dealservice.repository.DealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderEventListenerTest {

    @Mock
    private DealRepository dealRepository;

    @InjectMocks
    private OrderEventListener orderEventListener;

    @Test
    public void testListenOrderEvents() {
        Deal deal = new Deal();
        deal.setId("ABC");
        when(dealRepository.save(any(Deal.class))).thenReturn(deal);
        orderEventListener.listenOrderEvents("{\"id\":\"0a6adb32-1884-4f67-b795-779924361357\",\"account\":{\"id\":2," +
                "\"balance\":430.0},\"asset\":{\"id\":2,\"name\":\"Asset2\",\"price\":50.0},\"oldAsset\":null," +
                "\"type\":\"BUY\",\"status\":\"COMPLETED\",\"statusDetail\":\"Order Submitted\"}");
        verify(dealRepository, atLeastOnce()).save(any(Deal.class));
    }

    @Test
    public void testListenOrderEventsException() {
        orderEventListener.listenOrderEvents("Error");
        verify(dealRepository, never()).save(any(Deal.class));
    }
}
