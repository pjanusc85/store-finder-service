package com.cebuelite.storefinder.models;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface GoogleSheetApi {

    //https://sheets.googleapis.com/v4/spreadsheets/1lbPzWitKOmbM7jjmRJDqHSD8jw4R5rofyHyJ3Mvph64?key=AIzaSyAMAIJco25zCWqxz0Zktut6_v1lmNDk1cE&includeGridData=true

    @RequestLine("GET /spreadsheets/{spreadsheetid}")
    GoogleSheetResponse get(@Param("spreadsheetid") String spreadsheetId, @QueryMap Map<String, Object> queryMap);
}
