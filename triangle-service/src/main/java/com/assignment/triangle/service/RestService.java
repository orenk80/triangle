/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assignment.triangle.service;

import com.assignment.triangle.data.TriangleDAO;
import com.assignment.triangle.data.TriangleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    private static final Logger logger = LoggerFactory.getLogger(RestService.class);
    @Autowired
    StorageService storageService;


    public TriangleDTO addEntity(long id, TriangleDTO triangleDTO) {
        logger.info("adding triangle {}", triangleDTO.toString());
        TriangleDAO triangleDAO = new TriangleDAO(triangleDTO.getEdgeA(), triangleDTO.getEdgeB());
        triangleDAO = storageService.addEntity(0L, triangleDAO);
        transformToDto(triangleDTO, triangleDAO);
        logger.info("triangle {} was added", triangleDTO.toString());
        return triangleDTO;
    }

    private void transformToDto(TriangleDTO triangleDTO, TriangleDAO triangleDAO) {
        triangleDTO.setEdgeA(triangleDAO.getEdgeA());
        triangleDTO.setEdgeB(triangleDAO.getEdgeB());
        triangleDTO.setHypotenuseEdge(triangleDAO.getHypotenuse());
        triangleDTO.setId(triangleDAO.getId());
    }


}
