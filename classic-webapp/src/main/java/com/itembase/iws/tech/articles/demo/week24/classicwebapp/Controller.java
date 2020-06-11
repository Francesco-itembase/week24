package com.itembase.iws.tech.articles.demo.week24.classicwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping("/endpoint")
    public String response()
    {
        return "Text Response";
    }

    @GetMapping("/slow")
    public String slowResponse() throws InterruptedException
    {
        Thread.sleep(100);

        return "Slow Text Response";
    }
}
