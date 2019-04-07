package org.acme.quarkus.metrics.rs;

import org.acme.quarkus.metrics.rs.service.LibraryService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Path("book")
public class Library {

    @Inject
    private LibraryService libraryService;



    @POST
    @Path("{book}")
    @Metered(unit = MetricUnits.MINUTES)
    public void addBook(@PathParam("book") String book){
        libraryService.add(book);
    }

    @PUT
    @Path("{book}")
    public void readBook(@PathParam("book") String book){
        CompletableFuture.runAsync(() -> {
            libraryService.readBook(book);
        });
    }


    @DELETE
    @Path("{book}")
    public void removeBook(@PathParam("book") String book){
        libraryService.remove(book);
    }



    @Gauge(unit = MetricUnits.NONE, name = "queueSize")
    public int getQueueSize() {
        return libraryService.size();
    }
}
