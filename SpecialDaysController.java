package com.example.demo.Spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.ArrayList;

    @RestController
    public class SpecialDaysController {
        private static SpecialDayDAO spdayDAO = new SpecialDayDAO ("jdbc:sqlite:C:\\Users\\yelena\\130521.db");


        @GetMapping("/spdays")
        public ArrayList<SpecialDay> getspDays(){
            ArrayList<SpecialDay> spdys = spdayDAO.getAllspdays();
            return spdys;
        }

        @GetMapping("/spdays/{id}")
        public SpecialDay getOrderById(@PathVariable("id") int id)
        {
            SpecialDay spdays = spdayDAO.getSpdayById(id);
            return spdays;
        }

        @PostMapping("/spdays")
        public void addSpdays (@RequestBody SpecialDay c)
        {
            spdayDAO.insertSpday(c);
        }

        @PutMapping("/spdays/{id}")
        public void updateSpdays (@PathVariable("id") int id, @RequestBody SpecialDay update_c)
        {
            spdayDAO.updateSpday(update_c, id);
        }

        @DeleteMapping("/spdays/{id}")
        public void delSpdayById(@PathVariable("id") int id)
        {
            spdayDAO.deleteSpday(id);
        }

    }

