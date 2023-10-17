import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AbstractControlOptions, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
  }

  get form() {
    return this.registerForm.controls;
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group(
      {
        email: ["", [Validators.required, Validators.email]],
        password: ["", [Validators.required, Validators.minLength(3)]]
      }
    );
  }

  onSubmit() {
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    this.authService.login(this.registerForm.value).subscribe({
      next: value => {
        if (value.status == 200)
          console.log(value.body)
        else
          console.log('no existe');
      },
      error: err => {
        console.log(err)
      }
    })
  }

}
