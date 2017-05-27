package com.epam.sample.jax_ws_auth;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Callback handler which allows to get password from some source (in this case map) and provide it for verification to
 * the CXF context.
 */
public class UsernameTokenCallbackHandler implements CallbackHandler {

    private Map<String, String> credentials = new HashMap<>();

    public UsernameTokenCallbackHandler() {
        credentials.put("cxf", "cxf");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;

            String password = credentials.get(passwordCallback.getIdentifier());
            if (null != password) {
                passwordCallback.setPassword(password);
                break;
            }
        }
    }
}
