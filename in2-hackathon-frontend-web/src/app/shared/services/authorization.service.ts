import {Injectable} from "@angular/core";
import {User} from "../models/user.model";
import {Http} from "@angular/http";
import {Subject} from "rxjs/Subject";
import {AlertService} from "./alert.service";

@Injectable()
export class AuthorizationService {
  loggedUser: User;
  loggingSubject = new Subject<User>();

  constructor(private http: Http, private alertService: AlertService) {}

  login(email: string, password: string) {
  }
  adminLogin() {
    const user = new User();
    user.firstName = 'Ivan';
    user.lastName = 'Horvat';
    this.loggedUser = user;
    this.loggingSubject.next(this.loggedUser);
    localStorage.setItem('user', JSON.stringify(this.loggedUser));
    this.alertService.success('Logged in');
  }
}
