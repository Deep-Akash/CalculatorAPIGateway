package com.calculator.calculatorapigateway.filters;

import com.calculator.calculatorapigateway.model.CalculationRequest;
import com.calculator.calculatorapigateway.user.service.UserService;
import com.calculator.calculatorapigateway.user.service.exception.APIBaseException;
import com.calculator.calculatorapigateway.user.service.model.APIResponse;
import com.calculator.calculatorapigateway.user.service.model.User;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class PreFilter extends ZuulFilter {

    @Autowired
    private UserService userService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Inside PRE filter Run");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
        try {
            String requestString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            CalculationRequest calculationRequest = new Gson().fromJson(requestString,CalculationRequest.class);
            userService.getUser(calculationRequest.getUserEmail());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIBaseException e) {
            if (null == e.getApiResponseCodeENUM()) {
                setFailedRequest(new Gson().toJson(APIResponse.buildFailure(e.code,e.message)));
                return null;
            }
            setFailedRequest(new Gson().toJson(APIResponse.buildFailure(e.getApiResponseCodeENUM())));
        }
        return null;
    }

    private void setFailedRequest(String body) {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            if (ctx.getResponseBody() == null) {
                ctx.setResponseBody(body);
                ctx.getResponse().setHeader("Content-Type", "application/json");
                ctx.getResponse().setStatus(HttpServletResponse.SC_OK);
                ctx.getResponse().getWriter().write(body);
                ctx.getResponse().getWriter().flush();
                ctx.getResponse().getWriter().close();
                ctx.setSendZuulResponse(false);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
