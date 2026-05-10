package dev.dani.bobabestiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.dani.bobabestiary.dto.DrinkSummaryResponse;
import dev.dani.bobabestiary.repository.BobaBestiaryRepository;

@Service
public class ShopService {
    
    private final BobaBestiaryRepository repository;

    public ShopService(BobaBestiaryRepository repository) {
        this.repository = repository;
    }

    public List<DrinkSummaryResponse> getDrinksByShop(String shopId) {
        return repository.findDrinkSummariesByShopId(shopId);
    }
}
