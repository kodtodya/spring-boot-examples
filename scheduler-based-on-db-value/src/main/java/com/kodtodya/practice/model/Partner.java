package com.kodtodya.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getScheduler() {
		return scheduler;
	}

	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public String toString() {
		return "Partner{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", scheduler='" + scheduler + '\'' +
				'}';
	}

	public Partner(long id, String name, String email, String scheduler) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.scheduler = scheduler;
	}

	public Partner() {
	}
}