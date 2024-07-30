package com.dto;

import java.util.Objects;

public class EmployeeForDefaultSort  implements Comparable<EmployeeForDefaultSort> {
    private int id;
    private String firstName;
    private String lastName;

    public EmployeeForDefaultSort(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName(){
    	return firstName;
    }
    
    @Override
    public int compareTo(EmployeeForDefaultSort other) {
        
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeForDefaultSort employee = (EmployeeForDefaultSort) obj;
        return id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    
}
