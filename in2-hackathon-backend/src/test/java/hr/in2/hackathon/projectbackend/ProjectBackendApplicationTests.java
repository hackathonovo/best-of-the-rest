package hr.in2.hackathon.projectbackend;

import hr.in2.hackathon.projectbackend.models.User;
import hr.in2.hackathon.projectbackend.repositories.UserRepository;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectBackendApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	public void contextLoads() {
	}


	@Test
	public void test() {
		User user = new User();
		user.setFirstName("Mate");
		user.setLastName("Matic");
		user.setCategory("INTERN");
		user.setAvailableFrom(ZonedDateTime.now());
		user.setAvailableTo(ZonedDateTime.now());
		user.setHomeLocationX(20.);
		user.setHomeLocationY(30.);
		user.setWorkLocationX(40.);
		user.setWorkLocationY(50.);
		user.setContact("09968277777");
		user.setEmail("edi@edi.com");
		userRepository.save(user);
	}

}
