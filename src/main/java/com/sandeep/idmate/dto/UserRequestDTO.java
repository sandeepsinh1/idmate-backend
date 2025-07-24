package com.sandeep.idmate.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequestDTO 
{
int id;
String name;
String age;
public int getId() {
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
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public UserRequestDTO(int id, String name, String age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
public UserRequestDTO() {}

}
