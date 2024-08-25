CREATE TABLE Todo(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shortdescription VARCHAR(100) NOT NULL,
    longdescription VARCHAR(500) NOT NULL,
    datecreated TIMESTAMP NOT NULL,
    isdone BOOLEAN NOT NULL
);

INSERT INTO Todo(shortdescription, longdescription, datecreated, isdone)
VALUES ('short', 'long', CURRENT_TIMESTAMP(), false);