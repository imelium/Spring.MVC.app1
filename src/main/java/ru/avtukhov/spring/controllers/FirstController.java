package ru.avtukhov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam (value = "surname",required = false) String surname,
                            Model model){

//        System.out.println("Hello, " + name  + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }
    @GetMapping("goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
    @GetMapping("/calculator") // Используем аннотацию, чтобы указать по какому адресу пользователь из броазуера, может получить доступ
                                  // к этому методу контролера

    public String webCaculator(@RequestParam(value = "a", required = false) Integer a,
                                @RequestParam(value = "b", required = false) Integer b,
                                @RequestParam(value = "action") String action,
                                Model model1){
        Integer result = null;

        if (action.equals("multiplication")){
            result = a * b;
        } else if (action.equals("addition")){
            result = a + b;
        } else if (action.equals("subtraction")){
            result = a - b;
        } else if (action.equals("division")){
            result = a / b;
        } else {
            result = 0;
        }

        model1.addAttribute("result", result);

        return "first/calculator"; // Возвращаем какую то строку, котороя будет HTML страницей.
    }
}
