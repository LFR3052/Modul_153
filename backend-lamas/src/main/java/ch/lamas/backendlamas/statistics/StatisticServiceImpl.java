package ch.lamas.backendlamas.statistics;

import ch.lamas.backendlamas.statistics.models.StatisticResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService{
    private final ch.lamas.backendlamas.repositories.DBRepository DBRepository;

    @Autowired
    public StatisticServiceImpl(ch.lamas.backendlamas.repositories.DBRepository dbRepository) {
        DBRepository = dbRepository;
    }

    @Override
    public List<StatisticResponse> getDelayLine() {
        return this.DBRepository.getDelayPerLine();
    };

    @Override
    public List<StatisticResponse> getDelayStop() {
        return this.DBRepository.getDelayPerStop();
    };

    @Override
    public List<StatisticResponse> getDelayTransporttype() {
        return this.DBRepository.getDelayPerTransporttype();
    };

    @Override
    public List<StatisticResponse> getAverageDelayLine() {
        return this.DBRepository.getAverageDelayPerLine();
    };

    @Override
    public List<StatisticResponse> getAverageDelayStop() {
        return this.DBRepository.getAverageDelayPerStop();
    };

    @Override
    public List<StatisticResponse> getAverageDelayTransporttype() {
        return this.DBRepository.getAverageDelayPerTransporttype();
    }
}
