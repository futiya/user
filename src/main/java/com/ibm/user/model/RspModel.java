package com.ibm.user.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RspModel {
	@NotNull
	private Integer code;

	@NotNull
	private String message;

	private Object data;


}
