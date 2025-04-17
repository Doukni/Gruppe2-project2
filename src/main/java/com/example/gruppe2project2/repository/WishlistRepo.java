package com.example.gruppe2project2.repository;


import com.example.gruppe2project2.model.UserInfo;
import com.example.gruppe2project2.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUser(UserInfo user);

}
