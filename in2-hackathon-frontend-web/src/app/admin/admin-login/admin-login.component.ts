import {Component, OnInit} from "@angular/core";
import {AuthorizationService} from "../../shared/services/authorization.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  model = {email: null, password: null};
  submitted = false;
  errorMessage: string;

  constructor(private authorizationService: AuthorizationService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.model.email);
    console.log(this.model.password);
    this.authorizationService.adminLogin();
    this.router.navigate(['/admin', 'dashboard']);
  }

}
