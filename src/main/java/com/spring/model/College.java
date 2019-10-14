package com.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CollegeCode;
	private String name;
	
	//https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
	@OneToMany()
	@JoinColumn(name="fk_CollegeCode") 
	private List<Address> addresses;
	
	@OneToMany(mappedBy="college")
	private List<Department> departments;
	
	@ManyToOne
	@JoinColumn(name="StateId")
	private State state;
	
	public College() {
		addresses=new ArrayList<>();
		departments=new ArrayList<>();
	}

	public int getCollegecode() {
		return CollegeCode;
	}

	public void setCollegecode(int collegecode) {
		CollegeCode = collegecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void addAddress(Address address) {
		if(addresses==null) {
			addresses=new ArrayList<>();
		}
		addresses.add(address);
	}
	
	public void addDepartment(Department department) {
		if(departments==null) {
			departments=new ArrayList<>();
		}
		departments.add(department);
	}
	
	

}
