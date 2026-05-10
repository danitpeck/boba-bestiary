package dev.dani.bobabestiary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dani.bobabestiary.dto.DrinkSummaryResponse;
import dev.dani.bobabestiary.service.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }
    
    @GetMapping("/{shopId}/drinks")
    public List<DrinkSummaryResponse> getDrinksByShop(@PathVariable String shopId) {
        return shopService.getDrinksByShop(shopId);
    }
}
