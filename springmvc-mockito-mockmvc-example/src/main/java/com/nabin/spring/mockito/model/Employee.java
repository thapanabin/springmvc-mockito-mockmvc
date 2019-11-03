package com.nabin.spring.mockito.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String dept;

}
