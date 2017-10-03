package com.assignment.client;

import com.assignment.triangle.data.TriangleDTO;
import com.assignment.client.utils.EdgeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by orenk on 01/10/17.
 */
@Component
public class ClientApplication {

    private static Logger logger = LoggerFactory.getLogger(RestClient.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("classpath:application.xml");

        Integer nTriangles =  context.getBean("nTriangles", Integer.class);
        RestClient client = context.getBean(RestClient.class);
        EdgeGenerator generator = context.getBean(EdgeGenerator.class);
        for (int i = 0; i < nTriangles; i++) {
            TriangleDTO triangleDTO = generator.generateTriangleEdges();
            logger.info("Sending to service triangle= {}",triangleDTO);
            try {
                client.postTriangle(triangleDTO);
            }catch (Exception ex){
                logger.error("Error occurred while sending triangle ex={}",ex.getMessage());
            }
        }


    }
}
