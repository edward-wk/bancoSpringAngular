import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {
  AbstractControlOptions,
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators
} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  registerForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group(
      {
        nombre: ["", Validators.required],
        apellido1: ["", Validators.required],
        apellido2: ["", Validators.required],
        nif: ["", Validators.required],
        telefono: ["", Validators.required],
        email: ["", [Validators.required, Validators.email]],
        password: ["", [Validators.required, Validators.minLength(6)]],
        repeatPass: ["", Validators.required]
      },
      {
        validator: this.mustMatch("password", "repeatPass") // Validando
      } as AbstractControlOptions
    );
  }

  // custom validator to check that two fields match
  mustMatch(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];

      if (matchingControl.errors && !matchingControl.errors.mustMatch) {
        // return if another validator has already found an error on the matchingControl
        return;
      }

      // set error on matchingControl if validation fails
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({mustMatch: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

  // convenience getter for easy access to form fields
  get form() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    delete this.registerForm.controls['repeatPass'];

    this.authService.register(this.registerForm.value).subscribe({
      next: value => {
        console.log('registro completado');
      }
    })
  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
  }
}
