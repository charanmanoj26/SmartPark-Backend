package com.smartpark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://smartpark-frontend-rq0t.onrender.com"
})
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to SmartPark! Backend is running successfully.";
    }
}
