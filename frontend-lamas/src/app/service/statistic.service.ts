import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StatisticResponse } from '../Model/StatisticResponse';


@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  constructor(private http: HttpClient) { }
  private _url: string = "http://localhost:8080/api/v1/statistics"

  getDelayLine() {
    return this.http.get<StatisticResponse[]>(this._url + "/delayLine")
  }

  getDelayStop() {
    return this.http.get<StatisticResponse[]>(this._url + "/delayStop")
  }

  getDelayTransport() {
      return this.http.get<StatisticResponse[]>(this._url + "/delayTransport")
  }

  getAverageDelayLine() {
    return this.http.get<StatisticResponse[]>(this._url + "/averageDelayLine")
  }

  getAverageDelayStop() {
    return this.http.get<StatisticResponse[]>(this._url + "/averageDelayStop")
  }

  getAverageDelayTransport() {
      return this.http.get<StatisticResponse[]>(this._url + "/averageDelayTransport")
  }
}
