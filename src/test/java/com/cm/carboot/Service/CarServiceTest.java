package com.cm.carboot.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test(expected = RuntimeException.class)
    public void findById() {
        Long id = 1L;
        carService.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}