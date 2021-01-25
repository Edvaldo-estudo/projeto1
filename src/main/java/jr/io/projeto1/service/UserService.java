package jr.io.projeto1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jr.io.projeto1.entity.User;
import jr.io.projeto1.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
	
		return userRepository.findAll();
	}
		
}
