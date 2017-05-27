package com.epam.jax_ws_auth;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * The callback handler to add password for authentication.
 */
public class UserTokenCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            // checks whether there is password callback with identifier 'cxf' and adds password for it
            // values are hardcoded but we can get the password from any sources
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            if (passwordCallback.getIdentifier().equals("cxf")) {
                passwordCallback.setPassword("cxf");
                break;
            }
        }
    }
}
