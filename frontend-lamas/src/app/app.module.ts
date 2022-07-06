import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { SbbDataComponent } from './sbb-data/sbb-data.component';
import { StatisticComponent } from "./statistic/statistic.component";
import { DelayPerLineComponent } from './statistic/statistic-per-line/delay-per-line/delay-per-line.component';
import { AverageDelayPerLineComponent } from './statistic/statistic-per-line/average-delay-per-line/average-delay-per-line.component';
import { DelayPerStopComponent } from './statistic/statistic-per-stop/delay-per-stop/delay-per-stop.component';
import { AverageDelayPerStopComponent } from './statistic/statistic-per-stop/average-delay-per-stop/average-delay-per-stop.component';
import { DelayPerTransportComponent } from './statistic/statistic-per-transport/delay-per-transport/delay-per-transport.component';
import { AverageDelayPerTransportComponent } from './statistic/statistic-per-transport/average-delay-per-transport/average-delay-per-transport.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { NgxChartsModule } from '@swimlane/ngx-charts';



@NgModule({
  declarations: [
    AppComponent,
    SbbDataComponent,
    StatisticComponent,
    DelayPerLineComponent,
    AverageDelayPerLineComponent,
    DelayPerStopComponent,
    AverageDelayPerStopComponent,
    DelayPerTransportComponent,
    AverageDelayPerTransportComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    Ng2OrderModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatSnackBarModule,
    MatIconModule,
    MatSelectModule,
    MatInputModule,
    NgxChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
