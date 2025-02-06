package com.sabbir.controller;

import com.sabbir.model.CustomHttpResponse;
import com.sabbir.service.ShopApiService;
import com.sabbir.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/shop-api")
public class ShopController {
    private final ShopApiService shopApiService;

    public ShopController(ShopApiService shopApiService) {
        this.shopApiService = shopApiService;
    }

    @GetMapping("/{shopName}")
    public ResponseEntity<CustomHttpResponse> getShopData(@PathVariable String shopName){
        return ResponseBuilder.buildSuccessResponse(HttpStatus.OK,
                shopApiService.callGetShopDataApi(shopName));
    }
    @PostMapping
    public ResponseEntity<CustomHttpResponse> saveShopData(@RequestBody Map<String, Object> shopData){
        return ResponseBuilder.buildSuccessResponse(HttpStatus.CREATED,
                shopApiService.callSaveShopDataApi(shopData));
    }
}
