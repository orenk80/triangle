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

package com.orenk.triangle.web;

import com.orenk.triangle.data.ResponseDTO;
import com.orenk.triangle.data.TriangleDAO;
import com.orenk.triangle.data.TriangleDTO;
import com.orenk.triangle.service.RestService;
import com.orenk.triangle.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class TriangleController {



    @Autowired
    private RestService restService;

	@RequestMapping(value = "/triangles", method = RequestMethod.POST,consumes ="application/json",produces = "application/json")
	@ResponseBody
	public ResponseDTO addTriangle(@RequestBody TriangleDTO triangleDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setStatus("SUCCESS");
        TriangleDTO entity = restService.addEntity(0L, triangleDTO);
        responseDTO.setTriangleDTO(entity);
		return responseDTO;
	}

    @RequestMapping(value = "/triangles", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<TriangleDTO> getEntities(@RequestParam(value="state", required = false)String state) {
        if (state != null &&
                (!state.toLowerCase().matches("post") ||
                !state.toLowerCase().matches("pre"))){
            throw new ValidationException("state="+state+" is not valid");
        }
	    return restService.getTriangles(Optional.empty(), Optional.ofNullable(state));
    }
    @RequestMapping(value = "/triangles/{id}", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<TriangleDTO> getEntity(@PathVariable Long id) {

        List<TriangleDTO> triangles = restService.getTriangles(Optional.ofNullable(id), Optional.empty());
        if(triangles.isEmpty()) {

        return new ResponseEntity(  HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity( triangles.get(0), HttpStatus.OK);
    }

    @RequestMapping(value = "/triangles/count", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<Long> getEntityCount() {
        return new ResponseEntity( restService.getEntityCount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/triangles/{id}", method = RequestMethod.PUT,consumes ="application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<TriangleDTO> updateEntity(@PathVariable Long id, @RequestBody TriangleDTO triangleDTO ) {
        return new ResponseEntity( restService.updateEntity(id, triangleDTO), HttpStatus.OK);
    }

	@ExceptionHandler({ Throwable.class })
	public ResponseDTO handleException(Throwable th) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setStatus("ERROR");
		responseDTO.setMessage(th.getMessage());
		return responseDTO;
	}

}
