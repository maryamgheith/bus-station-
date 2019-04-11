package application;

public class ReserveTicket {
private int NumofTicket;
private String TypeofVehicle;
private String Destination;
public String getDestination() {
	return Destination;
}public int getNumofTicket() {
	return NumofTicket;
}public String getTypeofVehicle() {
	return TypeofVehicle;
}public void setDestination(String destination) {
	Destination = destination;
}public void setNumofTicket(int numofTicket) {
	NumofTicket = numofTicket;
}public void setTypeofVehicle(String typeofVehicle) {
	TypeofVehicle = typeofVehicle;
}


public void ViewTicket() {
	System.out.println(Destination+", "+NumofTicket+" ticket(s), "+TypeofVehicle);
}

}
