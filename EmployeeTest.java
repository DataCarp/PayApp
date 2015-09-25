package test;

import static org.junit.Assert.*;

import org.junit.*;

public class EmployeeTest {

	final static String empName = "Hank Hill";
	final static String empSocial = "123-45-6789";
	final static double empSal = 200;
	
	Employee sut;
	
	@Before
	public void setup(){
		
		sut = new Employee (empName, empSocial, empSal);
	}
	
	@Test
	public void testEmployeeName(){
		
		assertEquals(empName, sut.getLegalName());
	}
	
	@Test
	public void testEmployeeSSN(){
		
		assertEquals(empSocial, sut.getTaxid()); 
	}
	
	@Test
	public void testEmployeeSalary(){
		
		assertEquals(empSal, sut.getSalary(), 00.1);
	}
	
	@Test
	public void testBigSalary(){
		
		sut.setSalary(2_000_000.0);
		assertEquals(2_000_000.0, sut.getSalary(), 001);
	}
	
	@Test(expected=BadSalaryException.class)
	public void testTooSmallSalary(){
		
		sut.setSalary(1);
	}
}

