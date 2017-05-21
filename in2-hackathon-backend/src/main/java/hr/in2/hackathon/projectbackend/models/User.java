package hr.in2.hackathon.projectbackend.models;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  public User(){
  }

  public User(String firstName, String lastName, Double homeLocationX, Double homeLocationY,
      Double workLocationX, Double workLocationY, ZonedDateTime availableFrom,
      ZonedDateTime availableTo, String category, String contact, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.homeLocationX = homeLocationX;
    this.homeLocationY = homeLocationY;
    this.workLocationX = workLocationX;
    this.workLocationY = workLocationY;
    this.availableFrom = availableFrom;
    this.availableTo = availableTo;
    this.category = category;
    this.contact = contact;
    this.email = email;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private Double homeLocationX;
  @Column
  private Double homeLocationY;
  @Column
  private Double workLocationX;
  @Column
  private Double workLocationY;
  @Column
  private ZonedDateTime availableFrom;
  @Column
  private ZonedDateTime availableTo;
  @Column
  private String category;
  @Column
  private String contact;
  @Column
  private String email;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Double getHomeLocationX() {
    return homeLocationX;
  }

  public void setHomeLocationX(Double homeLocationX) {
    this.homeLocationX = homeLocationX;
  }

  public Double getHomeLocationY() {
    return homeLocationY;
  }

  public void setHomeLocationY(Double homeLocationY) {
    this.homeLocationY = homeLocationY;
  }

  public Double getWorkLocationX() {
    return workLocationX;
  }

  public void setWorkLocationX(Double workLocationX) {
    this.workLocationX = workLocationX;
  }

  public Double getWorkLocationY() {
    return workLocationY;
  }

  public void setWorkLocationY(Double workLocationY) {
    this.workLocationY = workLocationY;
  }

  public ZonedDateTime getAvailableFrom() {
    return availableFrom;
  }

  public void setAvailableFrom(ZonedDateTime availableFrom) {
    this.availableFrom = availableFrom;
  }


  public ZonedDateTime getAvailableTo() {
    return availableTo;
  }

  public void setAvailableTo(ZonedDateTime availableTo) {
    this.availableTo = availableTo;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }
}
