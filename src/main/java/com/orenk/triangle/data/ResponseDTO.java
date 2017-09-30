package com.orenk.triangle.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

	@JsonProperty("operation_status")
	String status;
	@JsonProperty("message")
	String message;
	@JsonProperty("triangle")
	TriangleDTO triangleDTO;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TriangleDTO getTriangleDTO() {
		return triangleDTO;
	}

	public void setTriangleDTO(TriangleDTO triangleDTO) {
		this.triangleDTO = triangleDTO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
