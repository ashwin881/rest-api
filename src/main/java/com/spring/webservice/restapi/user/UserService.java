package com.spring.webservice.restapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;



@Component
public class UserService {

	
	private static List<User> users = new ArrayList<User>();
	private static int counter = 0;
	static {
		users.add(new User(++counter,"Ashwin",LocalDate.now().minusYears(20)));
		users.add(new User(++counter,"Sudha",LocalDate.now().minusYears(45)));
		users.add(new User(++counter,"sathya",LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAll(){
		return users;
	}
//	public User save(User user) {
//		user.setId(++counter);
//		users.add(user);
//		return user;
//	}
	
	public User save(User user) {
	user.setId(++counter);
	users.add(user);
	return user;
	}
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

	
	public User findOne(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
    	return users.stream().filter(predicate).findFirst().orElse(null);
    }
	
}
