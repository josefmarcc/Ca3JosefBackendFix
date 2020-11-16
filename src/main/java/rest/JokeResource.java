package rest;

import DTO.SavedJokeDTO;
import DTO.SavedJokesDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.SavedJoke;
import facades.JokeFacade;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import utils.DataFetcher;
import utils.EMF_Creator;

/**
 * REST Web Service
 */
@Path("jokes")
public class JokeResource {
    private ExecutorService es = Executors.newCachedThreadPool();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final JokeFacade jf = JokeFacade.getJokeFacade(EMF);

    @Context
    private UriInfo context;
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        return DataFetcher.fetchJokes(es); 
    }
    
    @GET
    @Path("saved")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSavedJokes() {
        EntityManager em = EMF.createEntityManager();
        try{
            SavedJokesDTO sJokesDTO = jf.getAllSavedJokes();
            return gson.toJson(sJokesDTO);
        }finally{
            em.close();
        }
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String saveJoke(String joke) {
        
       SavedJoke sj = gson.fromJson(joke, SavedJoke.class);
       SavedJokeDTO sjDTO = new SavedJokeDTO(sj);
        
        System.out.println(sjDTO);
        jf.saveJoke(sjDTO.getTheJoke());
        
        return "Joke added";
    }

    
    

   
}
