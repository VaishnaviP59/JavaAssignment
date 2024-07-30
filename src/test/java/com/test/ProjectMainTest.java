package com.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.assesment.ProjectMain;

public class ProjectMainTest {

    @Test
    public void testAdd() {
    	ProjectMain app = new ProjectMain();
        int result = app.add(2, 3);
        assertEquals(5, result);
    }
}

