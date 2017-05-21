import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";

import {Http} from "@angular/http";
import {API_BASE} from "../app.constants";
import "rxjs/add/operator/map";
import {Action} from "../models/action.model";
import {ActionDetails} from "../models/action-details.model";

@Injectable()
export class ActionService {

  constructor(private http: Http) {}

  getAllActions(): Observable<Action[]> {
    return this.http.get(API_BASE + '/actions')
      .map(response => <Action[]>response.json());
  }

  createAction(action: Action) {
    return this.http.post(API_BASE + '/actions', action);
  }

  updateAction(id: number, action: Action) {
    return this.http.put(API_BASE + '/actions/' + id, action);
  }

  getAction(id: number) {
    return this.http.get(API_BASE + '/actions/' + id)
      .map(response => <Action>response.json());
  }

  getActionDetails(id: number): Observable<ActionDetails> {
    return this.http.get(API_BASE + '/actions/' + id + '/details')
      .map(response => {
        return <ActionDetails>response.json();
      });
  }

}
