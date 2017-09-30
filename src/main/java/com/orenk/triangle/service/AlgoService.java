package com.orenk.triangle.service;

import com.orenk.triangle.data.CalcState;
import com.orenk.triangle.data.TriangleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlgoService {

    private static final Logger logger = LoggerFactory.getLogger(AlgoService.class);
    @Autowired
    StorageService storageService;

    @Scheduled(fixedRateString ="${algo.service.fixed.rate.ms}")
    public void ClacTrianglesHypotenuseEdge(){
        List<TriangleDAO> entities = storageService.getEntities(Optional.empty(), Optional.of(CalcState.PRE.name()));
       entities.stream()
               .forEach((triangleDAO)->this.ClacTrianglesHypotenuseEdgeAndUpdate(triangleDAO) );


    }

    private   void ClacTrianglesHypotenuseEdgeAndUpdate(TriangleDAO triangleDAO){
        Integer edgeA = triangleDAO.getEdgeA();
        Integer edgeB = triangleDAO.getEdgeB();
        Double hypotenuse = Math.sqrt(edgeA*edgeA + edgeB*edgeB);
        triangleDAO.setHypotenuse(hypotenuse);
        triangleDAO.setState(CalcState.POST);
        storageService.updateEntity(triangleDAO);
    }
}
