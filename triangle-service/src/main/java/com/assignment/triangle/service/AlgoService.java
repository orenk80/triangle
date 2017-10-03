package com.assignment.triangle.service;


import com.assignment.triangle.data.CalcState;
import com.assignment.triangle.data.TriangleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlgoService {

    private static final Logger logger = LoggerFactory.getLogger(AlgoService.class);
    @Autowired
    StorageService storageService;

    @Scheduled(fixedRateString = "${algo.service.fixed.rate.ms}")
    public void ClacTrianglesHypotenuseEdge() {
        logger.info("starting calculating Hypotenuse for triangles");
        List<TriangleDAO> entities = storageService.getEntities(Optional.empty(), Optional.of(CalcState.PRE.name()));
        logger.info("there are {} triangles needed to be calculated ", entities.size());
        entities.stream()
                .forEach((triangleDAO) -> this.ClacTrianglesHypotenuseEdgeAndUpdate(triangleDAO));


    }

    private void ClacTrianglesHypotenuseEdgeAndUpdate(TriangleDAO triangleDAO) {
        logger.info("calculating Hypotenuse edge for triangle {}", triangleDAO);
        Integer edgeA = triangleDAO.getEdgeA();
        Integer edgeB = triangleDAO.getEdgeB();
        Double hypotenuse = Math.sqrt(edgeA * edgeA + edgeB * edgeB);
        triangleDAO.setHypotenuse(hypotenuse);
        logger.info("triangle({}) Hypotenuse value is :{} , edges({},{})", triangleDAO.getId(), hypotenuse, edgeA, edgeB);
        triangleDAO.setState(CalcState.POST);
        storageService.updateEntity(triangleDAO);
    }
}
