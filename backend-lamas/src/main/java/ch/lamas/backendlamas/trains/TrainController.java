package ch.lamas.backendlamas.trains;

import ch.lamas.backendlamas.trains.models.Ride;
import ch.lamas.backendlamas.trains.models.Station;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not found")
})
@RequestMapping("api/v1/trains")
public class TrainController {

    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("")
    public List<Ride> getAllTrains(@RequestParam String page) {
        return this.trainService.getAllTrains(page);
    }

    @GetMapping("/byStation")
    public List<Ride> getAllTrainsByStation(@RequestParam String station, @RequestParam String page) {
        return this.trainService.getTrainsByStation(station, page);
    }

    @GetMapping("/byDate")
    public List<Ride> getAllTrainsByDate(@RequestParam String date, @RequestParam String page) {
        return this.trainService.getTrainsByDate(date, page);
    }

    @GetMapping("/allStations")
    public List<String> getAllStations() {
        return this.trainService.getAllStations();
    }

    @GetMapping("/allDates")
    public List<Date> getAllDates() {
        return this.trainService.getAllDates();
    }

    @GetMapping("/byStationAndOrDate")
    public List<Ride> getAllStations(@RequestParam String page, @RequestParam(value = "station", required = false) String station,
                                     @RequestParam(value = "date", required = false) String date) {
        return this.trainService.getTrainsByStationAndDate(station, date, page);
    }


    @GetMapping("/count/allTrains")
    public Integer getTotalResults() {
        return this.trainService.getTotalResults();
    }

    @GetMapping("/count/allTrainsByDate")
    public Integer getTotalResultsOfDate(@RequestParam String date) {
        return this.trainService.getDateResults(date);
    }

    @GetMapping("/count/allTrainsByStation")
    public Integer getTotalResultsOfStation(@RequestParam String station) {
        return this.trainService.getStationResults(station);
    }

    @GetMapping("/count/allTrainsByStationAndOrDate")
    public Integer getTotalResultsOfStationAndOrDate(@RequestParam(value = "station", required = false) String station,
                                     @RequestParam(value = "date", required = false) String date) {
        return this.trainService.getStationAndOrDateResults(station, date);
    }

}
