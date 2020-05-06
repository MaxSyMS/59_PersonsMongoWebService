package telran.persons.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.persons.api.Adress;
import telran.persons.domain.dao.PersonsRepository;
import telran.persons.dto.Child;
import telran.persons.dto.Employee;
import telran.persons.dto.Person;
import telran.persons.exceptions.PersonNotFoundException;
import telran.persons.service.interfaces.IPersons;

@Service
public class PersonsMongo implements IPersons {
	@Autowired
	PersonsRepository personsRepository;

	Map<String, Integer> gartens = new HashMap<>();

	@Override
	public Person getPerson(int id) {
		return personsRepository.findById(id).orElseThrow(PersonNotFoundException::new);
	}

	@Override
	public List<Person> getPersonsAges(int ageFrom, int ageTo) {
		return personsRepository.findByBirthDateBetween(
				LocalDate.ofYearDay(LocalDate.now().minusYears(ageTo).getYear(), 1),
				LocalDate.ofYearDay(LocalDate.now().minusYears(ageFrom).getYear(), 1));
	}

	@Override
	public boolean updateAddress(int id, Adress adress) {
		Person person = getPerson(id);
		if (person != null) {
			person.setAdress(adress);
			personsRepository.save(person);
			return true;
		}
		return false;
	}

	@Override
	public List<Person> getChildren(String city, String garten) {
		return personsRepository.findByAdressCityAndGarten(city, garten);
	}

	@Override
	public List<Person> getEmployeesSalary(int salaryFrom, int salaryTo) {
		return personsRepository.findBySalaryBetween(salaryFrom, salaryTo);
	}

	@Override
	public List<Person> getEmployeesBigSalary() {
		double avarageSalary = personsRepository.findAllBy()
				.filter(p -> p instanceof Employee)
				.collect(Collectors.averagingInt(p -> ((Employee) p).getSalary()));
//		System.out.println(avarageSalary);
		return personsRepository.findBySalaryGreaterThan(avarageSalary);
	}

	@Override
	public List<String> mostPopularGartens(String city) {
		//Tut dolzhna bit proverka na city
		List<String> gartenStrings = personsRepository.findAllBy()
				.filter(p -> p instanceof Child)
				.filter(c -> c.getAdress().getCity().equals(city))
				.map(c -> ((Child) c).getGarten())
				.collect(Collectors.toList());

		return sortGartens(gartenStrings);

	}

	private List<String> sortGartens(List<String> gartens) {
		for (String garten : gartens) {
			System.out.println(garten);
			if (!this.gartens.containsKey(garten)) {
				this.gartens.put(garten, 1);
			} else {
				int value = this.gartens.remove(garten);
				this.gartens.put(garten, ++value);
				value = 0;
			};
		}
		List<Map.Entry<String, Integer>> unsortedList = new LinkedList<>(this.gartens.entrySet());

		Collections.sort(unsortedList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		List<String> sortedList = new LinkedList<>();
		for (Map.Entry<String, Integer> entry : unsortedList) {
			sortedList.add(entry.getKey());
		}
		
		//SELF CHECK
//		for (Map.Entry<String, Integer> entry : unsortedList) {
//			System.out.println(entry.getKey()+" "+ entry.getValue());
//		}

		return sortedList;
	}

}
