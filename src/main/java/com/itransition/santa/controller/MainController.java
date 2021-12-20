package com.itransition.santa.controller;

import com.itransition.santa.service.EmployeeService;
import com.itransition.santa.service.PairService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final EmployeeService employeeService;
    private final PairService pairService;

    @GetMapping("/santa")
    public String getAll(Model model) {
        model.addAttribute("all", employeeService.getAllWithoutChild());
        return "/santa";
    }

    @GetMapping("/secretVitalikSantaPage")
    public String secret(Model model) {
        model.addAttribute("pairs", pairService.getAll());
        return "/secretVitalikSantaPage";
    }

    @GetMapping("/pair")
    public String createPair(@RequestParam(defaultValue = "") String name, Model model) {
        model.addAttribute("message", pairService.createPair(name));
        return "/success";
    }

    @PostMapping("/reboot")
    public String reboot() {
        pairService.reboot();
        employeeService.reboot();
        return "/secretVitalikSantaPage";
    }
}
