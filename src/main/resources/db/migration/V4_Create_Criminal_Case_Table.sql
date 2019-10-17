create table CriminalCase (
    `id` BINARY(16) PRIMARY KEY NOT NULL,
    `name` VARCHAR(255),
    `time` date default null,
    `criminalElementsID` BINARY(16),
    FOREIGN KEY (criminalElementsID) REFERENCES CriminalCase (id);
);