import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  loginFormErrors: any;
  user: any; //= new Login();


  constructor(private _formBuilder: FormBuilder,
    private router: Router,
    private _authentication: AuthenticationService) { }

  ngOnInit() {
    this.loginForm = this._formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  login() {
    this._authentication.doLogin(this.loginForm.getRawValue()).subscribe((response) => {
      if (response) {
        this.storeUserIdentity(response);
        this.router.navigate(['/retail-home']);
      }
    })
  }

  storeUserIdentity(userIdentity: any): void {
    localStorage.setItem('userIdentity', JSON.stringify(userIdentity));
  }

}
