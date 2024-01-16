package com.osttra.dealservice.controller;

import com.osttra.dealservice.dto.DealDTO;
import com.osttra.dealservice.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping()
    public List<DealDTO> getAllDeals() {
        log.info("Retrieving all deals");
        return dealService.getAllDeals();
    }

}
