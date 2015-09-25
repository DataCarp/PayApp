package test;

import java.io.Serializable;

public abstract class TaxEntity implements Payable, Serializable {

	
	private static final long serialVersionUID = -2110106439583263654L;
	private String name;
	private String taxid;
	
	
	public TaxEntity(String name, String taxid){
			
		setLegalName(name);
		setTaxid(taxid);
		
	}
	
	public String getLegalName(){
		return name;
	}
	
	public final String getTaxid(){
		return taxid;
	}
	
	public void setLegalName (String value){
		
		if (value !=  null && value.matches("[\\w\\s]{4,30}"))
			name = value;
		else
			throw new IllegalArgumentException("illegal name");
	}
	
	public final void setTaxid(String taxid){
		
		if(taxid != null && taxid.matches(getTaxidRegex()))
			this.taxid = taxid;
		else
			throw new IllegalArgumentException ("bad tax id");
	}
	
	@Override
	public String toString(){
		return getLegalName() + " " + getTaxidRegex();
	}
	
	public abstract double pay();
	public abstract String getTaxidRegex();
	
	
	
	
	
	
	
	
	
	
	
	
}
