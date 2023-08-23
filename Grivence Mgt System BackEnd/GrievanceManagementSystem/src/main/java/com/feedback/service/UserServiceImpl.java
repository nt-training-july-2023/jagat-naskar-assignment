package com.feedback.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feedback.entities.User;
import com.feedback.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		//return userRepository.getById(id);
		return userRepository.findById(id).get();
	}
	
	@Override
	public Boolean getByUserAndPassword(String userName, String password){
		User u1=null;
		System.out.println(userName);
		System.out.println(password);
		try {
			System.out.println(1);
				u1= userRepository.getUserByUsername(userName);
				System.out.println(u1);
				if(password.equals(u1.getPassword()))
					return true;
		}catch(Exception e) {
			System.out.println("User not found");
		}
		
		return false;
	}
	@Override
	public Boolean deleteUser(Integer id) {
		return true;
		
	}
	
	
}
