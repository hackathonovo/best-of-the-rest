import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {User} from "../models/user.model";
import {Http} from "@angular/http";
import {API_BASE} from "../app.constants";
import "rxjs/add/operator/map";
import {UserDto} from "../../user-new/user-dto.model";
import {Subject} from "rxjs/Subject";
import {isNullOrUndefined} from "util";

@Injectable()
export class UserService {

  filteringSubject = new Subject<User[]>();

  constructor(private http: Http) {}

  getAllUsers(): Observable<User[]> {
    return this.http.get(API_BASE + '/users')
      .map(response => <User[]>response.json());
  }

  createUser(user: UserDto) {
    return this.http.post(API_BASE + '/users', user);
  }

  updateUser(id: number, user: UserDto) {
    return this.http.put(API_BASE + '/users/' + id, user);
  }

  getUser(id: number) {
    return this.http.get(API_BASE + '/users/' + id)
      .map(response => <User>response.json());
  }

  filterUser(category: string, speciality: string, level: number) {
    let url: string = API_BASE;
    category = isNullOrUndefined(category) ? '' : category;
    speciality = isNullOrUndefined(speciality) ? '' : speciality;
    const lvl: string = isNullOrUndefined(level) ? '' : level.toString();

    url += '/users/filter?category=' + category + '&speciality=' + speciality + '&level=' + lvl;

    this.http.get(url)
      .subscribe(res => {
        if (res.status === 200) {
          this.filteringSubject.next(<User[]>res.json());
        }
      });
  }

}
