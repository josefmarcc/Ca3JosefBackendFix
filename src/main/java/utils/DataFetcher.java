package utils;

import DTO.ChuckDTO;
import DTO.CombinedJokeDTO;
import DTO.CombinedQuotesDTO;
import DTO.DadDTO;
import DTO.FriendsDTO;
import DTO.InsultDTO;
import DTO.TrumpDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DataFetcher {
    private static String chuckNorrisApi = "https://api.chucknorris.io/jokes/random"; 
    private static String dadJokeApi = "https://icanhazdadjoke.com"; 
    private static String insultApi = "https://evilinsult.com/generate_insult.php?lang=en&type=json";
    private static String friendsApi = "https://friends-quotes-api.herokuapp.com/quotes/random";
    private static String trumpApi = "https://evilinsult.com/generate_insult.php?lang=en&type=json";

    public static String fetchJokes(ExecutorService executorService) throws InterruptedException, ExecutionException, TimeoutException, IOException {
        long start = System.nanoTime(); 
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
               
        Callable<ChuckDTO> chuckTask = new Callable<ChuckDTO>(){
            @Override
            public ChuckDTO call() throws Exception {
               String chuck = HttpUtils.fetchData(chuckNorrisApi);
               ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
               return chuckDTO; 
            }         
        }; 
        
        Callable<DadDTO> dadTask = new Callable<DadDTO>(){
            @Override
            public DadDTO call() throws Exception {
               String dad = HttpUtils.fetchData(dadJokeApi);
               DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
               return dadDTO; 
            }         
        }; 
        
        
        Callable<InsultDTO> insultTask = new Callable<InsultDTO>(){
            @Override
            public InsultDTO call() throws Exception {
               String insult = HttpUtils.fetchData(insultApi);
               InsultDTO insultDTO = gson.fromJson(insult, InsultDTO.class);
               return insultDTO; 
            }         
        }; 

        Future<ChuckDTO> futureChuck = executorService.submit(chuckTask); 
        Future<DadDTO> futureDad = executorService.submit(dadTask); 
        Future<InsultDTO> futureInsult = executorService.submit(insultTask);         

        ChuckDTO chuck = futureChuck.get(2,TimeUnit.SECONDS); 
        DadDTO dad = futureDad.get(2,TimeUnit.SECONDS); 
        InsultDTO insult = futureInsult.get(2,TimeUnit.SECONDS); 
        
        CombinedJokeDTO combinedDTO = new CombinedJokeDTO(chuck,dad,insult);
        String combinedJSON = gson.toJson(combinedDTO); 
        
        return combinedJSON;

    }
    
     public static String fetchQuotes(ExecutorService executorService) throws InterruptedException, ExecutionException, TimeoutException, IOException {
        long start = System.nanoTime(); 
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        Callable<FriendsDTO> friendsTask = new Callable<FriendsDTO>(){
            @Override
            public FriendsDTO call() throws Exception {
               String friends = HttpUtils.fetchData(friendsApi);
               FriendsDTO friendsDTO = gson.fromJson(friends, FriendsDTO.class);
               return friendsDTO; 
            }         
        }; 
   
        Callable<TrumpDTO> trumpTask = new Callable<TrumpDTO>(){
            @Override
            public TrumpDTO call() throws Exception {
               String trump = HttpUtils.fetchData(trumpApi);
               TrumpDTO trumpDTO = gson.fromJson(trump, TrumpDTO.class);
               return trumpDTO; 
            }         
        }; 
        
        Future<FriendsDTO> futureFriend = executorService.submit(friendsTask); 
        Future<TrumpDTO> futureTrump = executorService.submit(trumpTask); 
       
        FriendsDTO friend = futureFriend.get(2,TimeUnit.SECONDS); 
        TrumpDTO trump = futureTrump.get(2,TimeUnit.SECONDS); 
        
        
        CombinedQuotesDTO combinedQuotesDTO = new CombinedQuotesDTO(friend,trump); 
       
        String combinedJSON = gson.toJson(combinedQuotesDTO); 
        
        return combinedJSON;

     }

}
