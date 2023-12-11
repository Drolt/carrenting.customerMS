CREATE DATABASE IF NOT EXISTS Carrenting;
USE Carrenting;

-- Fügen Sie hier Ihre Tabellenerstellungs-SQL-Befehle hinzu


CREATE TABLE Customers (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL
);
