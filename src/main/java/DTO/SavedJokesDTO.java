package DTO;

import entities.SavedJoke;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josef
 */
public class SavedJokesDTO {
    
    private List<SavedJokeDTO> all = new ArrayList();

    public SavedJokesDTO(List<SavedJoke> savedJokeEnitites) {
        savedJokeEnitites.forEach((u) -> {
            all.add(new SavedJokeDTO(u));
        });
    }

    public List<SavedJokeDTO> getAll() {
        return all;
    }
    
}
