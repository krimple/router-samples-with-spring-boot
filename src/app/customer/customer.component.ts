import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  template: `
    <p>
      customer works!
    </p>
    <router-outlet>>Another child</router-outlet>
  `,
  styles: []
})
export class CustomerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
