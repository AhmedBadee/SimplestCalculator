package Database.Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Statements", schema = "Calculator")
@XmlRootElement
public class StatementsEntity {

    private int statementId;
    private int operationId;
    private double firstNumber;
    private double secondNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "statementId")
    public int getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    @Basic
    @Column(name = "operationId")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "firstNumber")
    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Basic
    @Column(name = "secondNumber")
    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String toString(String operation) {
        double result = 0;
        char operationSymbol;
        switch (operation) {
            case "Addition":
                operationSymbol = '+';
                result = this.getFirstNumber() + this.getSecondNumber();
                break;
            case "Subtraction":
                operationSymbol = '-';
                result = this.getFirstNumber() - this.getSecondNumber();
                break;
            case "Multiplication":
                operationSymbol = '*';
                result = this.getFirstNumber() * this.getSecondNumber();
                break;
            default:
                operationSymbol = '/';
                result = this.getFirstNumber() / this.getSecondNumber();
                break;
        }

        return this.getFirstNumber() + " " + operationSymbol + " " + this.getSecondNumber() + " = " + result;
    }
}
