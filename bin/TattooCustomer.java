
public class TattooCustomer {
	private String name;
	private String tatoo;
	private int minutes;

	//Constructor
	public TattooCustomer(String name, String tatoo, int minutes){
		this.name=name;
		this.tatoo=tatoo;
		this.minutes =minutes;
	}
	//Method will get the name from TattooCustomer when called
	public String getName(){
		return name;
	}

	//Method will get the tattoo design from TattooCustomer when called

	public String getTattoo(){
		return tatoo;
	}

	//Method will get the time in minutes from TattooCustomer when called
	public int getMinutes(){
		return minutes;
	}
}
