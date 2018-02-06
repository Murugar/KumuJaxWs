package com.iqmsoft.ws;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import com.iqmsoft.domain.GetUsersResponseMessage;
import com.iqmsoft.services.UserFactoryImpl;

@Slf4j
@WebService(
    targetNamespace = "http://com.iqmsoft/javaee/jax-ws/rest/v1",
    serviceName = "AppEndpoint",
    portName = "AppEndpointSOAP"
)
@ApplicationScoped
public class AppEndpoint {

  @WebMethod(operationName = "GetUsers", action = "http://com.iqmsoft/javaee/jax-ws/rest/v1/users/GetUsers")
  @WebResult(name = "output")
  @ResponseWrapper(
      localName = "GetUsersResponse",
      targetNamespace = "http://com.iqmsoft/javaee/jax-ws/rest/v1/users",
      className = "com.iqmsoft.domain.GetUsersResponse"
  )
  public GetUsersResponseMessage getUsers() {

    return new GetUsersResponseMessage()
        .setUsers(new UserFactoryImpl().getUsers());
  }
}
