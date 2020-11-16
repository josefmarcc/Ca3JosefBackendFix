package DTO;

import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josef
 */
public class UsersDTO {

    private List<UserDTO> all = new ArrayList();

    public UsersDTO(List<User> userEnitites) {
        userEnitites.forEach((u) -> {
            all.add(new UserDTO(u));
        });
    }

    public List<UserDTO> getAll() {
        return all;
    }

}
