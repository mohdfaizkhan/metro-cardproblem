# CardProblem

used Java8, and H2 DATABASE db
used Spring Boot, just for test puprose
obviously in production we should use vanila java as much as we can

0) create db in H2 DB in memory DATABASE SQL={CREATE DATABASE cardproblem;}
1) in root dir run "mvn clean install"
2) in target dir run "java -jar adfg-1.0-SNAPSHOT-exec.jar"

application running on 9095 port

implemented
 - controller layers (card and transaction mapping)
 - repository layers (both)
 - service layers (validation and perist)

interfaces are includes documentations

application.yml db settings jpa:
    hibernate:
      ddl-auto: create
which means table will clear at application startup, to avoid - change "create" to "update"

--------------------------------------POST examples:
--------------------------------------creation card

post http://localhost:8080/card
```json
{
    "id": 6959144023113,
    "owner": "faiz",
    "balance": 30
}
```
responce
```json
{
    "id": 6959144023113,
    "owner": "faiz",
    "balance": 30,
    "checkInTime": null,
    "checkinStationEntity": null
}
```
--------------------------------------transaction checkin
post http://localhost:8080/transaction
```json
{
    "cardEntity": {
        "id": 6959144023113,
        "owner": "faiz",
        "balance": 30
    },
    "stationEntity": {
        "name": "jlt",
        "stationType": 2,
        "zone": 1,
        "agglomerationEntity": {
            "name": "dubai"
        }
    },
    "transactionType": 0
}
```
responce
```json
{
    "cardEntity": {
        "id": 6959144023113,
        "owner": "faiz",
        "balance": 26.8,
        "checkInTime": 1510986497562,
        "checkinStationEntity": {
            "name": "undefined",
            "stationType": null,
            "zone": 1,
            "agglomerationEntity": {
                "name": "dubai"
            },
            "first": true
        }
    },
    "stationEntity": {
        "name": "jlt",
        "stationType": "bus",
        "zone": 1,
        "agglomerationEntity": {
            "name": "dubai"
        },
        "first": true
    },
    "transactionType": "IN"
}
```
--------------------------------------transaction checkout
post http://localhost:8080/transaction
```json
{
    "cardEntity": {
        "id": 6959144023113,
        "owner": "faiz",
        "balance": 30
    },
    "stationEntity": {
        "name": "jlt",
        "stationType": 2,
        "zone": 1,
        "agglomerationEntity": {
            "name": "dubai"
        }
    },
    "transactionType": 1
}
```
responce
```json
{
    "cardEntity": {
        "id": 6959144023113,
        "owner": "faiz",
        "balance": 28.2,
        "checkInTime": null,
        "checkinStationEntity": null
    },
    "stationEntity": {
        "name": "jlt",
        "stationType": "bus",
        "zone": 1,
        "agglomerationEntity": {
            "name": "dubai"
        },
        "first": true
    },
    "transactionType": "OUT"
}
```
--------------------------------------transaction history with hours depth
http://localhost:8080/transaction?cardId=6959144023113&hours=3
```json
{
    "cardEntity": {
        "id": 6959144023113,
        "owner": "faiz",
        "balance": 28.2,
        "checkInTime": null,
        "checkinStationEntity": null
    },
    "cardReportData": [
        {
            "checkTime": 1510990827913,
            "name": "jlt",
            "stationType": "bus",
            "zone": 1,
            "agglomerationName": "dubai",
            "transactionType": "IN"
        },
        {
            "checkTime": 1510990831351,
            "name": "jlt",
            "stationType": "bus",
            "zone": 1,
            "agglomerationName": "dubai",
            "transactionType": "OUT"
        }
    ]
}
```
