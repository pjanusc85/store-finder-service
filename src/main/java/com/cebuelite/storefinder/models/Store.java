package com.cebuelite.storefinder.models;

public class Store {

    private long id;
    private String thumbnailUrl;
    private String fullAddressDescription;
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
    public Store(long id, String thumbnailUrl, String fullAddressDescription, String contactNumber, StoreLocation location) {
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.fullAddressDescription = fullAddressDescription;
        this.contactNumber = contactNumber;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
