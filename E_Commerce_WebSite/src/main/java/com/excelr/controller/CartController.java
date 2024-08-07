package com.excelr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.excelr.model.CartItem;
import com.excelr.model.User;
import com.excelr.service.CartService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(@AuthenticationPrincipal User user, Model model) {
        List<CartItem> cartItems = cartService.getCartItems(user);
        BigDecimal totalPrice = cartService.getCartTotalPrice(user);
        int itemCount = cartService.getCartItemCount(user);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("itemCount", itemCount);

        return "cart";
    }

    @PostMapping("/add")
    public String addItemToCart(@AuthenticationPrincipal User user,
                                @RequestParam Long productId,
                                @RequestParam int quantity) {
        cartService.addItemToCart(user, productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeItemFromCart(@AuthenticationPrincipal User user,
                                     @RequestParam Long productId) {
        cartService.removeItemFromCart(user, productId);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(@AuthenticationPrincipal User user, Model model) {
        List<CartItem> cartItems = cartService.getCartItems(user);
        BigDecimal totalPrice = cartService.getCartTotalPrice(user);

        // Implement your payment processing logic here

        // Assuming payment is successful, clear the cart
        cartItems.forEach(cartItem -> cartService.removeItemFromCart(user, cartItem.getProduct().getId()));

        model.addAttribute("totalPrice", totalPrice);
        return "checkout";
    }
}
