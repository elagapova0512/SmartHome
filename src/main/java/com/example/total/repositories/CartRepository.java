package com.example.total.repositories;

import com.example.total.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    // сформировать корзину на основе id пользователя
    List<Cart> findByPersonId(int id);
    @Modifying
    @Query(value="delete from product_cart where product_id = ?1",nativeQuery = true)
    public void deleteProductFromCartById(int id);


}
