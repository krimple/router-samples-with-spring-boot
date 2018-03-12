import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

interface Course {
  id: number;
  title: string;
  description: string;
}

@Component({
  selector: 'app-container',
  template: `
    <div class="ui container">
      <h1>App</h1>
      <div>
        <a routerLink="customer">Customer</a> |
        <a routerLink="customermanagement">Management</a> |
        <a routerLink="salesperson">Sales People</a>
      </div>
      <router-outlet></router-outlet>
      {{ courses | async | json }}
    </div>
  `,
  styles: [``]
})
export class ContainerComponent implements OnInit {

  courses: Observable<Course[]>;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.courses = this.httpClient.get<Course[]>('http://localhost:8080/course');
      //headers: {
      //  'Origin': 'http://localhost:4200',
      //  'Access-Control-Request-Method': 'GET'
      // }
    // });
  }

}
