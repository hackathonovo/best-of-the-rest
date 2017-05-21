package hr.in2.hackathon.projectbackend.repositories;

import hr.in2.hackathon.projectbackend.models.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer>{

    @Query("SELECT s FROM Speciality s WHERE s.id = :id")
    Speciality findOneBySpecialityId(@Param("id") Integer specialityId);
}
