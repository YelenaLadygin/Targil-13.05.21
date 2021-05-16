package com.example.demo.Spring;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.ArrayList;

    @RestController
    public class HollydaysController {
        private static HolidayDAO holidayDAO = new HolidayDAO ("jdbc:sqlite:C:\\Users\\yelena\\130521.db");


        @GetMapping("/holidays")
        public ArrayList<Holiday> getHoliday(){
            ArrayList<Holiday> holidays = holidayDAO.getAllHolidays();
            return holidays;
        }

        @GetMapping("/holidays/{id}")
        public Holiday getHoldayById(@PathVariable("id") int id)
        {
            Holiday holidays = holidayDAO.getHolidayById(id);
            return holidays;
        }

        @PostMapping("/holidays")
        public void addHoliday (@RequestBody Holiday c)
        {
            holidayDAO.insertHoliday(c);
        }

        @PutMapping("/holidays/{id}")
        public void updateHoliday (@PathVariable("id") int id, @RequestBody Holiday update_c)
        {
            holidayDAO.updateHolidayName(update_c, id);
        }

        @DeleteMapping("/holidays/{id}")
        public void delHolidayById(@PathVariable("id") int id)
        {
            holidayDAO.deleteHoliday(id);
        }
}
