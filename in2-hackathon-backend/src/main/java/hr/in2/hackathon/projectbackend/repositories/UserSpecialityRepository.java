package hr.in2.hackathon.projectbackend.repositories;

import hr.in2.hackathon.projectbackend.models.UserSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserSpecialityRepository extends JpaRepository<UserSpeciality, Integer> {

    @Query("SELECT ue FROM UserSpeciality ue where ue.userId = :id")
    List<UserSpeciality> findAllSpecialitiesOfUser(@Param("id") Integer userId);

    @Query("SELECT ue FROM UserSpeciality ue where ue.specialityId = :id")
    List<UserSpeciality> findAllUsersOfSpeciality(@Param("id") Integer userId);

    @Query("DELETE FROM UserSpeciality us WHERE us.userId = :id")
    @Modifying
    @Transactional
    void deleteAllSpecialitiesByUser(@Param("id") Integer userId);

    List<UserSpeciality> findAllByLevelGreaterThan(Integer level);

}
