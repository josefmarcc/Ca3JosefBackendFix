package DTO;

import entities.SavedJoke;

/**
 *
 * @author josef
 */
public class SavedJokeDTO {
    
    private String joke;

    public SavedJokeDTO(SavedJoke savedJoke) {
        joke = savedJoke.getJoke();
    }

    public String getTheJoke() {
        return joke;
    }
    
}
