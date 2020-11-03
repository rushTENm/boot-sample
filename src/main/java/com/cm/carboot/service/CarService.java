package com.cm.carboot.service;

import com.cm.carboot.domain.Car;
import com.cm.carboot.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public void saveCars(List<Car> cars) {
        carRepository.saveAll(cars);
    }
}
