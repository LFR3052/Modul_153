package ch.lamas.backendlamas.statistics;


import ch.lamas.backendlamas.statistics.models.StatisticResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not found")
})
@RequestMapping("api/v1/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/delayLine")
    public List<StatisticResponse> getDelayLine() {
        return this.statisticService.getDelayLine();
    }

    @GetMapping("/delayStop")
    public List<StatisticResponse> getDelayStop() {
        return this.statisticService.getDelayStop();
    }

    @GetMapping("/delayTransport")
    public List<StatisticResponse> getDelayTransport() {
        return this.statisticService.getDelayTransporttype();
    }

    @GetMapping("/averageDelayLine")
    public List<StatisticResponse> getAverageDelayLine() {
        return this.statisticService.getAverageDelayLine();
    }

    @GetMapping("/averageDelayStop")
    public List<StatisticResponse> getAverageDelayStop() {
        return this.statisticService.getAverageDelayStop();
    }

    @GetMapping("/averageDelayTransport")
    public List<StatisticResponse> getAverageDelayTransport() {
        return this.statisticService.getAverageDelayTransporttype();
    }
}
