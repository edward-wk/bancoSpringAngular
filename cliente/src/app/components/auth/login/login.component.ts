import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  get form() {
    return this.registerForm.controls;
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group(
      {
        email: ["1@1", [Validators.required, Validators.email]],
        password: ["pass1", [Validators.required, Validators.minLength(3)]]
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
        if (value.status == 200) {
          console.log('bien');
          this.router.navigate(['/'])
            .catch(reason => {
            })
            .then(() => {
            })
            .finally(() => {
            })
        }
      },
      error: err => {
        console.log('xxxx', err)
      }
    })
  }

}
