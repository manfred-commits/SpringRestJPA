package com.manfredipiraino.SpringRestJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*definisce che la classe in utilizzo è un'entità*/
@Entity
@Table(name="mytable")
public class MyUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nome")
	private String name;
	@Column(name="cognome")
	private String surname;
	@Column(name="eta")
	private int age;
	
	public MyUser() {
		
	}
	public MyUser(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("MyUser: id=%d, name=%s, surname=%s , age=%d", id, name, surname, age);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
