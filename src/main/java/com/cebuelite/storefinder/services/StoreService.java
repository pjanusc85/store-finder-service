package com.cebuelite.storefinder.services;

import com.cebuelite.storefinder.data.entities.StoreEntity;
import com.cebuelite.storefinder.data.repositories.StoreRepository;
import com.cebuelite.storefinder.models.Store;
import com.cebuelite.storefinder.models.StoreLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository repository;
    private final GoogleSheetService googleSheetService;

    @Autowired
    public StoreService(StoreRepository repository, GoogleSheetService googleSheetService) {
        this.repository = repository;
        this.googleSheetService = googleSheetService;
    }

    @Transactional(readOnly = true)
    public Page<Store> getAllStores(PageRequest pageRequest, float latitude, float longitude) {
        List<Store> allStores = this.googleSheetService.readSheets();
        //List<T> content, Pageable pageable, long total
        Page<Store> retPage = new PageImpl<>(allStores, pageRequest, allStores.size());
        return retPage;
    }

}
