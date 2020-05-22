package com.profinch.fincluez.tlibrary.service;

import com.profinch.fincluez.tlibrary.dimEntities.DimCustomer;
import com.profinch.fincluez.tlibrary.dimRepos.DimCustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DimCacheService {

    private Logger log = LoggerFactory.getLogger(DimCacheService.class);

    @Autowired
    private DimCustomerRepo dimCustomerRepo;
    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "dimCustomer", key="#customerId")
    public DimCustomer getCustomerById(String customerId){
        log.debug("inside...DimCacheService....getCustomerById for {}",customerId);

        Optional<DimCustomer> dimCustomerOptional = dimCustomerRepo.findById(customerId);
        log.debug("Fired....Repo for DimCustomer...{}",customerId);
        if (dimCustomerOptional.isPresent()){
            return dimCustomerOptional.get();
        }
        return null;
    }

    @CacheEvict(value = "dimCustomer", allEntries = true)
    public List<String> evictAllDimCustomerCache(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Cache-Cleared");
        return stringList;
    }

    @PostConstruct
    public void init() {
        loadAllDimCustomersIntoCache();
    }

    public void loadAllDimCustomersIntoCache() {
        for (DimCustomer dimCustomer : dimCustomerRepo.findAll()) {
            cacheManager.getCache("dimCustomer").put(dimCustomer.getCustomerId(), dimCustomer);
        }
    }

}
