package hr.in2.hackathon.projectbackend.repositories;

import hr.in2.hackathon.projectbackend.models.Action;
import hr.in2.hackathon.projectbackend.models.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

  @Query("SELECT m FROM Message m WHERE action.id = :id")
  List<Message> findAllMessagesForAction(@Param("id")Integer id);

}
