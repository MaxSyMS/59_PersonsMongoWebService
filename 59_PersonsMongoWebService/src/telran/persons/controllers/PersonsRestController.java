package telran.persons.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.persons.api.Adress;
import telran.persons.api.ApiConstants;
import telran.persons.dto.Person;
import telran.persons.service.interfaces.IPersons;

@RestController
public class PersonsRestController {
	@Autowired
	IPersons persons;
	
	@GetMapping(value = ApiConstants.GET_PERSON_BY_ID+"/{id}")
	Person getPerson(@PathVariable("id") int id) {
		return persons.getPerson(id);
	}
	
	@GetMapping(value = ApiConstants.GET_PERSONS_AGES_BETWEEN)
	List<Person> getPersonsAges(@RequestParam("ageFrom") int ageFrom, @RequestParam("ageTo") int ageTo){
		return persons.getPersonsAges(ageFrom, ageTo);	
	}
	
	@PutMapping(value = ApiConstants.UPDATE_ADDRESS+"/{id}")
	boolean updateAddress(@PathVariable("id") int id, @RequestBody Adress adress) {
		return persons.updateAddress(id, adress);
	}
	
	@GetMapping(value = ApiConstants.GET_CHILDREN_BY_CITY_GARTEN)
	List<Person> getChildren(@RequestParam("city") String city, @RequestParam("garten")String garten){
		return persons.getChildren(city, garten);
	}
	
	@GetMapping(value = ApiConstants.MOST_POPULAR_GARTENS)
	List<String> getMostPopularGartens(@RequestParam("city")String city){
		return persons.mostPopularGartens(city);
	}
	
	@GetMapping(value = ApiConstants.EMPLOYEES_BIG_SALARY)
	List<Person> getEmployeesBigSalary(){
		return persons.getEmployeesBigSalary();
	}
	
	@GetMapping(value = ApiConstants.GET_EMLOYEES_SALARY_BETWEEN)
	List<Person> getEmployeesSalary(@RequestParam("salaryFrom") int salaryFrom, @RequestParam("salaryTo")int salaryTo){
		return persons.getEmployeesSalary(salaryFrom, salaryTo);
	}
	
}
