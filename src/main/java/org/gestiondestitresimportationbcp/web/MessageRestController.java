package org.gestiondestitresimportationbcp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {


    @GetMapping("/allMessages")
    public void selectMessages(){

    }
}
