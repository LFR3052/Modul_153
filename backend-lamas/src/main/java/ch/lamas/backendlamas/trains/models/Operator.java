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
@Table(name = "betreiber")
public class Operator {

    @Id
    int id;

    String kuerzel;

    String name;

}
