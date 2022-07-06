package ch.lamas.backendlamas.trains.models;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fahrt")
public class Ride {

    @Id
    int id;

    Date betriebstag;

    boolean ausfall;

    boolean zusatzfahrt;

    Timestamp ankunft;

    Timestamp ankunftprognose;

    PredictionStatus ankunftprognosestatus;

    Timestamp abfahrt;

    Timestamp abfahrtprognose;

    PredictionStatus abfahrtprognosestatus;

    boolean durchfahrt;

    boolean ankunftsverspaetung;

    boolean abfahrtsverspaetung;

    @ManyToOne()
    MeansOfTransportation verkehrsmittel;

    @ManyToOne()
    Route linien;

    @ManyToOne()
    Operator betreiber;

    @ManyToOne()
    Station haltestellen;
}
