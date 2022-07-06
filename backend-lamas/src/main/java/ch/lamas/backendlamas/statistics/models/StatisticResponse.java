package ch.lamas.backendlamas.statistics.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StatisticResponse {

    @Id
    String name;

    int totalRides;

    double delay;
}
