package org.wldu.webservices.controllers;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xsdgenerated.*;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddRequest")
    @ResponsePayload
    public AddResponse add(@RequestPayload AddRequest request) {
        AddResponse response = new AddResponse();
        response.setResult(request.getA() + request.getB());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubtractRequest")
    @ResponsePayload
    public SubtractResponse subtract(@RequestPayload SubtractRequest request) {
        SubtractResponse response = new SubtractResponse();
        response.setResult(request.getA() - request.getB());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MultiplyRequest")
    @ResponsePayload
    public MultiplyResponse multiply(@RequestPayload MultiplyRequest request) {
        MultiplyResponse response = new MultiplyResponse();
        response.setResult(request.getA() * request.getB());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DivideRequest")
    @ResponsePayload
    public DivideResponse divide(@RequestPayload DivideRequest request) {
        DivideResponse response = new DivideResponse();
        if (request.getB() != 0) {
            response.setResult(request.getA() / request.getB());
        } else {
            throw new IllegalArgumentException("Division by zero!");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SqrtRequest")
    @ResponsePayload
    public SqrtResponse sqrt(@RequestPayload SqrtRequest request) {
        SqrtResponse response = new SqrtResponse();
        if (request.getA() >= 0) {
            response.setResult(Math.sqrt(request.getA()));
        } else {
            throw new IllegalArgumentException("Cannot take sqrt of negative number!");
        }
        return response;
    }
}

