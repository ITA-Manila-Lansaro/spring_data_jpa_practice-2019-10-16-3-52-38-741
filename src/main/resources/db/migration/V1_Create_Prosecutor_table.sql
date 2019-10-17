CREATE TABLE Prosecutor(
    `id` BINARY(16) PRIMARY KEY NOT NULL,
    `name` VARCHAR (255),
    `time` NUMBER,
    `prosecutorID` BINARY(16),
    FOREIGN KEY (prosecutorID) REFERENCES Procuratorate(id)
);