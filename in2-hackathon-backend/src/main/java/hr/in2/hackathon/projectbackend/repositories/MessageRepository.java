package hr.in2.hackathon.projectbackend.repositories;


import hr.in2.hackathon.projectbackend.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("SELECT m FROM Message m WHERE m.action.id = :id ORDER BY m.createdAt")
    List<Message> findAllByActionId(@Param("id") Integer actionId);
}
