package application.rest;

import application.models.db.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @PersistenceContext(name = "customersPU")
    private EntityManager em;

    @GET
    public Response findCustomers() {
        return Response.ok(em.createNamedQuery("Customer.findAll", Customer.class).getResultList()).build();
    }
}
