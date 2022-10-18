# Worker registration app

## Overview

The purpose of this application is to register people with their sector of work.

Every worker has a name, list of sectors they are active in, and whether they have agreed to terms or not.

## Endpoints

### Sectors

#### GET `/sectors`

Response body

```json
[
  {
    "id": "uuid",
    "name": "sector's name",
    "subSectors": [{
          "id": "uuid",
          "name": "sector's name",
          "subSectors": []
    }]
  }
]
```

### Workers

#### POST `/workers`

Request body:

```json
{
  "name": "worker's name",
  "agreeToTerms": true,
  "sector_ids": ["uuid", "uuid"]
}
```  

Response:

```json
{
  "id": "uuid",
  "name": "worker's name",
  "agreeToTerms": true,
  "sector_ids": ["uuid", "uuid"]
}
```

#### PUT `/workers/{id}`

Where id is an UUID string  
Request body:

```json
{
  "name": "worker's name",
  "agreeToTerms": true,
  "sector_ids": ["uuid", "uuid"]
}
```  

Response:

```json
{
  "id": "uuid",
  "name": "worker's name",
  "agreeToTerms": true,
  "sector_ids": ["uuid", "uuid"]
}
```

## Database setup

### Setup

The application has a driver for PostgreSQL, so that would be the preferred system. Make sure that the Postgres user has permissions for the database.  

There's a relatively short and simple tutorial for setting that up https://hevodata.com/learn/docker-postgresql/.

### Test data

There is a script for populating the database with some data at
`src/main/resources/db/test-data/sector-data.sql`

The database must have been initialized by this step.
That can be done by simply running the application.

### Step-by-step
0. Install and start docker
1. Download the PostgreSQL image `docker pull postgres`
2. Create and run a new container of PostgreSQL `docker run --name helmes -e POSTGRES_USER=helmes -e POSTGRES_PASSWORD=helmes -p 5432:5432 -d postgres`
3. Run `docker ps -a` and copy the id of the newly created instance "helmes".
4. Open up the instance terminal `docker exec -it [paste the instance id here] /bin/sh`
5. Connect to the PostgreSQL `psql -U helmes`
6. Create database `CREATE DATABASE helmes;`  

That's it. You should be able to close all the connections now.

## Application setup

### Setup

1. After opening the project in IntelliJ, go to `View > Tool Windows > Gradle > Reload` to install all Gradle dependencies.
2. Make sure that the database is set up.
3. Configure environment variables from the `Edit Configurations` menu (more down below)
4. Run the application from `SectorsApplication` class.

I would not recommend doing this from the command line, as it makes everything more complicated.

### Environment variables

After having the database set up, add the following environment variables to the Spring application:
* `DB_LOCATION` (eg `localhost:5432/helmes`)
* `DB_USERNAME` (eg `helmes`)
* `DB_PASSWORD` (eg `helmes`)
