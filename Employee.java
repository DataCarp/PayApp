package test;
enum EmpType {FULLTIME, PARTTIME, SEASONAL, INTERN};



public class Employee extends TaxEntity {
	
	private static final long serialVersionUID = 7555801016756071050L;
	
	public final static double TAX_RATE = 0.0765;
	private double salary;
	private double ytdGross;
	private double ytdTax;
	
	private EmpType etype;
	
	public Employee(){
		
		this("No name", "000-00-0000", 100);
	}
	
	public Employee (String name, String ssn, double initSalary){
		
		super(name, ssn);
		setEtype(EmpType.FULLTIME);
		setSalary(initSalary);
		ytdGross = ytdTax = 0;
	}
	/**
	 * This method calculates pay for the employee
	 * @return net pay after taxes
	 * 
	 */
	
	public double pay(){
			
		double tax = getSalary() * TAX_RATE;
		ytdGross = getYtdGross() + getSalary();
		ytdTax += tax;
			
		return getSalary() - tax;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary){
		if (salary > 10 && salary <= 2_000_000)
			this.salary = salary;
		else throw new BadSalaryException();
	}
	
	public double getYtdGross(){
		return ytdGross;
	}
	
	public double getYtdTax(){
		return ytdTax;
	}	

	public EmpType getEtype(){
		return etype;
	}
	
	public void setEtype(EmpType etype){
		this.etype = etype;
	}	

	@Override
	public String getTaxidRegex(){
		return "\\d{3}-\\d{2}-\\d{4}";
	}
}
