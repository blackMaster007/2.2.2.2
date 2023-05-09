package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;
import web.service.CarServiceImp;

@Controller
public class CarsController {

    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/count={count}")
    public String carsDisplay(@PathVariable(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", carService.getCarsByCount(count));
        return "cars";
    }

    @GetMapping("/cars")
    public String show(Model model){
        model.addAttribute("cars", carService.show());
        return "cars";
    }
}
