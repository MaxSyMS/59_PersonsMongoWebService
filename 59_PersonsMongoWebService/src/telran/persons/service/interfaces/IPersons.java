package telran.persons.service.interfaces;

import java.util.*;
import telran.persons.api.*;
import telran.persons.dto.*;

public interface IPersons {
	Person getPerson(int id);
	List<Person> getPersonsAges(int ageFrom, int ageTo);
	boolean updateAddress(int id, Adress adress);
	List<Person> getChildren(String city, String garten);
	List<Person> getEmployeesSalary(int salaryFrom, int salaryTo);
	List<Person> getEmployeesBigSalary();//employees with salary greater than average
	List<String> mostPopularGartens(String city);

}
