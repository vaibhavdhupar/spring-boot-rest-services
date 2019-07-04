package com.smugglr.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Vaibhav", new Date()));
		users.add(new User(2, "Bhavesh", new Date()));
		users.add(new User(3, "Payal", new Date()));
	}
	
	public List<User> finalAll(){
		return users;
	}
	
	public User save(User user) {
		
		if(0 == user.getId()) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	
	public User findOne(int id) {
		for(User user: users) {
			if(id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user =  iterator.next();
			if(id == user.getId()) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
