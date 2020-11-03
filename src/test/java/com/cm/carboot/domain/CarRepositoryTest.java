package com.cm.carboot.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void saveTest() {
        Car car1 = new Car();

        assertTrue(car1.isNew());

        carRepository.save(car1);

        assertFalse(car1.isNew());
    }

    @Test
    public void findByModelLikeTest() {
        Car car1 = new Car();
        car1.setModel("m");
        carRepository.save(car1);
        List<Car> cars = carRepository.findByModelLike("m");

        assertThat(cars).isNotEmpty();
    }
}