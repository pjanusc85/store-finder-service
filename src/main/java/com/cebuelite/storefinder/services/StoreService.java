package com.cebuelite.storefinder.services;

import com.cebuelite.storefinder.data.entities.StoreEntity;
import com.cebuelite.storefinder.data.repositories.StoreRepository;
import com.cebuelite.storefinder.models.Store;
import com.cebuelite.storefinder.models.StoreLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository repository;

    @Autowired
    public StoreService(StoreRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<Store> getAllStores(Pageable pageRequest) {
        Page<StoreEntity> allEntities = this.repository.findAll(pageRequest);
        //List<StoreEntity> allEntitiesContent = allEntities.getContent();

        List<StoreEntity> allEntitiesContent = new ArrayList<>();
        StoreEntity e = new StoreEntity();
        e.setName("Test");
        e.setLatitude(1.123123f);
        e.setLongitude(1.232323f);
        allEntitiesContent.add(e);

        List<Store> allStores = allEntitiesContent.stream().map(entity -> new Store(
                entity.getId(),
                entity.getName(),
                entity.getThumbnailUrl(),
                entity.getFullAddressDescription(),
                entity.getContactPerson(),
                entity.getContactNumber(),
                new StoreLocation(entity.getLatitude(), entity.getLongitude()))).collect(Collectors.toList());

        //List<T> content, Pageable pageable, long total
        Page<Store> retPage = new PageImpl<>(allStores, pageRequest, 500);
        return retPage;
    }

}
