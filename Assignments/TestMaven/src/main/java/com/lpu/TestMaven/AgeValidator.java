package com.lpu.TestMaven;

public class AgeValidator {
	private Database db1;
	
	public AgeValidator(Database db) {
		this.db1 = db;
	}
	
	void validateAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		
		db1.saveAge(age);
	}
}
