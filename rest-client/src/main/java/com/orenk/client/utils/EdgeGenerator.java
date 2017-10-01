package com.orenk.client.utils;

import com.orenk.triangle.data.TriangleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * Created by orenk on 01/10/17.
 */
@Component
public class EdgeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(EdgeGenerator.class);

    protected Random random;
    protected int minimum=0;
    @Value("${random.integer.maximum}")
    protected int maximum;

    @PostConstruct
    protected void init(){
        random=new Random();
    }

    public TriangleDTO generateTriangleEdges(){

        TriangleDTO triangleDTO = new TriangleDTO();
        triangleDTO.setEdgeA( generateRandomInt());
        triangleDTO.setEdgeB( generateRandomInt());
        logger.info("generated triangle");
        return triangleDTO;
    }

    private int generateRandomInt(){
        int n = maximum - minimum + 1;
        int i = random.nextInt() % n;
        return minimum + i;
    }
}
