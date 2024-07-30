package com.test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.dto.EmpFirstNameComparator;
import com.dto.Employee;
import com.dto.EmployeeForDefaultSort;
import com.dto.EmployeeWithEqualsOnly;
import com.dto.EmployeeWithHashCodeAndEquals;
import com.dto.EmployeeWithHashOnly;

public class EmployeeTest {
	
	@Test
    public void testHashSetWithoutHashCodeAndEquals() {
        Set<Employee> employeeSet = new HashSet<>();
        Employee emp1 = new Employee(1, "Peter", "Pan");
        Employee emp2 = new Employee(1, "Peter", "Pan");

        employeeSet.add(emp1);
        employeeSet.add(emp2);

        // Should contain 2 elements as hashCode and equals are not overridden
        assertEquals(2, employeeSet.size());
    }
	
	@Test
    public void testHashSetWithHashCodeOnly() {
        Set<EmployeeWithHashOnly> employeeSet = new HashSet<>();
        EmployeeWithHashOnly emp1 = new EmployeeWithHashOnly(1, "Peter", "Pan");
        EmployeeWithHashOnly emp2 = new EmployeeWithHashOnly(1, "Peter", "Pan");

        employeeSet.add(emp1);
        employeeSet.add(emp2);

        // Should contain 2 elements as equals is not overridden
        assertEquals(2, employeeSet.size());
    }
	
	@Test
    public void testHashSetWithEqualsOnly() {
        Set<EmployeeWithEqualsOnly> employeeSet = new HashSet<>();
        EmployeeWithEqualsOnly emp1 = new EmployeeWithEqualsOnly(1, "Peter", "Pan");
        EmployeeWithEqualsOnly emp2 = new EmployeeWithEqualsOnly(1, "Peter", "Pan");

        employeeSet.add(emp1);
        employeeSet.add(emp2);

        // Should contain 2 elements as hashCode is not overridden
        assertEquals(2, employeeSet.size());
    }
	
	@Test
    public void testHashSetWithHashCodeAndEquals() {
        Set<EmployeeWithHashCodeAndEquals> employeeSet = new HashSet<>();
        EmployeeWithHashCodeAndEquals emp1 = new EmployeeWithHashCodeAndEquals(1, "Peter", "Pan");
        EmployeeWithHashCodeAndEquals emp2 = new EmployeeWithHashCodeAndEquals(1, "Peter", "Pan");

        employeeSet.add(emp1);
        employeeSet.add(emp2);

        // Should contain 1 element as both hashCode and equals are overridden
        assertEquals(1, employeeSet.size());
    }
	
	@Test
    public void testTreeSetDefaultSorting() {
        TreeSet<EmployeeForDefaultSort> employeeSet = new TreeSet<>();
        EmployeeForDefaultSort emp1 = new EmployeeForDefaultSort(2, "Peter", "Pan");
        EmployeeForDefaultSort emp2 = new EmployeeForDefaultSort(1, "Winne", "ThePooh");
        EmployeeForDefaultSort emp3 = new EmployeeForDefaultSort(3, "Tweety", "TheBird");

        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);

        //sorted alphabetically by ID in Default Order
        EmployeeForDefaultSort[] expectedOrder = {emp2, emp1, emp3};
        assertEquals(expectedOrder[0], employeeSet.first());
        assertEquals(expectedOrder[1], employeeSet.higher(expectedOrder[0]));
        assertEquals(expectedOrder[2], employeeSet.higher(expectedOrder[1]));
    }

	@Test
    public void testTreeSetFirstNameSorting() {
        TreeSet<EmployeeForDefaultSort> employeeSet = new TreeSet<>(new EmpFirstNameComparator());
        EmployeeForDefaultSort emp1 = new EmployeeForDefaultSort(2, "Peter", "Pan");
        EmployeeForDefaultSort emp2 = new EmployeeForDefaultSort(1, "Winne", "ThePooh");
        EmployeeForDefaultSort emp3 = new EmployeeForDefaultSort(3, "Tweety", "TheBird");

        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);

        //sorted alphabetically according to First Name in Default Order
        EmployeeForDefaultSort[] expectedOrder = {emp1, emp3, emp2};
        assertEquals(expectedOrder[0], employeeSet.first());
        assertEquals(expectedOrder[1], employeeSet.higher(expectedOrder[0]));
        assertEquals(expectedOrder[2], employeeSet.higher(expectedOrder[1]));
	}
	

	
}
