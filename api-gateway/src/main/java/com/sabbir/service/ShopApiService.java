package com.sabbir.service;

import com.sabbir.model.CustomHttpRequest;
import com.sabbir.model.CustomHttpResponse;
import com.sabbir.util.HttpCallLogic;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ShopApiService {

    // base url will be formed using service name + Request Mapping of service
    private static final String SHOP_SERVICE_BASE_URL = "lb://shop-service/shop";
    private final HttpCallLogic httpCallLogic;

    public ShopApiService(HttpCallLogic httpCallLogic) {
        this.httpCallLogic = httpCallLogic;
    }

    public Map<String, Object> callGetShopDataApi(String shopName){
        CustomHttpRequest customHttpRequest = new CustomHttpRequest();

        // path variable
        customHttpRequest.setUrl(SHOP_SERVICE_BASE_URL + "/" + shopName);
        customHttpRequest.setMethodType(HttpMethod.GET);

        // query parameter (http://localhost:8080/shop/shopName=daraz&id=1
        // customHttpRequest.setQueryParameterMap(Map.of("shopName", shopName));
        ResponseEntity<CustomHttpResponse> responseEntity = httpCallLogic.executeRequest(customHttpRequest);
        return responseEntity.getBody().getResponseBody() != null ?
                responseEntity.getBody().getResponseBody() : responseEntity.getBody().getErrorBody();
    }

    public Map<String, Object> callSaveShopDataApi(Map<String, Object> shopData){
        CustomHttpRequest customHttpRequest = new CustomHttpRequest();
        customHttpRequest.setUrl(SHOP_SERVICE_BASE_URL);
        customHttpRequest.setMethodType(HttpMethod.POST);
        customHttpRequest.setBodyParameterMap(shopData);
        ResponseEntity<CustomHttpResponse> responseEntity = httpCallLogic.executeRequest(customHttpRequest);
        return responseEntity.getBody().getResponseBody() != null ?
                responseEntity.getBody().getResponseBody() : responseEntity.getBody().getErrorBody();
    }

}
