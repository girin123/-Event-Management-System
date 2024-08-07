package com.excelr.repo;

import com.excelr.model.Product;
import com.excelr.model.User;
import com.excelr.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

    WishlistItem findByUserAndProduct(User user, Product product);

    List<WishlistItem> findByUser(User user);
}
