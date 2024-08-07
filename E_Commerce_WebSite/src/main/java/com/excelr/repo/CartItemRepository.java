package com.excelr.repo;

import com.excelr.model.CartItem;
import com.excelr.model.Product;
import com.excelr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUser(User user);

    void deleteAll(List<CartItem> cartItems);

	CartItem findByUserAndProduct(User user, Product product);
}
