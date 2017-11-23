package Database.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Operations", schema = "Calculator")
public class OperationsEntity {

    private int operationId;
    private String operationName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "operationId")
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "operationName")
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
