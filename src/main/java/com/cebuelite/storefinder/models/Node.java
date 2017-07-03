package com.cebuelite.storefinder.models;

/**
 * Created by paul on 6/28/17.
 */
public class Node {

    private String name;
    private String thumbnailUrl;
    private String fullAddressDescription;
    private String contactPerson;
    private String contactNumber;
    private NodeLocation location;

    public Node() {}
    public Node(String name, String thumbnailUrl, String fullAddressDescription, String contactPerson, String contactNumber, NodeLocation location) {
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.fullAddressDescription = fullAddressDescription;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFullAddressDescription() {
        return fullAddressDescription;
    }

    public void setFullAddressDescription(String fullAddressDescription) {
        this.fullAddressDescription = fullAddressDescription;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public NodeLocation getLocation() {
        return location;
    }

    public void setLocation(NodeLocation location) {
        this.location = location;
    }
}
