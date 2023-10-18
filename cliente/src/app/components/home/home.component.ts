import {Component} from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [
    RouterLink,
    RouterLinkActive,
    RouterOutlet
  ],
  standalone: true
})
export class HomeComponent {

}
