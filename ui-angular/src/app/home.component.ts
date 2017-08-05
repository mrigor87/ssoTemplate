import {Component} from '@angular/core';
import {AppService} from './app.service'

@Component({
  selector: 'home-header',
  providers: [AppService],
  template: `

    <div class="container">
      <button *ngIf="!isLoggedIn" class="btn btn-primary" (click)="login()" type="submit">Login</button>
      <div *ngIf="isLoggedIn" class="content">
        <div class="container">You are logged as {{userName}}</div>  
        <div class="container">
          <a class="btn btn-default pull-right" (click)="logout()" href="#">Logout</a>
        </div>
        <h2 class="title">List of candidates</h2>
        <ul class="list-group" id='candidate-listening'>
          <li class="list-group-item" *ngFor='let dat of data'>{{dat.fullName}}</li>
        </ul>

      </div>
    </div>`
})

export class HomeComponent {

  public data = [];
  public userName;

  public isLoggedIn = false;

  constructor(private _service: AppService) {
  }

  ngOnInit() {
    console.log('@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@');
    console.log(this._service.getToken());
    this.isLoggedIn = this._service.isLoggedIn();
    this._service.getResources('http://localhost:8082/resource-server/rest/candidates')
      .subscribe(d => {
        this.data = d;
        console.log(d);
      });
    console.log('++++++++++++++++++++++++++++++++++');
    this._service.consoleView1();
    console.log('++++++++++++++++++++++++++++++++++');
    this._service.getResource('http://localhost:8081/auth/user/me')
      .subscribe(d => {
        this.userName = d.name
      });
    console.log('------------------------------------------------');
  }

  login() {
    this._service.obtainAccessToken();
    // this._service.consoleView();
  }

  logout() {
    this._service.logout();
  }
}
