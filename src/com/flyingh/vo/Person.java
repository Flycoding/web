package com.flyingh.vo;

public class Person {
	private String name = "flyingh";
	private int age;
	private int _id;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		_id = id;
	}

	public int getId() {
		return _id;
	}
}
