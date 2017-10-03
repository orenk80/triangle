package com.assignment.client.utils;

import com.assignment.triangle.data.TriangleDTO;
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
    @Value("${random.integer.maximum}")
    protected int maximum;

    @PostConstruct
    protected void init(){
        random=new Random();
    }

    public TriangleDTO generateTriangleEdges(){

        TriangleDTO triangleDTO = new TriangleDTO();
        triangleDTO.setEdgeA(random.nextInt(maximum)+1);
        triangleDTO.setEdgeB(random.nextInt(maximum)+1);
        logger.info("generated triangle {}",triangleDTO.toString());
        return triangleDTO;
    }

}
