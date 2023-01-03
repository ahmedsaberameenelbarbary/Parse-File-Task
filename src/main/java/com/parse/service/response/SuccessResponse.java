/**
 *
 */
package com.parse.service.response;

import static org.springframework.http.HttpStatus.OK;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 *
 * @author ahmedSaber
 *
 * @param <T>
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SuccessResponse<T> implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -3584010602891575844L;

	private Boolean success;
	private HttpStatus status;
	private T data;

	/**
	 * @param success
	 * @param status
	 */
	public SuccessResponse(Boolean success, HttpStatus status) {
		super();
		this.success = success;
		this.status = status;
	}

	public SuccessResponse(T data) {

		this(Boolean.TRUE, OK);

		this.data = data;

	}

	public static <T> SuccessResponse<T> ok(T data) {
		return new SuccessResponse<>(data);
	}
}
