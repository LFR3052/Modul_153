driveQueries = []
stopQueries = []
betQueries = []
lineQueries = []
typeQueries = []
stopList = []
lineList = []
typeList = []
betList = []
driveId = 1
for files in range(1, 8):
    data = open('./data/' + str(files) + '.csv').readlines()
    i = 0
    for line in data:
        lineInsert = "INSERT INTO lamas.linie (id, linienText) VALUES (?, ?);".split('?')
        typeInsert = "INSERT INTO lamas.verkehrsmittel (id, text) VALUES (?, ?);".split('?')
        stopInsert = "INSERT INTO lamas.haltestelle (id, name) VALUES (?, ?);".split('?')
        betInsert = "INSERT INTO lamas.betreiber (id, kuerzel, name) VALUES (?, ?, ?);".split('?')
        driveInsert = "INSERT INTO lamas.fahrt (id, betriebstag, ausfall, zusatzfahrt, ankunft, ankunftPrognose, ankunftPrognoseStatus, abfahrt, abfahrtPrognose, abfahrtPrognoseStatus, durchfahrt, ankunftsverspaetung, abfahrtsverspaetung, verkehrsmittel_id, linien_id, betreiber_id, haltestellen_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);".split('?')
        if i == 0:
            i += 1
        else:
            line = line.split(';')

            if not(line[3] in betList):
                betList.append(line[3])
                betInsert[0] += str(betList.index(line[3])+1)
                betInsert[1] += "'" + line[3] + "'"
                betInsert[2] += "'" + line[4] + "'"
                betQueries.append(''.join(betInsert))
            driveInsert[15] += str(betList.index(line[3])+1)

            if not(line[9] in typeList):
                typeList.append(line[9])
                typeInsert[0] += str(typeList.index(line[9])+1)
                typeInsert[1] += "'" + line[9] + "'"
                typeQueries.append(''.join(typeInsert))
            driveInsert[13] += str(typeList.index(line[9])+1)
            
            if not(line[7] in lineList):
                lineList.append(line[7])
                lineInsert[0] += str(lineList.index(line[7])+1)
                lineInsert[1] += "'" + line[7] + "'"
                lineQueries.append(''.join(lineInsert))
            driveInsert[14] += str(lineList.index(line[7])+1)

            if not(line[13] in stopList):
                stopList.append(line[13])
                stopInsert[0] += str(stopList.index(line[13])+1)
                stopInsert[1] += "'" + line[13] + "'"
                stopQueries.append(''.join(stopInsert))
            driveInsert[16] += str(stopList.index(line[13])+1)
            
            for i in range(0, len(line)):
                if line[i] == '':
                    line[i] = 'null'
            
            driveInsert[0] += str(driveId)
            driveInsert[1] += "'" + line[0] + "'"
            driveInsert[2] += line[11]
            driveInsert[3] += line[10]
            if line[14] == 'null':
                driveInsert[4] += line[14]
                driveInsert[5] += line[14]
            else:
                driveInsert[4] += "'" + line[14] + "'"
                driveInsert[5] += "'" + line[15] + "'"
            driveInsert[6] += "'" + line[16] + "'"
            if line[17] == 'null':
                driveInsert[7] += line[17]
                driveInsert[8] += line[17]
            else:
                driveInsert[7] += "'" + line[17] + "'"
                driveInsert[8] += "'" + line[18] + "'"
            driveInsert[9] += "'" + line[19] + "'"
            driveInsert[12] += line[20]
            driveInsert[10] += line[21]
            driveInsert[11] += line[22]

            driveQueries.append(''.join(driveInsert))

            driveId += 1
    print('finished file ' + str(files))



            
stopFile = open("stop.sql", 'w')
for line in stopQueries:
    stopFile.write(line + '\n')
print('wrote stop.sql')

lineFile = open("line.sql", 'w')
for line in lineQueries:
    lineFile.write(line + '\n')
print('wrote line.sql')

betFile = open("bet.sql", 'w')
for line in betQueries:
    betFile.write(line + '\n')
print('wrote bet.sql')

typeFile = open("type.sql", 'w')
for line in typeQueries:
    typeFile.write(line + '\n')
print('wrote type.sql')

driveFile = open("drive.sql", 'w')
for line in driveQueries:
    driveFile.write(line + '\n')
print('wrote drive.sql')
