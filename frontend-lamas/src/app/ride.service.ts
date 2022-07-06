import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ride } from './ride';

@Injectable({
  providedIn: 'root'
})
export class RideService {

    constructor(private http: HttpClient) { }

    private _url: string = "http://localhost:8080/api/v1/trains";
    getRide(page: string) {
        return this.http.get<Ride[]>(this._url + "?page=" +  page);
    }

    getAllStations(){
      return this.http.get<any>(this._url + "/allStations");
    }

    getAllDates(){
      return this.http.get<any>(this._url + "/allDates");
    }
    
    getTrainsAndOrDates(number: string, date: Date, station: string, where: number){
      const _baseUrl = this._url + "/byStationAndOrDate?";

      if (where === 1) {
        return this.http.get<any>(_baseUrl + "date=" + date + "&page=" + number + "&station=" + station);
      }
      else if (where === 2) {
        return this.http.get<any>(_baseUrl + "page="  + number + "&station=" + station);
      }else{
        return this.http.get<any>(_baseUrl + "date="  + date + "&page=" + number);
      }
    }

    countStationAndOrDate(date: Date, station: string, where: number){
      const _baseUrl = this._url + "/count/allTrainsByStationAndOrDate";

      if (where === 1) {
        return this.http.get<any>(_baseUrl + "?date=" + date +  "&station=" + station);
      }
      else if (where === 2) {
        return this.http.get<any>(_baseUrl + "?station=" + station);
      }else if (where === 3) {
        return this.http.get<any>(_baseUrl + "?date="  + date);
      } else{
        return this.http.get<any>(_baseUrl);
      }
    }
}
