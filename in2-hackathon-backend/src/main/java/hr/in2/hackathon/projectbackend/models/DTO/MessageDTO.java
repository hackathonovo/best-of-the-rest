package hr.in2.hackathon.projectbackend.models.DTO;

import hr.in2.hackathon.projectbackend.models.enums.MessageTypeEnum;

public class MessageDTO {

  public Integer userId;
  public Integer actionId;
  public String  messageText;
  public MessageTypeEnum messageType;
}
