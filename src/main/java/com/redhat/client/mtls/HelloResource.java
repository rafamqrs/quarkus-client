package com.redhat.client.mtls;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello-client")
public class HelloResource {

    @Inject
    @RestClient
    HelloService helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/hello-api")
    public String getDataFromSSL(){
        return helloService.hello();
    }

}