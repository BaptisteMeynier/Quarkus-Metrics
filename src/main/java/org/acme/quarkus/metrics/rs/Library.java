package org.acme.quarkus.metrics.rs;

import org.acme.quarkus.metrics.rs.service.LibraryService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Path("book")
public class Library {

    @Inject
    private LibraryService libraryService;


    @GET
    @Produces("text/plain")
    public String getBooks(){
        return Arrays.asList(libraryService.findAll()).stream().collect(Collectors.joining(", "));
    }


    @POST
    @Path("{book}")
    @Metered(unit = MetricUnits.MINUTES,tags = "book")
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



    @Gauge(unit = MetricUnits.NONE, name = "queueSize", tags = "book")
    public int getQueueSize() {
        return libraryService.size();
    }
}
