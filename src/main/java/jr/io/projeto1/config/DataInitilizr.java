package jr.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import jr.io.projeto1.entity.User;
import jr.io.projeto1.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Carrega na inicialização");
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			createUser("Jr", "jr@gmail.com");
			createUser("Jr2", "jr2@gmail.com");
			createUser("Jr3", "jr3@gmail.com");

		}
		
		User user = userRepository.findByNameIgnoreCase("jr2");
		//User user = userRepository.findByEmail("jr2@gmail.com");
		//User user = userRepository.findByNameQualquerCoisa("r alterad");
		
		//user.setName("Jr alterado");
		//userRepository.save(user);
		
		System.out.println(user.getName());
	}
	
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}
