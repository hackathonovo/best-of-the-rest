package hr.in2.hackathon.projectbackend.repositories;

import hr.in2.hackathon.projectbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByCategory(String category);
}
