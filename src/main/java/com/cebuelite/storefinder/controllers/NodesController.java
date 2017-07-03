package com.cebuelite.storefinder.controllers;

import com.cebuelite.storefinder.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cebuelite.storefinder.models.Node;

/**
 * nodes Controller
 */
@RestController
@RequestMapping("/nodes")
public class NodesController {


    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public Page<Node> getNodes() {
        return nodeService.getAllNodes(null);
    }


}
