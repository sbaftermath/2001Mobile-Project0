package com.revature.test;

import org.junit.Test;

import com.revature.pojo.SystemCars;

import junit.framework.TestCase;

public class test extends TestCase {

	@Test
	public void testUserAccess() {
		assertEquals(100,SystemCars.calculatePayment(2400));
	}
}
