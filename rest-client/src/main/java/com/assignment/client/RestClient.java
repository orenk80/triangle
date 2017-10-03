package com.assignment.client;

import com.assignment.triangle.data.TriangleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by orenk on 01/10/17.
 */
@Component
public class RestClient {

    private static Logger logger = LoggerFactory.getLogger(RestClient.class);


    @Value("${triangles.uri}")
    private String restUri;

    private Client client;

    @PostConstruct
    protected void init() {
        client = ClientBuilder.newClient();
    }

    public void postTriangle(TriangleDTO triangleDTO) {
        logger.info("Sending request uri:{} with payload:({})", restUri, triangleDTO.toString());
        Response response = client.target(restUri)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(triangleDTO, MediaType.APPLICATION_JSON));
        logger.info("Received response from server http code:{}", response.getStatus());
    }

}
