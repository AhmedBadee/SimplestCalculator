package Database;

import Database.Entities.StatementsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CalculatorCRUD {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public CalculatorCRUD() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("SimplestCalculator");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createStatement(StatementsEntity statement) {
        entityManager.getTransaction().begin();

        entityManager.persist(statement);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public ArrayList<String> getAllStatements() {
        Query query = entityManager
                .createQuery("select s from StatementsEntity s");

        List<StatementsEntity> allStatements = (List<StatementsEntity>) query.getResultList();

        ArrayList<String> statements = new ArrayList<>();

        for (StatementsEntity statement: allStatements) {
            int operationId = statement.getOperationId();
            query = entityManager
                    .createQuery("select o.operationName " +
                            "from OperationsEntity o " +
                            "where o.operationId = " + operationId);

            String operation = (String) query.getSingleResult();
            statements.add(statement.toString(operation));
        }

        entityManager.close();
        entityManagerFactory.close();

        return statements;
    }

    public String getStatementById(int id) {
        Query query = entityManager
                .createQuery("select s from StatementsEntity s where s.statementId = " + id);

        StatementsEntity statement = (StatementsEntity) query.getSingleResult();

        int operationId = statement.getOperationId();
        query = entityManager
                .createQuery("select o.operationName from OperationsEntity o where o.operationId = " + operationId);

        String operation = (String) query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return statement.toString(operation);
    }

    public String updateStatement(int id, StatementsEntity statement) {
        entityManager.getTransaction().begin();

        Query query = entityManager
                .createQuery("update StatementsEntity s set " +
                        "s.firstNumber = " + statement.getFirstNumber() +
                        ", s.secondNumber = " + statement.getSecondNumber() +
                        ", s.operationId = " + statement.getOperationId() + " where s.statementId = " + id);

        int updated = query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return updated + " statements updated";
    }

    public String deleteStatement(int id) {
        entityManager.getTransaction().begin();

        Query query = entityManager
                .createQuery("delete from StatementsEntity s where s.statementId = " + id);

        int deleted = query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return deleted + " statements deleted";
    }
}
