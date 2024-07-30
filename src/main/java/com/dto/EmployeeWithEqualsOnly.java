package com.dto;

public class EmployeeWithEqualsOnly {
	private int id;
    private String firstName;
    private String lastName;

    public EmployeeWithEqualsOnly(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeWithEqualsOnly that = (EmployeeWithEqualsOnly) obj;
        return id == that.id && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }
}
