package telran.persons.dto;

import java.time.LocalDate;

import telran.persons.api.Adress;

public class Child extends Person {
	String garten;

	public Child() {
	}

	public Child(int id, String name, Adress adress, LocalDate birthDate, String garten) {
		super(id, name, adress, birthDate);
		this.garten = garten;
	}

	public String getGarten() {
		return garten;
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + ", id=" + id + ", name=" + name + ", adress=" + adress + ", birthDate="
				+ birthDate + "]";
	}
	
	
}
