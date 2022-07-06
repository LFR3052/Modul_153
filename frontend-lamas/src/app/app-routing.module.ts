import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SbbDataComponent } from './sbb-data/sbb-data.component';
import { StatisticComponent } from './statistic/statistic.component';

const routes: Routes = [
  { path: '', component: SbbDataComponent},
  { path: 'statistics', component: StatisticComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
