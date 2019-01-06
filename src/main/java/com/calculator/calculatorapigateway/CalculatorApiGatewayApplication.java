package com.calculator.calculatorapigateway;

import com.calculator.calculatorapigateway.filters.ErrorFilter;
import com.calculator.calculatorapigateway.filters.PostFilter;
import com.calculator.calculatorapigateway.filters.PreFilter;
import com.calculator.calculatorapigateway.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class CalculatorApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApiGatewayApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}

