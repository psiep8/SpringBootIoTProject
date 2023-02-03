package com.example.projectiot.controller;

import com.example.projectiot.dto.DatiUtente;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class IndexController {
    @GetMapping(value = "/test-connection-boolean/{temp}")
    public Boolean isPowerOnStatusRequired(@PathVariable String temp) {
        return Double.parseDouble(temp) > 2;
    }

    @GetMapping(value = "/welcome")
    public String provaProva() {
        return "Ciao a tutti!";
    }

    @PostMapping(value = "/test-connection-test", consumes = "application/json")
    public String isConnectionEnstablished(@RequestBody DatiUtente postData) {
        System.out.println("è arrivato il" + postData + postData.toString());
        System.out.println("è arrivato il" + postData.getNumPauseLunghe());
        return postData.toString();
    }
}
