/*
 * Copyright 2012-2016 the original author or authors.
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

package com.assignment.triangle.web;


import com.assignment.triangle.data.TriangleDTO;

import com.assignment.triangle.data.ResponseDTO;
import com.assignment.triangle.service.AlgoService;
import com.assignment.triangle.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TriangleController {

    private static final Logger logger = LoggerFactory.getLogger(AlgoService.class);

    @Autowired
    private RestService restService;

    @RequestMapping(value = "/triangles", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseDTO addTriangle(@RequestBody TriangleDTO triangleDTO) {
        logger.info("Received request {} ", triangleDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("SUCCESS");
        TriangleDTO entity = restService.addEntity(0L, triangleDTO);
        responseDTO.setTriangleDTO(entity);
        return responseDTO;
    }


    @ExceptionHandler({Throwable.class})
    public ResponseDTO handleException(Throwable th) {
        logger.error("Error occurred while handling request {}", th.getMessage());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("ERROR");
        responseDTO.setMessage(th.getMessage());
        return responseDTO;
    }

}
