package ch.lamas.backendlamas.trains;

import ch.lamas.backendlamas.repositories.DBRepository;
import ch.lamas.backendlamas.trains.models.Ride;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService {

    private final DBRepository DBRepository;
    private List<Date> availableDates;
    private List<String> availableStations;
    private static final int pageSize = 50;

    @Autowired
    public TrainServiceImpl(DBRepository DBRepository) {
        this.DBRepository = DBRepository;
        availableDates = new ArrayList<>();
        availableStations = new ArrayList<>();
    }

    @Override
    public List<Ride> getAllTrains(String page) {
        int skippedRows = Integer.parseInt(page);
        return this.DBRepository.getAllRides(calculateSkippedRows(skippedRows));
    }

    @Override
    public List<Ride> getTrainsByStation(String station, String page) {
        int skippedRows = Integer.parseInt(page);
        String validatedStation = this.validateStation(station);
        if (validatedStation != null) {
            return this.DBRepository.getAllRidesByStation(calculateSkippedRows(skippedRows), validatedStation);
        }
        return new ArrayList<Ride>();
    }

    @Override
    public List<Ride> getTrainsByDate(String dateString, String page) {
        int skippedRows = Integer.parseInt(page);
        Date date = this.validateDate(dateString);
        if (date != null) {
            return this.DBRepository.getAllRidesByDate(calculateSkippedRows(skippedRows), date);
        }
        return new ArrayList<Ride>();
    }

    @Override
    public List<Ride> getTrainsByStationAndDate(String station, String date, String page) {
        int skippedRows = Integer.parseInt(page);
        String validatedStation = this.validateStation(station);
        Date validatedDate = this.validateDate(date);
        skippedRows = calculateSkippedRows(skippedRows);
        if (validatedDate != null) {
            if (validatedStation != null) {
                return this.DBRepository.getStationAndDateResults(validatedStation, validatedDate, skippedRows);
            } else {
                return this.DBRepository.getAllRidesByDate(skippedRows, validatedDate);
            }
        } else {
            if (validatedStation != null) {
                return this.DBRepository.getAllRidesByStation(skippedRows, validatedStation);
            } else {
                return this.DBRepository.getAllRides(skippedRows);
            }
        }
    }

    @Override
    public List<String> getAllStations() {
        return this.DBRepository.getAllStations();
    }

    @Override
    public List<Date> getAllDates() {
        return this.DBRepository.getAllDates();
    }

    @Override
    public Integer getTotalResults() {
        return this.DBRepository.getTotalResults();
    }

    @Override
    public Integer getDateResults(String dateString) {
        Date date = this.validateDate(dateString);
        if (date != null) {
            return this.DBRepository.getDateResults(date);
        }
        return 0;
    }

    @Override
    public Integer getStationResults(String station) {
        String validatedStation = this.validateStation(station);
        if (validatedStation != null ) {
            return this.DBRepository.getStationResults(station);
        }
        return 0;
    }

    @Override
    public Integer getStationAndOrDateResults(String station, String dateString) {
        String validatedStation = this.validateStation(station);
        Date date = this.validateDate(dateString);
        if (validatedStation != null ) {
            if (date != null) {
                return this.DBRepository.getStationAndDateCount(validatedStation, date);
            } else {
                return this.DBRepository.getStationResults(station);
            }
        } else {
            if (date != null) {
                return this.DBRepository.getDateResults(date);
            } else {
                return this.DBRepository.getTotalResults();
            }
        }
    }

    private int calculateSkippedRows(int pages) {
        return pages * pageSize;
    }

    private boolean isValidDate(String date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private Date validateDate(String unvalidatedDate) {
        if (unvalidatedDate == null) return null;
        if (!isValidDate(unvalidatedDate)) return null;
        Date date = Date.valueOf(unvalidatedDate);
        if (availableDates.size() == 0) {
            availableDates = this.DBRepository.getAllDates();
        }
        if (availableDates.contains(date)) {
            return date;
        }
        return null;
    }

    private String validateStation(String unvalidatedStation) {
        if (unvalidatedStation == null) return null;
        if (availableStations.size() == 0) {
            availableStations = this.DBRepository.getAllStations();
        }
        for (String forStation : availableStations) {
            if (forStation.equalsIgnoreCase(unvalidatedStation)) {
                return forStation;
            }
        }
        return null;
    }
}
