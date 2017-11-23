CREATE SCHEMA Calculator;
use Calculator;
CREATE TABLE Operations(
  operationId INT NOT NULL AUTO_INCREMENT,
  operationName VARCHAR(20) NOT NULL UNIQUE,
  CONSTRAINT Operations_PK PRIMARY KEY (operationId)
);
CREATE TABLE Statements(
  statementId INT NOT NULL AUTO_INCREMENT,
  firstNumber DECIMAL(10, 2) NOT NULL,
  secondNumber DECIMAL(10, 2) NOT NULL,
  operationId INT NOT NULL,
  CONSTRAINT Statements_PK PRIMARY KEY (statementId),
  CONSTRAINT Statements_FK FOREIGN KEY (operationId) REFERENCES Operations(operationId)
);

INSERT INTO Operations (operationName) VALUES ('Addition');
INSERT INTO Operations (operationName) VALUES ('Subtraction');
INSERT INTO Operations (operationName) VALUES ('Multiplication');
INSERT INTO Operations (operationName) VALUES ('Division');

INSERT INTO Statements (firstNumber, secondNumber, operationId) VALUES (15, 12, 1);
INSERT INTO Statements (firstNumber, secondNumber, operationId) VALUES (10, 2, 4);
INSERT INTO Statements (firstNumber, secondNumber, operationId) VALUES (12, 2, 3);
INSERT INTO Statements (firstNumber, secondNumber, operationId) VALUES (7, 3, 2);