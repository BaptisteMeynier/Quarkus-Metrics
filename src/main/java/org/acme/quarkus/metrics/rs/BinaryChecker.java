package org.acme.quarkus.metrics.rs;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/binary")
public class BinaryChecker {

    @GET
    @Path("to_decimal/{number}")
    @Produces("text/plain")
    public Integer checkIfPrime(@PathParam("number") String binaryNumber) {
        return Integer.parseInt(binaryNumber, 2);
    }



}