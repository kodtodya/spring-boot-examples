package com.kodtodya.practice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "partner")
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "scheduler")
	private String scheduler;

	public Partner(String name, String email, String scheduler) {
		this.name = name;
		this.email = email;
		this.scheduler = scheduler;
	}
}
