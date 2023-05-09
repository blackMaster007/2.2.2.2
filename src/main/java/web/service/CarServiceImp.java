package web.service;

import web.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService{
    private List<Car> carList;
    {
        carList = new ArrayList<>();
        carList.add(new Car("Vaz", 2110, 558931283));
        carList.add(new Car("BMV", 3, 6943991));
        carList.add(new Car("Газ", 56, 83183200));
        carList.add(new Car("Пежо", 308, 68640664));
        carList.add(new Car("VW", 6, 163121056));
    }
    private List<Car> carNewList;
    @Override
    public List<Car> getCarsByCount(Integer count) {
        if (count >= carList.size()) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }

    @Override
    public List<Car> show() {
        return carList;
    }
}
