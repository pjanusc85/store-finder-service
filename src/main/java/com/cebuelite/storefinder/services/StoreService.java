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

    @Autowired
    public StoreService(StoreRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<Store> getAllStores(PageRequest pageRequest, float latitude, float longitude) {
        Page<StoreEntity> allEntities = this.repository.findAll(pageRequest);

        List<StoreEntity> allEntitiesContent = new ArrayList<>();

        StoreEntity e = new StoreEntity();
        e.setId(1L);
        e.setThumbnailUrl("https://geo1.ggpht.com/cbk?panoid=wBn05OfIlQeqKASUQpZq5w&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=160.78165&pitch=0&thumbfov=100");
        e.setName("Insular Life");
        e.setLatitude(10.320248f);
        e.setLongitude(123.906024f);
        e.setFullAddressDescription("Suite 1204, 12th Floor, Insular Life Business Centre, Biliran Road, Cebu Business Park, Cebu City, 6000 Cebu");
        e.setContactNumber("(032) 268-3206");
        e.setContactPerson("Billie Duterte");
        allEntitiesContent.add(e);

        StoreEntity e2 = new StoreEntity();
        e2.setId(2L);
        e2.setThumbnailUrl("https://geo1.ggpht.com/cbk?panoid=wBn05OfIlQeqKASUQpZq5w&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=160.78165&pitch=0&thumbfov=100");
        e2.setName("Insular Life");
        e2.setLatitude(10.320248f);
        e2.setLongitude(123.906024f);
        e2.setFullAddressDescription("Suite 1204, 12th Floor, Insular Life Business Centre, Biliran Road, Cebu Business Park, Cebu City, 6000 Cebu");
        e2.setContactNumber("(032) 268-3206");
        e2.setContactPerson("Billie Duterte");
        allEntitiesContent.add(e2);

        StoreEntity e3 = new StoreEntity();
        e3.setId(3L);
        e3.setThumbnailUrl("https://geo1.ggpht.com/cbk?panoid=wBn05OfIlQeqKASUQpZq5w&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=160.78165&pitch=0&thumbfov=100");
        e3.setName("Insular Life");
        e3.setLatitude(10.320248f);
        e3.setLongitude(123.906024f);
        e3.setFullAddressDescription("Suite 1204, 12th Floor, Insular Life Business Centre, Biliran Road, Cebu Business Park, Cebu City, 6000 Cebu");
        e3.setContactNumber("(032) 268-3206");
        e3.setContactPerson("Billie Duterte");
        allEntitiesContent.add(e3);

        StoreEntity e4 = new StoreEntity();
        e4.setId(4L);
        e4.setThumbnailUrl("https://geo1.ggpht.com/cbk?panoid=wBn05OfIlQeqKASUQpZq5w&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=160.78165&pitch=0&thumbfov=100");
        e4.setName("Insular Life");
        e4.setLatitude(10.320248f);
        e4.setLongitude(123.906024f);
        e4.setFullAddressDescription("Suite 1204, 12th Floor, Insular Life Business Centre, Biliran Road, Cebu Business Park, Cebu City, 6000 Cebu");
        e4.setContactNumber("(032) 268-3206");
        e4.setContactPerson("Billie Duterte");
        allEntitiesContent.add(e4);

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
