package hr.in2.hackathon.projectbackend.models.DTO;


import hr.in2.hackathon.projectbackend.models.User;
import java.util.List;

public class UserDTO {

  public UserDTO(){}

  public UserDTO(User user, List<UserSpecialityDTO> specialities) {
    this.user = user;
    this.specialities = specialities;
  }

  private User user;

  private List<UserSpecialityDTO> specialities;
  private Integer level;

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<UserSpecialityDTO> getSpecialities() {
    return specialities;
  }

  public void setSpecialities(List<UserSpecialityDTO> specialities) {
    this.specialities = specialities;
  }
}
