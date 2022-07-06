package ch.lamas.backendlamas.repositories;

public class Statements {

    protected static final String selectAllQuery = "SELECT fahrt.*, b.id AS betreiber_id, b.kuerzel AS betreiber_kuerzel, b.name AS betreiber_name, " +
            "h.name AS haltestelle_name, h.id AS haltestelle_id, " +
            "l.id AS linie_id, l.linientext AS linie_linientext, " +
            "v.id AS verkehrsmittel_id, v.name AS verkehrsmittel_name " +
            "FROM lamas.fahrt " +
            "JOIN lamas.betreiber b on b.id = fahrt.betreiber_id " +
            "JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id " +
            "JOIN lamas.linie l on l.id = fahrt.linien_id " +
            "JOIN lamas.verkehrsmittel v on v.id = fahrt.verkehrsmittel_id " +
            "ORDER BY fahrt.id " +
            "LIMIT 50 " +
            "OFFSET %d;";

    protected static final String selectAllDates = "SELECT DISTINCT betriebstag FROM lamas.fahrt ORDER BY betriebstag;";
    protected static final String selectAllByDate = "SELECT fahrt.*, b.id AS betreiber_id, b.kuerzel AS betreiber_kuerzel, b.name AS betreiber_name, " +
            "h.name AS haltestelle_name, h.id AS haltestelle_id, l.id AS linie_id, l.linientext AS linie_linientext, " +
            "v.id AS verkehrsmittel_id, v.name AS verkehrsmittel_name FROM lamas.fahrt " +
            "JOIN lamas.betreiber b on b.id = fahrt.betreiber_id " +
            "JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id " +
            "JOIN lamas.linie l on l.id = fahrt.linien_id " +
            "JOIN lamas.verkehrsmittel v on v.id = fahrt.verkehrsmittel_id " +
            "WHERE betriebstag = '%tF' " +
            "ORDER BY fahrt.id " +
            "LIMIT 50 " +
            "OFFSET %d;";
    protected static final String selectAllByStation = "SELECT fahrt.*, b.id AS betreiber_id, b.kuerzel AS betreiber_kuerzel, b.name AS betreiber_name, " +
            "h.name AS haltestelle_name, h.id AS haltestelle_id, " +
            "l.id AS linie_id, l.linientext AS linie_linientext, " +
            "v.id AS verkehrsmittel_id, v.name AS verkehrsmittel_name FROM lamas.fahrt " +
            "JOIN lamas.betreiber b on b.id = fahrt.betreiber_id " +
            "JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id " +
            "JOIN lamas.linie l on l.id = fahrt.linien_id " +
            "JOIN lamas.verkehrsmittel v on v.id = fahrt.verkehrsmittel_id " +
            "WHERE h.name = '%s' " +
            "ORDER BY fahrt.id " +
            "LIMIT 50 " +
            "OFFSET %d;";
    protected static final String selectTotalResults = "SELECT count(id) AS rows FROM lamas.fahrt;";

    protected static final String selectAllStations = "SELECT DISTINCT name FROM lamas.haltestelle ORDER BY name ASC;";

    protected static final String selectTotalResultsByDate = "SELECT count(id) AS rows FROM lamas.fahrt WHERE betriebstag = '%tF';";

    protected static final String selectTotalResultsByStation = "SELECT count(fahrt.id) AS rows FROM lamas.fahrt JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id WHERE h.name = '%s';";

    protected static final String selectTotalResultsByStationAndDate = "SELECT count(lamas.fahrt.id) AS rows FROM lamas.fahrt JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id WHERE h.name = '%s' AND betriebstag = '%tF';";

