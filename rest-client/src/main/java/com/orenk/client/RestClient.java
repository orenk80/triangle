package com.orenk.client;

import com.orenk.triangle.data.TriangleDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by orenk on 01/10/17.
 */
public class RestClient {

    private static final String REST_URI
            = "http://localhost:8080/triangles";

    private Client client = ClientBuilder.newClient();

    public Response postTriangle(TriangleDTO triangleDTO) {
        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(triangleDTO, MediaType.APPLICATION_JSON));
    }

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        TriangleDTO triangleDTO = new TriangleDTO();
        triangleDTO.setEdgeA(5);
        triangleDTO.setEdgeB(3);
        Response response = restClient.postTriangle(triangleDTO);
        int status = response.getStatus();
        System.out.println(status);
    }
}
