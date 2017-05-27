package com.epam.jax_ws_auth;

import com.epam.jax_ws_auth.client.GreetingService;
import com.epam.jax_ws_auth.client.GreetingServiceService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Greeting client.
 */
public class GreetingClient {
    public static void main(String[] args) {
        // TODO generate sources at first
        GreetingServiceService service = new GreetingServiceService();
        GreetingService greet = service.getGreetingServicePort();

        // configure Greeting service to send secured calls
        Client client = ClientProxy.getClient(greet);
        Endpoint endpoint = client.getEndpoint();

        // prepare out secure interceptor
        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UserTokenCallbackHandler.class.getName());
        props.put(WSHandlerConstants.USER, "cxf");

        WSS4JOutInterceptor outInterceptor = new WSS4JOutInterceptor(props);
        endpoint.getOutInterceptors().add(outInterceptor);

        System.out.println(greet.greet("my friend!"));
    }
}
