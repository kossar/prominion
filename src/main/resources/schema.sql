
DROP TABLE IF EXISTS callback;

CREATE TABLE callback (
     GUID VARCHAR(36) NOT NULL,
     LastResult VARCHAR(36) NOT NULL,
     OrigCallerNbr VARCHAR(36) NOT NULL,
     last VARCHAR(36),
     next VARCHAR(36) NOT NULL,
     queuename VARCHAR(36) NOT NULL,
     start VARCHAR(36) NOT NULL
);
