package com.calculator.calculatorapigateway.user.service;


import com.calculator.calculatorapigateway.user.service.exception.APIBaseException;
import com.calculator.calculatorapigateway.user.service.model.APIResponse;
import com.calculator.calculatorapigateway.user.service.model.User;
import com.calculator.calculatorapigateway.user.service.service.CalculatorConnectionService;
import com.calculator.calculatorapigateway.user.service.service.PropertyProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PropertyProviderService propertyProviderService;

    @Autowired
    private CalculatorConnectionService calculatorConnectionService;

    public User getUser(String emailId) throws APIBaseException {
        APIResponse response = calculatorConnectionService.GET(propertyProviderService.getUserServiceFetchURL().concat(emailId));
        if (!response.getSuccess()){
            throw new APIBaseException(response.getCode(),response.getMessage());
        }
        return User.buildFromData(response.getData());
    }
}
