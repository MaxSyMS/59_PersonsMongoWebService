package telran.persons.api;

public class Adress {

	String city;
	String street;
	int building;
	int apt;
	
	public Adress() {}

	public Adress(String city, String street, int building, int apt) {
		super();
		this.city = city;
		this.street = street;
		this.building = building;
		this.apt = apt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public int getApt() {
		return apt;
	}

	public void setApt(int apt) {
		this.apt = apt;
	}

	@Override
	public String toString() {
		return "Adress [city=" + city + ", street=" + street + ", building=" + building + ", apt=" + apt + "]";
	}
	
	
}
