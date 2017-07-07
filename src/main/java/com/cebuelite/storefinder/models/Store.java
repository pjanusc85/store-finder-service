package com.cebuelite.storefinder.models;

/**
 * Created by paul on 6/28/17.
 */
public class Store {

    private long id;
    private String name;
    private String thumbnailUrl;
    private String fullAddressDescription;
    private String contactPerson;
    private String contactNumber;

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    private String openingHours;
    private StoreLocation location;

    public Store() {}
    public Store(long id, String name, String thumbnailUrl, String fullAddressDescription, String contactPerson, String contactNumber, StoreLocation location) {
        this.id = id;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.fullAddressDescription = fullAddressDescription;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.location = location;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public StoreLocation getLocation() {
        return location;
    }

    public void setLocation(StoreLocation location) {
        this.location = location;
    }
}
