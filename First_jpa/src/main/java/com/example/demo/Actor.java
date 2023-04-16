package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="DATA_JPA_ACTOR")
public class Actor {
	@Id
	@Column(name = "Actor Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "ACTOR_NAME",length = 20)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + "]";
	}

	public Actor(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
