import {Component, Input, OnInit} from '@angular/core';
import {Action} from "../../shared/models/action.model";

@Component({
  selector: 'app-action-detail',
  templateUrl: './action-detail.component.html',
  styleUrls: ['./action-detail.component.css']
})
export class ActionDetailComponent implements OnInit {

  @Input() act: Action;
  viewMode = false;

  constructor() { }

  ngOnInit() {
  }

  changeViewMode() {
    this.viewMode = !this.viewMode;
  }

}