    protected static final String selectAllByStationAndDate = "SELECT fahrt.*, b.id AS betreiber_id, b.kuerzel AS betreiber_kuerzel, b.name AS betreiber_name, " +
            "h.name AS haltestelle_name, h.id AS haltestelle_id, " +
            "l.id AS linie_id, l.linientext AS linie_linientext, " +
            "v.id AS verkehrsmittel_id, v.name AS verkehrsmittel_name from lamas.fahrt " +
            "JOIN lamas.betreiber b on b.id = fahrt.betreiber_id " +
            "JOIN lamas.haltestelle h on h.id = fahrt.haltestellen_id " +
            "JOIN lamas.linie l on l.id = fahrt.linien_id " +
            "JOIN lamas.verkehrsmittel v on v.id = fahrt.verkehrsmittel_id " +
            "WHERE  betriebstag = '%tF' " +
            "AND h.name = '%s' " +
            "ORDER BY fahrt.id " +
            "LIMIT 50 " +
            "OFFSET %d;";


    protected static final String selectDelayPerLine = "SELECT linientext as name, count(linientext) as number_of_drives, sum(delay_in_minutes) as delay FROM (\n" +
            "SELECT\n" +
            "       l.linienText,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.linie AS l ON f.linien_id = l.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY linientext\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";


    protected static final String selectDelayPerStop = "SELECT name, count(name) as number_of_drives, sum(delay_in_minutes) as delay FROM (\n" +
            "SELECT\n" +
            "       h.name,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.haltestelle AS h ON f.haltestellen_id = h.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY name\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";

    protected static final String selectDelayPerTransporttype = "SELECT name, count(name) as number_of_drives, sum(delay_in_minutes) as delay FROM (\n" +
            "SELECT\n" +
            "       v.name,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.verkehrsmittel AS v ON f.verkehrsmittel_id = v.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY name\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";

    protected static final String selectAverageDelayPerLine = "SELECT linientext as name, count (linientext) as number_of_drives, (count(linientext) / sum(delay_in_minutes)) as delay FROM (\n" +
            "SELECT\n" +
            "       l.linienText,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.linie AS l ON f.linien_id = l.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY linientext\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";

    protected static final String selectAverageDelayPerStop = "SELECT name, count(name) as number_of_drives, count(name) / sum(delay_in_minutes) as delay FROM (\n" +
            "SELECT\n" +
            "       h.name,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.haltestelle AS h ON f.haltestellen_id = h.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY name\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";

    protected static final String selectAverageDelayPerTransporttype = "SELECT name, count(name) as number_of_drives, count(name) / sum(delay_in_minutes) as delay FROM (\n" +
            "SELECT\n" +
            "       v.name,\n" +
            "       (CASE WHEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) > 0)\n" +
            "                     AND\n" +
            "                 ((EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60) > 0) THEN ((EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) + (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60))\n" +
            "         WHEN (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60) <= 0 THEN (EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) +  EXTRACT(hours FROM f.abfahrtprognose - f.abfahrt)*60)\n" +
            "            ELSE (EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) + EXTRACT(hours FROM f.ankunftprognose - f.ankunft)*60)\n" +
            "           END\n" +
            "        ) as delay_in_minutes\n" +
            "FROM lamas.fahrt AS f\n" +
            "JOIN lamas.verkehrsmittel AS v ON f.verkehrsmittel_id = v.id\n" +
            "WHERE\n" +
            "      f.ankunftsverspaetung = true\n" +
            "  OR\n" +
            "      f.abfahrtsverspaetung = true\n" +
            "  AND\n" +
            "      f.abfahrt IS NOT NULL\n" +
            "  AND\n" +
            "      f.abfahrtprognose IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunft IS NOT NULL\n" +
            "  and\n" +
            "      f.ankunftprognose IS NOT NULL\n" +
            "  AND\n" +
            "      (\n" +
            "        EXTRACT(minutes FROM f.ankunftprognose - f.ankunft) > 0\n" +
            "            OR\n" +
            "        EXTRACT(minutes FROM f.abfahrtprognose - f.abfahrt) > 0\n" +
            "\n" +
            "        )\n" +
            "    ) as t1\n" +
            "WHERE delay_in_minutes IS NOT NULL\n" +
            "GROUP BY name\n" +
            "ORDER BY delay desc\n" +
            "LIMIT 10;";
}
