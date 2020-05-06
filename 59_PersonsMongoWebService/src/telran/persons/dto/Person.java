package telran.persons.dto;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import telran.persons.api.Adress;


@Document(collection="persons_part1")
public class Person{
@Id
int id;
String name;
Adress adress;//transient Adress adress;
LocalDate birthDate;

public Person() {}

public Person(int id, String name, Adress adress, LocalDate birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.adress = adress;
	this.birthDate = birthDate;
}

public int getId() {
	return id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Adress getAdress() {
	return adress;
}

public void setAdress(Adress adress) {
	this.adress = adress;
}

public LocalDate getBirthDate() {
	return birthDate;
}

@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", adress=" + adress + ", birthDate=" + birthDate + "]";
}

	
}
