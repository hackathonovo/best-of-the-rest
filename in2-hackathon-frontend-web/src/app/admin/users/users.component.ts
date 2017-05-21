import {Component, OnInit} from "@angular/core";
import {UserService} from "../../shared/services/user.service";
import {User} from "../../shared/models/user.model";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAllUsers()
      .subscribe(
        (users: User[]) => this.users = users
      );
  }

}
