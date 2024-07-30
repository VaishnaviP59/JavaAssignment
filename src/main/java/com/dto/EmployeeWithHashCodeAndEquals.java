package com.dto;

public class EmployeeWithHashCodeAndEquals {
	private int id;
    private String firstName;
    private String lastName;

    public EmployeeWithHashCodeAndEquals(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeWithHashCodeAndEquals that = (EmployeeWithHashCodeAndEquals) obj;
        return id == that.id && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result =  result + firstName.hashCode()+ lastName.hashCode();
        return result;
    }
}
