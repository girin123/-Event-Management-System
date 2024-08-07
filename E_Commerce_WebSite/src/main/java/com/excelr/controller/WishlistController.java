package com.excelr.controller;


import com.excelr.model.WishlistItem;
import com.excelr.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/{userId}/{productId}")
    public void addItemToWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        wishlistService.addItemToWishlist(userId, productId);
    }

    @DeleteMapping("/{userId}/{productId}")
    public void removeItemFromWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        wishlistService.removeItemFromWishlist(userId, productId);
    }

    @GetMapping("/{userId}")
    public List<WishlistItem> getWishlist(@PathVariable Long userId) {
        return wishlistService.getWishlistByUser(userId);
    }
}
