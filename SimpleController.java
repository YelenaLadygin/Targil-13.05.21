package com.example.demo.Spring;

import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.Random;

@RestController
    public class SimpleController {


        @GetMapping("/random")
        public int  getRadomNumber(){
            Random numbers = new Random();
            int randomNumber= numbers.nextInt(1000)+1;
            return randomNumber;
        }

        @GetMapping("/multyplay")
        public String multyplay (@RequestParam(value = "a",
            defaultValue = "0") Integer a,
                      @RequestParam(value = "b",
                              defaultValue = "0") Integer b) {
        return String.format("%d * %d = %d", a, b, a * b);
    }
       @GetMapping("/greet/{name}")
        public String hello(@PathVariable ("name") String name)
        {
            return "hello " + name;
        }

    }
