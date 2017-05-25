REM It allows to generate files based on the WSDL and place them to specific folder (-d)
REM -Xnocompile - no need to compile generated sources
REM -keep - don't remove generated sources
REM -p - package for sources
wsimport -d src/main/java -Xnocompile -keep -p com.epam.jax_ws_auth.client http://localhost:8080/jax-ws-auth-server/services/greet?wsdl
