import { Component, OnInit } from '@angular/core';
import {Action} from "../../shared/models/action.model";
import {ActionService} from "../../shared/services/action.service";

@Component({
  selector: 'app-actions',
  templateUrl: './actions.component.html',
  styleUrls: ['./actions.component.css']
})
export class ActionsComponent implements OnInit {

  actions: Action[];
  constructor(private  actionService: ActionService) { }

  ngOnInit() {
    this.actionService.getAllActions()
      .subscribe(
        (actions: Action[]) => this.actions = actions
      );
  }

}
