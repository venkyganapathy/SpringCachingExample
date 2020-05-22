package com.profinch.fincluez.tlibrary.controller;

import com.profinch.fincluez.tlibrary.dimEntities.DimCustomer;
import com.profinch.fincluez.tlibrary.service.DimCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cacheController")
public class CacheController {

    @Autowired
    private DimCacheService dimCacheService;

    @ResponseBody
    @RequestMapping(value = "/getCustomerByCustomerId")
    public DimCustomer getCustomerByCustomerId(@RequestParam String customerId){
        DimCustomer dimCustomer = dimCacheService.getCustomerById(customerId);
        return dimCustomer;
    }

    @ResponseBody
    @RequestMapping(value = "/clearCustomerCache")
    public List clearCustomerCache(){
        return dimCacheService.evictAllDimCustomerCache();
    }
}
