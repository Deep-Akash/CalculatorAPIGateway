package com.calculator.calculatorapigateway.user.service.service;

import com.calculator.calculatorapigateway.user.service.model.APIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by akashdeepnew on 26/12/18.
 */
@Service
public class CalculatorConnectionService {

    private RestTemplate restTemplate = new RestTemplate();

    public APIResponse GET(String URL) {
        return restTemplate.getForObject(URL,APIResponse.class);
    }

    public APIResponse POST(String URL, Object PAYLOAD) {
        return restTemplate.postForObject(URL,PAYLOAD,APIResponse.class);
    }

}