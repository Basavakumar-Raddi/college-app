package com.kumar.college.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T response;

	private boolean success = true;

	private String errorCode;

	private String message;

}
