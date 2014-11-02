package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.domain.Car;
import springboot.repository.CarRepository;

@Controller
public class CarPutController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/car/put")
    public @ResponseBody Car put(
            @RequestParam(value = "registrationNumber") String registrationNumber,
            @RequestParam(value = "manufacturer") String manufacturer,
            @RequestParam(value = "model") String model, @RequestParam(value = "year") int year) {
        Car car = new Car(registrationNumber, manufacturer, model, year);
        return carRepository.save(car);
    }
}
