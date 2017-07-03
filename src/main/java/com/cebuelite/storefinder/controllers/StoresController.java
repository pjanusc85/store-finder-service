package com.cebuelite.storefinder.controllers;

import com.cebuelite.storefinder.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cebuelite.storefinder.models.Store;

/**
 * Stores Controller
 */
@RestController
@RequestMapping("/stores")
public class StoresController {


    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public Page<Store> getStores() {
        return storeService.getAllStores(null);
    }


}
