package hr.in2.hackathon.projectbackend.repositories;

import hr.in2.hackathon.projectbackend.models.UserAction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionRepository extends JpaRepository<UserAction, Integer>{

  @Query("SELECT ua FROM UserAction ua where ua.userId = :id")
  List<UserAction> findAllActionsForUser(@Param("id") Integer userId);

  List<UserAction> findAllByActionIdAndResponse(Integer actionId, Boolean response);

}
