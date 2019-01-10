package com.calculator.calculatorapigateway.user.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RefreshScope
@Service
public class PropertyProviderService {

    @Value("${user.service.debit.url:http://localhost:8094/user/debit}")
    private String userServiceDebitURL;

    @Value("${user.service.credit.url:http://localhost:8094/user/credit}")
    private String userServiceCreditURL;

    @Value("${user.service.fetch.url:http://localhost:8094/user/get?email=}")
    private String userServiceFetchURL;


    public String getUserServiceDebitURL() {
        return userServiceDebitURL;
    }

    public String getUserServiceCreditURL() {
        return userServiceCreditURL;
    }

    public String getUserServiceFetchURL() {
        return userServiceFetchURL;
    }
}
