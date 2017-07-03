package com.cebuelite.storefinder.services;

import com.cebuelite.storefinder.data.entities.NodeEntity;
import com.cebuelite.storefinder.data.repositories.NodeRepository;
import com.cebuelite.storefinder.models.Node;
import com.cebuelite.storefinder.models.NodeLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NodeService {

    private final NodeRepository repository;

    @Autowired
    public NodeService(NodeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<Node> getAllNodes(Pageable pageRequest) {
        Page<NodeEntity> allEntities = this.repository.findAll(pageRequest);
        //List<NodeEntity> allEntitiesContent = allEntities.getContent();

        List<NodeEntity> allEntitiesContent = new ArrayList<>();
        NodeEntity e = new NodeEntity();
        e.setName("Test");
        e.setLatitude(1.123123f);
        e.setLongitude(1.232323f);
        allEntitiesContent.add(e);

        List<Node> allNodes = allEntitiesContent.stream().map(entity -> new Node(entity.getName(),
                entity.getThumbnailUrl(),
                entity.getFullAddressDescription(),
                entity.getContactPerson(),
                entity.getContactNumber(),
                new NodeLocation(entity.getLatitude(), entity.getLongitude()))).collect(Collectors.toList());

        //List<T> content, Pageable pageable, long total
        Page<Node> retPage = new PageImpl<>(allNodes, pageRequest, 500);
        return retPage;
    }

}
