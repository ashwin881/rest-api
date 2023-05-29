package com.spring.webservice.restapi.user;

import java.time.LocalDate;

public class User {
private Integer id;
private String name;
private LocalDate birth_date;

public User() {
	super();
	
}

public User(Integer id, String name, LocalDate birth_date) {
	super();
	this.id = id;
	this.name = name;
	this.birth_date = birth_date;
}



public Integer getId() {
	return id;
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

public LocalDate getBirth_date() {
	return birth_date;
}

public void setBirth_date(LocalDate birth_date) {
	this.birth_date = birth_date;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birth_date=" + birth_date + "]";
}

}
