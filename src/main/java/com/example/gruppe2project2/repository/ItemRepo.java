package com.example.gruppe2project2.repository;

import com.example.gruppe2project2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer> {

    List<Item> findByItemName(String itemName);
}
