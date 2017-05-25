package com.epam.jax_ws_auth;

import com.epam.jax_ws_auth.client.GreetingService;
import com.epam.jax_ws_auth.client.GreetingServiceService;

/**
 * Greeting client.
 */
public class GreetingClient {
    public static void main(String[] args) {
        // TODO generate sources at first
        GreetingServiceService service = new GreetingServiceService();
        GreetingService greet = service.getGreetingServicePort();

        System.out.println(greet.greet("my friend!"));
    }
}
