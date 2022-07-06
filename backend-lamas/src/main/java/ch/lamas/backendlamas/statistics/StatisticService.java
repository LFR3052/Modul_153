package ch.lamas.backendlamas.statistics;


import ch.lamas.backendlamas.statistics.models.StatisticResponse;

import java.util.List;

public interface StatisticService {

    List<StatisticResponse> getDelayLine();

    List<StatisticResponse> getDelayStop();

    List<StatisticResponse> getDelayTransporttype();

    List<StatisticResponse> getAverageDelayLine();

    List<StatisticResponse> getAverageDelayStop();

    List<StatisticResponse> getAverageDelayTransporttype();

}
