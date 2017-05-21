package hr.in2.hackathon.projectbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_speciality")
public class UserSpeciality {

  public UserSpeciality() {
  }

  public UserSpeciality(Integer userId, Integer specialityId, Integer level) {
    this.userId = userId;
    this.specialityId = specialityId;
    this.level = level;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private Integer userId;

  @Column
  private Integer specialityId;

  @Column
  private Integer level;

  public Integer getId() {
    return id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getSpecialityId() {
    return specialityId;
  }

  public void setSpecialityId(Integer specialityId) {
    this.specialityId = specialityId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

}