package com.richdataco.task2.controller;

import com.richdataco.task2.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CalculationController {
    @Autowired
    CalculationService calculationService;

    /**
     * This is the endpoint which accept a series of numbers and perform the tripletZero service on it.
     * @param data which is the input string from the request body of this endpoint.
     * @return the result of the tripletsZero calculation.
     * @throws Exception if non-int type exist in the input list.
     */

    @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<int[]> tripletsZero(
            @RequestBody String data
    ) throws Exception {
        return calculationService.performCalculation(data);
    };

}
