package DTO;

import entities.User;

/**
 *
 * @author josef
 */
public class UserDTO {
    
    private String userName;

    
    
    
    public UserDTO(User user) {
        userName = user.getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    
}
