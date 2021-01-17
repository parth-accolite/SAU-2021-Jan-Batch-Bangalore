import { Component, OnInit } from '@angular/core';
import { SessionService } from "../session.service";
@Component({
  selector: 'app-part2',
  templateUrl: './part2.component.html',
  styleUrls: ['./part2.component.css']
})
export class Part2Component implements OnInit {
  todos: Object;
  singleTodos: any;
  showAllTodos: boolean;
  constructor(private session: SessionService) {
    this.showAllTodos = true;
  }

  getApiValue(id: string) {
    this.session.getDataByID(parseInt(id)).subscribe((item) => {
      this.singleTodos = [item];
      this.showAllTodos = false;
    });
  }
  setShowAllTodos() {
    this.showAllTodos = true;
    this.singleTodos = [];
  }
  ngOnInit() {
    this.showAllTodos = true;

    this.session.getData().subscribe((item) => {
      this.todos = item;
    });
  }

}
