import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListAccountsComponent} from "./components/account/list-accounts/list-accounts.component";
import {ListUserComponent} from "./components/user/list-user/list-user.component";
import {HomeComponent} from "./components/home/home.component";
import {DetailAccountComponent} from "./components/account/detail-account/detail-account.component";
import {SignupComponent} from "./components/auth/signup/signup.component";
import {LoginComponent} from "./components/auth/login/login.component";

const routes: Routes = [
  {
    path: 'index',
    redirectTo: '',
    component: HomeComponent
  },
  {
    path: 'detailAccount',
    component: DetailAccountComponent
  },
  {
    path: 'listAccounts',
    component: ListAccountsComponent
  },
  {
    path: 'listUsers',
    component: ListUserComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
