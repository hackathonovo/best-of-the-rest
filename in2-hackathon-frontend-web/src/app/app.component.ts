import {Component} from "@angular/core";
import {AlertService} from "./shared/services/alert.service";
import {SlimLoadingBarService} from "ng2-slim-loading-bar";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    private alertService: AlertService,
    private slimLoadingBarService: SlimLoadingBarService) {
  }

  onAlert() {
    this.alertService.success('Hello world');
  }

  startLoading() {
    this.slimLoadingBarService.start(() => {
      console.log('Loading complete');
    });
  }

  stopLoading() {
    this.slimLoadingBarService.stop();
  }

  completeLoading() {
    this.slimLoadingBarService.complete();
  }
}
