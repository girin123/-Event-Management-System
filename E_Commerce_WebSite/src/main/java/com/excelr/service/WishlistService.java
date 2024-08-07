package com.excelr.service;

import com.excelr.model.Product;
import com.excelr.model.User;
import com.excelr.model.WishlistItem;
import com.excelr.repo.ProductRepository;
import com.excelr.repo.UserRepository;
import com.excelr.repo.WishlistItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void addItemToWishlist(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setUser(user);
        wishlistItem.setProduct(product);

        wishlistItemRepository.save(wishlistItem);
    }

    public void removeItemFromWishlist(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        WishlistItem wishlistItem = wishlistItemRepository.findByUserAndProduct(user, product);
        if (wishlistItem != null) {
            wishlistItemRepository.delete(wishlistItem);
        }
    }

    public List<WishlistItem> getWishlistByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return wishlistItemRepository.findByUser(user);
    }
}
