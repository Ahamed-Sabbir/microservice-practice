package com.sabbir.service;

import com.sabbir.model.Shop;
import com.sabbir.repository.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void addNewShop(Shop shop) throws Exception {
        System.out.println(shop.getName());
        Shop Exist = shopRepository.findShopByName(shop.getName());
        if(Exist != null) {
            throw new Exception("Shop Already Exist");
        }
        shopRepository.save(shop);
    }

    public Shop getShopData(String shopName) throws Exception {
        Shop Exist = shopRepository.findShopByName(shopName);
        if(Exist == null) {
            throw new Exception("No Shop Exist");
        }
        return Exist;
    }
}
