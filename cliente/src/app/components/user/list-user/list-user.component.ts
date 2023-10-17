import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {UserService} from "../../../services/user.service";
import {User} from "../../../models/User";
import {environment} from "../../../../environments/environments";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css'],
  standalone: true,
  imports: [MatTableModule, MatPaginatorModule, CommonModule],
})
export class ListUserComponent implements AfterViewInit {
  displayedColumns: string[] = ['ID', 'Tipo Usuario', 'DNI/NIE', 'Nombre', 'Apellidos', 'Email', 'Telefono'];
  dataSource: any;

  constructor(private userService: UserService) {
  }

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.userService.getAllUsers()?.subscribe({
      next: value => {
        console.log(value);
        this.dataSource = new MatTableDataSource<User>(value);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  protected readonly environment = environment;
}
