package com.sabbir.repository;

import com.sabbir.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Shop findShopByName(String shopName);
}
