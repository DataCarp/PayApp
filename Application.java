package test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Application {
	
	public static void main(String[] args){
		
		System.out.println("hello world");
		
	
		Company comp = new Company ("CompA","75-1234567");
		Company c2 = new Company ("CompB","12-7896541");
		comp.hire(c2);
		
		System.out.println(comp.toString());
		
		PayrollClerk mable = new PayrollClerk();
		mable.payit(comp);
		
		Employee e1;
		
		Employee e2 = new Employee();
		
		e1 = new Employee("Hank","123-45-6789", 10050);
		e1.setLegalName("Hank");
		e2.setLegalName("Peggy");
		
		mable.payit(e1);
		mable.payit(e2);
		mable.payit(new VendingMachine());
		
		comp.hire(e1);
		comp.hire(e2);
		
		System.out.println(("Company paid a total of " + comp.pay()));
		
		double net = e1.pay();
		
		System.out.println("Paid " + e1 + " net " + net);
		
		net =e2.pay();
		
		System.out.println("Paid " + e2 + " net " + net);
		
	} catch (BadSalaryException e){
	
		System.out.println("*********BAD SALARY*************");
		
	}catch (Exception e){
	
		System.out.println( "Unknown problem: " + e.getMessage());
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	
}
