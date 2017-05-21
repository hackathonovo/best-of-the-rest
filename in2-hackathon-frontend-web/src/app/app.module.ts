import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {AlertService} from "./shared/services/alert.service";
import {AlertComponent} from "./shared/components/alert/alert.component";
import {SlimLoadingBarModule} from "ng2-slim-loading-bar";
import {AdminLoginComponent} from "./admin/admin-login/admin-login.component";
import {AuthorizationService} from "./shared/services/authorization.service";
import {DashboardComponent} from "./admin/dashboard/dashboard.component";
import {LoginComponent} from "./login/login.component";
import {UsersComponent} from "./admin/users/users.component";
import {UserService} from "./shared/services/user.service";
import {UserDetailComponent} from "./user-detail/user-detail.component";
import {CommonModule} from "@angular/common";
import {AgmCoreModule} from "angular2-google-maps/core";
import {Route, RouterModule} from "@angular/router";
import {UserNewComponent} from "./user-new/user-new.component";
import {Ng2DatetimePickerModule} from "ng2-datetime-picker";
import {ActionService} from "./shared/services/action.service";

import {SpecialityService} from "./shared/services/speciality.service";
import {ActionNewComponent} from "./admin/action-new/action-new.component";
import {ActionsComponent} from "./admin/actions/actions.component";
import {ActionDetailComponent} from "./admin/action-detail/action-detail.component";
import {LookupTableComponent} from "./lookup-table/lookup-table.component";
import {ActionUberViewComponent} from "./action-uber-view/action-uber-view.component";

const appRoutes: Route[] = [
  {path: 'admin/login', component: AdminLoginComponent},
  {path: 'admin/dashboard', component: DashboardComponent},
  {path: 'login', component: LoginComponent},
  {path: 'actions', component: ActionsComponent},
  {path: 'action/new', component: ActionNewComponent},
  {path: 'action/:id/edit', component: ActionNewComponent},
  {path: 'action/:id', component: ActionUberViewComponent},
  {path: 'admin/users', component: UsersComponent},
  {path: 'admin/users/new', component: UserNewComponent},
  {path: 'admin/users/:id/edit', component: UserNewComponent},
  {path: 'specialities', component: LookupTableComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AlertComponent,
    AdminLoginComponent,
    DashboardComponent,
    LoginComponent,
    UsersComponent,
    ActionNewComponent,
    UserDetailComponent,
    UserNewComponent,
    ActionsComponent,
    ActionDetailComponent,
    LookupTableComponent,
    ActionUberViewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    SlimLoadingBarModule.forRoot(),
    CommonModule,
    Ng2DatetimePickerModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAvAwOJrcgOIuS6rCsUTc4fFQCxYC3rwBk'
    })
  ],
  providers: [AlertService, AuthorizationService, UserService, ActionService, SpecialityService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
