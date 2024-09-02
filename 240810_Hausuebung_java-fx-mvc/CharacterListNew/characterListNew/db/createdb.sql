CREATE TABLE Character
(
    id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(20) NOT NULL,
    lastName  VARCHAR(20) NOT NULL,
    age       TIMESTAMP   NOT NULL,
    location  INT     NOT NULL
);

CREATE TABLE Location
(
    zipcode INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
);
