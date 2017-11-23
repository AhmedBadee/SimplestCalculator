package SOAP;

import Database.CalculatorCRUD;
import Database.Entities.StatementsEntity;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(
        name = "SOAPCalculator",
        portName = "SOAPCalculatorPort",
        serviceName = "SOAPCalculatorService",
        targetNamespace = "SOAP"
)
public class SOAPCalculator {

    @Inject
    private CalculatorCRUD calculatorCRUD;

    @WebMethod(
            operationName = "create",
            action = "create_new_statement"
    )
    @WebResult(name = "No Result")
    public void create(@WebParam(name = "new_statement") StatementsEntity statement) {
        calculatorCRUD.createStatement(statement);
    }

    @WebMethod(
            operationName = "read_all_statements",
            action = "read_all_statements"
    )
    @WebResult(name = "ArrayList of Statements as Strings")
    public ArrayList<String> readAll() {
        return calculatorCRUD.getAllStatements();
    }

    @WebMethod(
            operationName = "read_statement_by_id",
            action = "read_statement_by_id"
    )
    @WebResult(name = "statement as a string")
    public String readById(@WebParam(name = "statement_id") int id) {
        return calculatorCRUD.getStatementById(id);
    }

    @WebMethod(
            operationName = "update",
            action = "update_statement_by_id"
    )
    @WebResult(name = "number_of_updated_statements")
    public String updateById(@WebParam(name = "statement_id") int id,
                             @WebParam(name = "updated_statement") StatementsEntity statement) {
        return calculatorCRUD.updateStatement(id, statement);
    }

    @WebMethod(
            operationName = "delete",
            action = "delete_statement_by_id"
    )
    @WebResult(name = "number_of_deleted_statements")
    public String deleteById(@WebParam(name = "statement_id") int id) {
        return calculatorCRUD.deleteStatement(id);
    }

}
