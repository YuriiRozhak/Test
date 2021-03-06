
package com.softserve.lv219.hiberlibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@Column(name = "IDAUTHOR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column
	private String name;

	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
