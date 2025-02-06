package com.sabbir.controller;

import com.sabbir.model.CustomHttpResponse;
import com.sabbir.model.Shop;
import com.sabbir.service.ShopService;
import com.sabbir.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<CustomHttpResponse> addShop(@RequestBody Shop shop){
        try {
            shopService.addNewShop(shop);
            return ResponseBuilder.buildSuccessResponse(HttpStatus.OK, Map.of("message", "Shop Added"));
        } catch (Exception ex) {
            return ResponseBuilder.failureSuccessResponse(HttpStatus.BAD_REQUEST, 400, ex.getMessage());
        }
    }

    @GetMapping("/{shopName}")
    public ResponseEntity<CustomHttpResponse> getShop(@PathVariable String shopName){
        try {
            Shop shop = shopService.getShopData(shopName);
            return ResponseBuilder.buildSuccessResponse(HttpStatus.OK, Map.of("shop", shop));
        } catch (Exception ex) {
            return ResponseBuilder.failureSuccessResponse(HttpStatus.NOT_FOUND, 404, ex.getMessage());
        }
    }
}
