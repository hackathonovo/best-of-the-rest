package hr.in2.hackathon.projectbackend.models;

import hr.in2.hackathon.projectbackend.models.enums.ActionTypeEnum;
import hr.in2.hackathon.projectbackend.models.enums.UrgencyEnum;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "action")
public class Action {

  public Action(){
  }

  public Action(
          String heading,
          String description,
          Double actionLocationX,
          Double actionLocationY,
          Double baseLocationX,
          Double baseLocationY,
          String status,
          ZonedDateTime meetingTime,
          UrgencyEnum urgency,
          ActionTypeEnum actionType) {

    this.heading = heading;
    this.description = description;
    this.actionLocationX = actionLocationX;
    this.actionLocationY = actionLocationY;
    this.baseLocationX = baseLocationX;
    this.baseLocationY = baseLocationY;
    this.status = status;
    this.meetingTime = meetingTime;
    this.urgency = urgency;
    this.actionType = actionType;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String heading;
  @Column
  private String description;
  @Column
  private Double actionLocationX;
  @Column
  private Double actionLocationY;
  @Column
  private Double baseLocationX;
  @Column
  private Double baseLocationY;
  @Column
  private String status;
  @Column
  private ZonedDateTime meetingTime;
  @Column
  @Enumerated(EnumType.STRING)
  private UrgencyEnum urgency;
  @Column
  @Enumerated(EnumType.STRING)
  private ActionTypeEnum actionType;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHeading() {
    return heading;
  }

  public void setHeading(String heading) {
    this.heading = heading;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getActionLocationX() {
    return actionLocationX;
  }

  public void setActionLocationX(Double actionLocationX) {
    this.actionLocationX = actionLocationX;
  }

  public Double getActionLocationY() {
    return actionLocationY;
  }

  public void setActionLocationY(Double actionLocationY) {
    this.actionLocationY = actionLocationY;
  }

  public Double getBaseLocationX() {
    return baseLocationX;
  }

  public void setBaseLocationX(Double baseLocationX) {
    this.baseLocationX = baseLocationX;
  }

  public Double getBaseLocationY() {
    return baseLocationY;
  }

  public void setBaseLocationY(Double baseLocationY) {
    this.baseLocationY = baseLocationY;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ZonedDateTime getMeetingTime() {
    return meetingTime;
  }

  public void setMeetingTime(ZonedDateTime meetingTime) {
    this.meetingTime = meetingTime;
  }

    public UrgencyEnum getUrgency() {
        return urgency;
    }

    public void setUrgency(UrgencyEnum urgency) {
        this.urgency = urgency;
    }

    public ActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }
}
