package com.kodtodya.practice.model;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	private int id;

	private String user;

	@Size(min = 10, message = "Enter atleast 10 Characters.")
	private String desc;

	private Date targetDate;
	private boolean isDone;
}

