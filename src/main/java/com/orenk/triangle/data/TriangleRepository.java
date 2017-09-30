package com.orenk.triangle.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TriangleRepository  extends CrudRepository<TriangleDAO, Long> {

    List<TriangleDAO> getAllByState(CalcState state);
    List<TriangleDAO> getAllById(Long id);
}
