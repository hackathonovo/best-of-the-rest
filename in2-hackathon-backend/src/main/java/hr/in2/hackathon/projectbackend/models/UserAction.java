package hr.in2.hackathon.projectbackend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_action")
public class UserAction {

  public UserAction() {
  }

  public UserAction(Integer userId, Integer actionId, boolean response) {
    this.userId = userId;
    this.actionId = actionId;
    this.response = response;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private Integer userId;

  @Column
  private Integer actionId;

  @Column
  private boolean response;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getActionId() {
    return actionId;
  }

  public void setActionId(Integer actionId) {
    this.actionId = actionId;
  }

  public boolean isResponse() {
    return response;
  }

  public void setResponse(boolean response) {
    this.response = response;
  }
}
