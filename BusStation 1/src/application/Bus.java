package application;

public class Bus extends priceCalc{
			private int Tickets;
	public Bus(int Tickets) {
		super();
	
		this.Tickets=Tickets;

	}

	@Override
	public void setNoOfTickets() {
		noOfTickets=Tickets;
		
	}

	@Override
	public void setPrice() {
	price=50;
		
	}
	
	
}
