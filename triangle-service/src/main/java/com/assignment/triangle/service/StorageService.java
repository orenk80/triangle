package com.assignment.triangle.service;


import com.assignment.triangle.data.CalcState;
import com.assignment.triangle.data.TriangleDAO;
import com.assignment.triangle.data.TriangleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    private static Logger logger = LoggerFactory.getLogger(SystemLoggerService.class);
    @Autowired
    TriangleRepository triangleRepository;

    public TriangleDAO addEntity(Long id, TriangleDAO triangleDAO) {
        logger.info("adding triangle {}",triangleDAO.toString());
        return triangleRepository.save(triangleDAO);
    }

    public List<TriangleDAO> getEntities(Optional<Long> id, Optional<String> state)  {

        if (id.isPresent()) {
            logger.info("Getting triangle by ID:{}", id.get());
            TriangleDAO triangleDAO = triangleRepository.findOne(id.get());
            logger.info("Retrieved triangle", triangleDAO);
            if(triangleDAO != null)
                return Arrays.asList(triangleDAO);
            else
                return new ArrayList<>(0);
        }
        if (state.isPresent()) {
            logger.info("Getting triangles by state:{}", state.get());
            String stateName = state.get();
            CalcState calcState = CalcState.getStateFromName(stateName);
            return triangleRepository.getAllByState(calcState);

        }
        logger.info("Getting all triangles");
        Iterable<TriangleDAO> iterable = triangleRepository.findAll();
        ArrayList<TriangleDAO> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public TriangleDAO updateEntity(TriangleDAO triangleDAO){
        logger.info("Updating triangle:{}", triangleDAO);
        return triangleRepository.save(triangleDAO);
    }

    public Long getEntityCount() {
        logger.info("Getting triangles count");
        return triangleRepository.count();
    }
}
