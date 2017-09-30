package com.orenk.triangle.service;

import com.orenk.triangle.data.CalcState;
import com.orenk.triangle.data.TriangleDAO;
import com.orenk.triangle.data.TriangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    TriangleRepository triangleRepository;

    public TriangleDAO addEntity(Long id, TriangleDAO triangleDAO) {
        return triangleRepository.save(triangleDAO);
    }

    public List<TriangleDAO> getEntities(Optional<Long> id, Optional<String> state)  {

        if (id.isPresent()) {
            TriangleDAO triangleDAO = triangleRepository.findOne(id.get());
            if(triangleDAO != null)
                return Arrays.asList(triangleDAO);
            else
                return new ArrayList<>(0);
        }
        if (state.isPresent()) {
            String stateName = state.get();
            CalcState calcState = CalcState.getStateFromName(stateName);
            return triangleRepository.getAllByState(calcState);

        }
        Iterable<TriangleDAO> iterable = triangleRepository.findAll();
        ArrayList<TriangleDAO> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public TriangleDAO updateEntity(TriangleDAO triangleDAO){
        return triangleRepository.save(triangleDAO);
    }

    public Long getEntityCount() {
        return triangleRepository.count();
    }
}
