package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarServiceImp;

@Controller
public class CarsController {

    private final CarServiceImp carServiceImp;

    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping("/cars/count={count}")
    public String carsDisplay(@PathVariable(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", carServiceImp.getCarsByCount(count));
        return "cars";
    }

    @GetMapping("/cars")
    public String show(Model model){
        model.addAttribute("cars", carServiceImp.show());
        return "cars";
    }
}
