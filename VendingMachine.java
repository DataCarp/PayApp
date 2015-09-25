package test;

public class VendingMachine implements Payable{
	
	@Override
	public double pay(){
		System.out.println("vending machine paid");
		return 0;
	}

}
