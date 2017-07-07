package com.cebuelite.storefinder.services;

import com.cebuelite.storefinder.data.entities.StoreEntity;
import com.cebuelite.storefinder.models.*;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoogleSheetService {

    String spreadsheetId = "1lbPzWitKOmbM7jjmRJDqHSD8jw4R5rofyHyJ3Mvph64";
    String apikey = "AIzaSyAMAIJco25zCWqxz0Zktut6_v1lmNDk1cE";
    //https://sheets.googleapis.com/v4/spreadsheets/1lbPzWitKOmbM7jjmRJDqHSD8jw4R5rofyHyJ3Mvph64?key=AIzaSyAMAIJco25zCWqxz0Zktut6_v1lmNDk1cE&includeGridData=true

    public List<Store> readSheets() {
        List<Store> allStores = new ArrayList<>();
        GoogleSheetApi googleSheetApi = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .decoder(new JacksonDecoder())
                .target(GoogleSheetApi.class, "https://sheets.googleapis.com/v4");

        // Fetch and print a list of the contributors to this library.
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("key", apikey);
        queryMap.put("includeGridData", true);
        GoogleSheetResponse googleSheetResponse = googleSheetApi.get(spreadsheetId, queryMap);
        List<GoogleSheet> sheets = googleSheetResponse.sheets;

        // We get only first sheet for now
        GoogleSheet googleSheet = sheets.get(0);
        // We get only first sheet data
        GoogleSheetData googleSheetData = googleSheet.data.get(0);
        // First data are the column headers
        GoogleSheetRowData googleSheetRowData = googleSheetData.rowData.get(0);
        // We get the columnheaders
        // Address	Latitude	Longitude	Phone	Thumbnail	Opening Hours
        List<String> columnHeaders = googleSheetRowData.values.stream().map(value -> value.userEnteredValue.stringValue).collect(Collectors.toList());
        // The next rows are the actual values
        List<List<String>> rowValues = new ArrayList<>();
        for(int i=1; i<googleSheetData.rowData.size(); i++) {
            GoogleSheetRowData valueData = googleSheetData.rowData.get(i);
            List<String> rowValue = valueData.values.stream().map(value -> value.userEnteredValue.stringValue).collect(Collectors.toList());
            Store storeEntity = new Store();
            storeEntity.setFullAddressDescription(rowValue.get(columnHeaders.indexOf("Address")));
            String latitude = rowValue.get(columnHeaders.indexOf("Latitude"));
            StoreLocation location = new StoreLocation();
            location.setLatitude(Float.parseFloat(latitude));
            location.setLongitude(Float.parseFloat(rowValue.get(columnHeaders.indexOf("Longitude"))));
            storeEntity.setLocation(location);
            storeEntity.setContactNumber(rowValue.get(columnHeaders.indexOf("Phone")));
            storeEntity.setThumbnailUrl(rowValue.get(columnHeaders.indexOf("Thumbnail")));
            storeEntity.setOpeningHours(rowValue.get(columnHeaders.indexOf("Opening Hours")));
            storeEntity.setId(i);
            allStores.add(storeEntity);
        }
        return allStores;
    }
}
