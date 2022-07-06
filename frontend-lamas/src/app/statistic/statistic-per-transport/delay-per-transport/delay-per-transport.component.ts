import { Component, OnInit } from '@angular/core';
import { StatisticResponse } from 'src/app/Model/statisticResponse';
import { StatisticService } from 'src/app/service/statistic.service';

@Component({
  selector: 'app-delay-per-transport',
  templateUrl: './delay-per-transport.component.html',
  styleUrls: ['./delay-per-transport.component.scss']
})
export class DelayPerTransportComponent implements OnInit {

  statisticData: StatisticResponse[]
  graphData: any[]
  view: any[] = [700, 400];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Verkehrsmittel';
  showYAxisLabel = true;
  yAxisLabel = 'Verspätung in Minuten';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor(private statisticService: StatisticService) { }

  ngOnInit() {
    this.statisticService.getDelayTransport().subscribe(data => {
      this.statisticData = data
      this.prepareGraphData()
    })
  }

  prepareGraphData() {
    let arr = []
    this.statisticData.forEach(element => {
      arr.push({
        "name": element.name,
        "value": element.delay 
      })
    })
    this.graphData = arr
  }
}
