package rest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.DataFetcher;

//Todo Remove or change relevant parts before ACTUAL use
@Path("quotes")
public class QuoteResource {
    private ExecutorService es = Executors.newCachedThreadPool();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllQuotes() throws InterruptedException, ExecutionException, TimeoutException, IOException {
        return DataFetcher.fetchQuotes(es); 
    }
  
}
