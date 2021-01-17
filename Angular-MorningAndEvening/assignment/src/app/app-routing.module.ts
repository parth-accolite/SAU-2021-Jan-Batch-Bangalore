import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Part1Component } from './part1/part1.component';
import { Part2Component } from './part2/part2.component';

const routes: Routes = [
  { path: "part2", component: Part2Component },
  { path: "", component: Part1Component },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
