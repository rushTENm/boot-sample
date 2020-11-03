package com.cm.carboot.api;

import com.cm.carboot.Service.CarService;
import com.cm.carboot.domain.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get")
    public Car findById(@RequestParam(value = "carId")Long carId) {
        Car car = carService.findById(carId)
            .orElseThrow(() -> new RuntimeException("Not found: " + carId));

        // false case
        log.info("model is not PII: {}", car.getModel());
        log.info("meta data is not a PII: {}", car.getClass());
        // true case
        log.info("owner is PII {}", car.getOwner());
        log.info("@ToString without \"of\" would expose PII: {}", car);

        return car;
    }

    @RequestMapping("/set")
    public List<Car> set() {
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            car.setModel("m"+i);
            car.setOwner("o"+i);
            cars.add(car);
        }

        carService.saveCars(cars);

        return cars;
    }
}
