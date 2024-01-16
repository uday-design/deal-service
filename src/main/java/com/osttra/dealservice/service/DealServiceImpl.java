package com.osttra.dealservice.service;

import com.osttra.dealservice.dto.DealDTO;
import com.osttra.dealservice.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public List<DealDTO> getAllDeals() {
        List<DealDTO> dealDTOS = new LinkedList<>();
        dealRepository.findAll().forEach(deal -> dealDTOS.add(new DealDTO(deal)));
        return dealDTOS;
    }

}
