package ch.lamas.backendlamas.trains.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verkehrsmittel")
public class MeansOfTransportation {

    @Id
    int id;

    String name;

}
