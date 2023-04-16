package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",initialValue = 1,allocationSize = 1)
	private Integer empno;
	

}
