package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();

        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북입니다.");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read(){
        Long id = 1l;

        Optional<Item> item = itemRepository.findById(id);
        Assertions.assertTrue(item.isPresent());


    }
}
