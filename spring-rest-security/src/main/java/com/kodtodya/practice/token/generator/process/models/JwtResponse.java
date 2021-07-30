package com.kodtodya.practice.token.generator.process.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	@JsonProperty("token")
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public JwtResponse() {
		this.jwttoken = "";
	}

	public String getToken() {
		return this.jwttoken;
	}
}