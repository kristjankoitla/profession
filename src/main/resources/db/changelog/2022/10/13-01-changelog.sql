-- liquibase formatted sql

CREATE TABLE sector
(
    id               UUID NOT NULL,
    name             VARCHAR(255),
    parent_sector_id UUID,
    CONSTRAINT pk_sector PRIMARY KEY (id)
);

CREATE TABLE sector_worker
(
    sector_id UUID NOT NULL,
    worker_id UUID NOT NULL,
    CONSTRAINT pk_sector_worker PRIMARY KEY (sector_id, worker_id)
);

CREATE TABLE worker
(
    id            UUID    NOT NULL,
    name          VARCHAR(255),
    agree_to_term BOOLEAN NOT NULL,
    CONSTRAINT pk_worker PRIMARY KEY (id)
);

ALTER TABLE sector
    ADD CONSTRAINT FK_SECTOR_ON_PARENT_SECTOR FOREIGN KEY (parent_sector_id) REFERENCES sector (id);

ALTER TABLE sector_worker
    ADD CONSTRAINT fk_secwor_on_sector_entity FOREIGN KEY (sector_id) REFERENCES sector (id);

ALTER TABLE sector_worker
    ADD CONSTRAINT fk_secwor_on_worker_entity FOREIGN KEY (worker_id) REFERENCES worker (id);

