package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    // Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);

    }
    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByAccount("pppp");

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailsList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
            });
        });

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(5L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 테스트만 해줄뿐 실제 데이터 베이스에서 삭제가 이뤄지지 않는다.
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());

    }


}
