import { Component, OnInit } from '@angular/core';
import { StatisticResponse } from 'src/app/Model/statisticResponse';
import { StatisticService } from 'src/app/service/statistic.service';

@Component({
  selector: 'app-delay-per-line',
  templateUrl: './delay-per-line.component.html',
  styleUrls: ['./delay-per-line.component.scss']
})
export class DelayPerLineComponent implements OnInit {

  statisticData: StatisticResponse[]
  graphData: any[]
  view: any[] = [700, 400];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Linie';
  showYAxisLabel = true;
  yAxisLabel = 'Verspätung in Minuten';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor(private statisticService: StatisticService) { }

  ngOnInit() {
    this.statisticService.getDelayLine().subscribe(data => {
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