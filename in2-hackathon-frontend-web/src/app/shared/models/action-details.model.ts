import {Action} from "./action.model";
import {User} from "./user.model";
import {Message} from "./message.model";

export class ActionDetails {
  action: Action;
  users: User[];
  messages: Message[];

  constructor() {
    this.action = new Action();
    this.users = [];
    this.messages = [];
  }
}
