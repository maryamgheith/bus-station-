package application;

public abstract class priceCalc {
	protected double price;
	protected int noOfTickets;
	
	public abstract void setNoOfTickets();
	public double getPrice() {
		setPrice();
		return price;
	}
	public abstract void setPrice();
	
	public double price(String w,String t,String s) {
		double finalp = getPrice();
		Type(t);
		Way(w);
		Stops(s);
			return finalp*noOfTickets;
		
	}
	public void Way(String s) {
		if(s.equalsIgnoreCase("Round Trip"))
			price-=(price*0.2);
			
			
		
			
	}
	public void Type(String s) {
		if(s.equalsIgnoreCase("External"))
			 price+=(price*0.1);
		
		
	}
	public void Stops(String s) {
		if(s.equalsIgnoreCase("Many Stops"))
			price-=(price*0.2);
		else if(s.equalsIgnoreCase("One-Stop"))
			 price-=(price*0.1);
	
		
	}
	//if a car or a limo is chosen from gui we instantiate the class and then call the set number of seats and make it 1;

}
