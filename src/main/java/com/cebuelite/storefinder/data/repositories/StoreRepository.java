package com.cebuelite.storefinder.data.repositories;

import com.cebuelite.storefinder.data.entities.StoreEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StoreRepository extends PagingAndSortingRepository<StoreEntity, Long> {


}
