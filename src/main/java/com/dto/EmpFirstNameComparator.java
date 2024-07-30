package com.dto;

import java.util.Comparator;

public class EmpFirstNameComparator implements Comparator<EmployeeForDefaultSort> {

	@Override
	public int compare(EmployeeForDefaultSort o1, EmployeeForDefaultSort o2) {
		 return o1.getFirstName().compareTo(o2.getFirstName());
	}

    }
