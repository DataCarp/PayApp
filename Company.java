package test;

import java.util.ArrayList;
import java.util.Collection;
public class Company extends TaxEntity{

	private static final long serialVersionUID = -100257693203444359L;
	Collection<Payable> employees;

	
	public Company(String name, String taxid){ 
		
		super(name,taxid);
		 employees = new ArrayList<Payable>();
	}
	
	public void hire (Payable newhire){

		employees.add(newhire); /
	}
	
	/**
	 * Pay all the employees that work for this company
	 * 
	 * @return the net amount paid to all employees 
	 */
	
	public double pay(){ 
		
		double total = 0;

		for (Payable curr : employees){
			
			total += curr.pay();
		} return total;
		
	}
		
	@Override
		public String getTaxidRegex() {
			return "\\d{2}-\\d{7}";
		}
		
	}
	


