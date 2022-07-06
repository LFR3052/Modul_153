import { MeansOfTransportation } from "./Model/MeansOfTransportation";
import { Operator } from "./Model/Operator";
import { Route } from "./Model/Route";
import { Station } from "./Model/Station";
import { PredictionStatus } from "./predictionStatus";

export class Ride {
    id: string;
    betriebstag: Date;
    ausfall: boolean;
    zusatzfahrt: boolean;
    ankunft: Date;
    ankunftprognose: Date;
    ankunftprognosestatus: PredictionStatus;
    abfahrt: Date;
    abfahrtprognose: Date;
    abfahrtprognosestatus: PredictionStatus;
    durchfahrt: boolean;
    ankunftsverspaetung: boolean;
    abfahrtsverspaetung: boolean;
    verkehrsmittel: MeansOfTransportation;
    linien: Route;
    betreiber: Operator;
    haltestellen: Station;

    constructor(id, betriebstag, ausfall, 
        zusatzfahrt, ankunft, ankunftprognose, ankunftprognosestatus, 
        abfahrt, abfahrtprognose, abfahrtprognosestatus, durchfahrt,
        ankunftsverspaetung, abfahrtsverspaetung, verkehrsmittel,
        linien, betreiber, haltestellen) {

        this.id = id;
        this.betriebstag = betriebstag;
        this.ausfall = ausfall;
        this.zusatzfahrt = zusatzfahrt;
        this.ankunft = ankunft;
        this.ankunftprognose = ankunftprognose;
        this.ankunftprognosestatus = ankunftprognosestatus;
        this.abfahrt = abfahrt;
        this.abfahrtprognose = abfahrtprognose;
        this.abfahrtprognosestatus = abfahrtprognosestatus;
        this.durchfahrt = durchfahrt;
        this.ankunftsverspaetung = ankunftsverspaetung;
        this.abfahrtsverspaetung = abfahrtsverspaetung;
        this.verkehrsmittel = verkehrsmittel;
        this.linien = linien;
        this.betreiber = betreiber;
        this.haltestellen = haltestellen;
    }
}