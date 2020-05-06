package telran.persons.domain.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.persons.dto.Person;

public interface PersonsRepository extends MongoRepository<Person, Integer> {

	@Query(sort = "{ birthDate : -1 }")
	List<Person> findByBirthDateBetween(LocalDate ofYearDay, LocalDate ofYearDay2);

	//Tak ne rabotaet
//	@Query("{'city' : ?0, 'garten' : ?1}")
//	List<Person>findByAdressCityAndGarten(String city, String garten);
	
	@Query("{'adress.city' : ?0, 'garten' : ?1}")
	List<Person> findByAdressCityAndGarten(String city, String garten);
	
	@Query("{'salary' : {'$gte' : ?0, '$lte' : ?1}}")
	List<Person> findBySalaryBetween(int salaryFrom, int salaryTo);
	
	Stream<Person>findAllBy();
	
	
	@Query("{'salary' : {$gt : ?0}}")
	List<Person> findBySalaryGreaterThan(double avarage);
	


}
