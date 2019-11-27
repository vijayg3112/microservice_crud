package com.user.demo.Microservicecrud.dto;

public class BaseResponseDTO {
	private String status;
	private String responseCode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getresponseCode() {
		return responseCode;
	}

	public void setresponseCode(String errorDesc) {
		this.responseCode = errorDesc;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", errorDesc=" + responseCode + "]";
	}
}
