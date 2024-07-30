package com.dto;

public class EmployeeWithHashOnly {
	private int id;
    private String firstName;
    private String lastName;

    public EmployeeWithHashOnly(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
