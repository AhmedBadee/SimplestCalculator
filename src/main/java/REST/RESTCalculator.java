package REST;

import Database.CalculatorCRUD;
import Database.Entities.StatementsEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/")
public class RESTCalculator {

    @Inject
    private CalculatorCRUD calculatorCRUD;

    @POST
    @Path("/Calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(StatementsEntity statement) {
        calculatorCRUD.createStatement(statement);
    }

    @GET
    @Path("/Statements")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> readAll() {
        return calculatorCRUD.getAllStatements();
    }

    @GET
    @Path("/Statements/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String readById(@PathParam("id") int id) {
        return calculatorCRUD.getStatementById(id);
    }

    @PUT
    @Path("/Statements/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateById(@PathParam("id") int id, StatementsEntity statement) {
        return calculatorCRUD.updateStatement(id, statement);
    }

    @DELETE
    @Path("/Statements/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteById(@PathParam("id") int id) {
        return calculatorCRUD.deleteStatement(id);
    }
}
