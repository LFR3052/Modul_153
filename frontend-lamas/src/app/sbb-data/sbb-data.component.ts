import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { NotifierService } from '../notifier.service';
import { Ride } from '../ride';
import { RideService } from '../ride.service';



@Component({
  selector: 'app-sbb-data',
  templateUrl: './sbb-data.component.html',
  styleUrls: ['./sbb-data.component.scss']
})
export class SbbDataComponent implements OnInit {

  rides: Ride[] = [];
  zeit: any;
  key: string = 'id';
  reverse: boolean = false;
  p: number = 0;
  pageEvent: PageEvent;
  numberPages: number;
  stations: any;
  dates: any;
  selectedDate: Date;
  formGroup: FormGroup;
  filteredOptionsStations;
  filteredOptionsDates = [];
  where: number = 5;
  station: string;
  date: Date;
  displayedColums: string[] = ['id', 'betriebstag', 'ausfall', 'zusatzfahrt', 'ankunft',
    'ankunftprognose', 'ankunftprognosestatus', 'abfahrt', 'abfahrtprognose', 'abfahrtprognosestatus',
    'durchfahrt', 'ankunftsverspaetung', 'abfahrtsverspaetung', 'verkehrsmittel', 'linien', 'betreiber',
    'haltestellen',]


  constructor(public rideService: RideService, private fb: FormBuilder, private notifierService: NotifierService) { }

  ngOnInit(): void {
    this.getData();
    this.getTotalNumberPages();
    this.getStations();
    this.getDates();
    this.initForm();
  }

  reset() {
    this.selectedDate = null;
    this.ngOnInit();
  }

  search(station: string, selectedDate: Date) {
    if (station && selectedDate) {
      this.where = 1;
      this.getTrainsAndDates(this.p.toString(), selectedDate, station, this.where);
      this.getNumberOfStationAndDate(selectedDate, station, this.where);
      this.date = selectedDate;
      this.station = station;
    }
    else if (station) {
      this.where = 2;
      this.getTrainsByStation(this.p.toString(), station, this.where);
      this.getNumberOfStation(station, this.where);
      this.station = station;
    }
    else if (selectedDate) {
      this.where = 3;
      this.getTrainsByDate(this.p.toString(), selectedDate, this.where)
      this.getNumberOfDate(selectedDate, this.where);

      this.date = selectedDate;
    } else {
      this.notifierService.showNotificatoin();
      this.where = 4;
    }
  }

  onPaginateChange(event: PageEvent) {
    this.p = event.pageIndex;
    this.getDataFrom(this.where);
  }

  getDataFrom(where: number) {
    if (where === 1) {
      this.getTrainsAndDates(this.p.toString(), this.date, this.station, this.where);
    }
    else if (where === 2) {
      this.getTrainsByStation(this.p.toString(), this.station, this.where);
    }
    else if (where === 3) {
      this.getTrainsByDate(this.p.toString(), this.date, this.where)
    }
    else {
      this.getData();
    }

  }

  //Station
  initForm() {
    this.formGroup = this.fb.group({
      'Stations': ['']
    })
    this.formGroup.get('Stations').valueChanges.subscribe(res => {
      this.filterDataStations(res);
    })
  }

  filterDataStations(enteredData) {
    this.filteredOptionsStations = this.stations.filter(item => {
      return item.toLocaleLowerCase().match(enteredData.toLocaleLowerCase());
    })
  }

  //Get Data from Service
  getData() {
    this.rideService.getRide(this.p.toString()).subscribe((res) => {
      this.rides = res;
    })
  }

  getStations() {
    this.rideService.getAllStations().subscribe((res) => {
      this.stations = res;
      this.filteredOptionsStations = res;
    })
  }

  getDates() {
    this.rideService.getAllDates().subscribe((res) => {
      this.dates = res;
      this.filteredOptionsDates = res;
      this.filteredOptionsDates.push(' ')
    })
  }

  getTrainsByStation(number: string, station: string, where: number) {
    this.rideService.getTrainsAndOrDates(number, null, station, where).subscribe((res) => {
      this.rides = res;
    })
  }

  getTrainsByDate(number: string, date: Date, where: number) {
    this.rideService.getTrainsAndOrDates(number, date, null, where).subscribe((res) => {
      this.rides = res;
    })
  }

  getTrainsAndDates(number: string, date: Date, station: string, where: number) {
    this.rideService.getTrainsAndOrDates(number, date, station, where).subscribe((res) => {
      this.rides = res;
    })
  }

  getNumberOfStation(station: string, where: number) {
    this.rideService.countStationAndOrDate(null, station, where).subscribe((res) => {
      this.numberPages = res;
    })
  }

  getNumberOfDate(date: Date, where: number) {
    this.rideService.countStationAndOrDate(date, null, where).subscribe((res) => {
      this.numberPages = res;
    })
  }

  getNumberOfStationAndDate(date: Date, station: string, where: number) {
    this.rideService.countStationAndOrDate(date, station, where).subscribe((res) => {
      this.numberPages = res;
    })
  }

  getTotalNumberPages() {
    this.rideService.countStationAndOrDate(null, null, null).subscribe((res) => {
      this.numberPages = res;
    })
  }

}
