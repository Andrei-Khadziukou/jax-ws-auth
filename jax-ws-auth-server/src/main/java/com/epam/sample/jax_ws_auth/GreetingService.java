package com.epam.sample.jax_ws_auth;

import javax.jws.WebService;

/**
 * The greeting service.
 */
@WebService // marks class as web service
public class GreetingService {

    @WebMethod // marks method as web service operation
    String greet(String name) {
        return "Hello, " + name;
    }
}
