/**
 * 
 */
package com.lti.demo.model;

/**
 * @author smish
 *
 */
public class Employee {


	private String id;
	
	private String name;
	private double contact_no;
	private Integer age;
	private String password;
	public Employee(String id, String name, double contact_no, Integer age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.contact_no = contact_no;
		this.age = age;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(){}
	
	public Employee(String id, String name, Integer contact_no, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.contact_no = contact_no;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", contact_no=" + contact_no + ", age=" + age + ", password="
				+ password + "]";
	}

	public double getContact_no() {
		return contact_no;
	}

	public void setContact_no(double contact_no) {
		this.contact_no = contact_no;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
