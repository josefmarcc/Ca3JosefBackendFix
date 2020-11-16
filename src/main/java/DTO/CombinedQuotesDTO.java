/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 * 
 * @author Frederik Dahl <cph-fd76@cphbusiness.dk>
 */
public class CombinedQuotesDTO {
     private String friendsChar; 
     private String friendsQuote; 
     private String trumpQuote; 
     
     public CombinedQuotesDTO(FriendsDTO friendsDTO, TrumpDTO trumpDTO){
        this.friendsChar = friendsDTO.getCharacter(); 
        this.friendsQuote = friendsDTO.getQuote();
        this.trumpQuote = trumpDTO.getValue(); 
     }

    public String getFriendsChar() {
        return friendsChar;
    }

    public void setFriendsChar(String friendsChar) {
        this.friendsChar = friendsChar;
    }

    public String getFriendsQuote() {
        return friendsQuote;
    }

    public void setFriendsQuote(String friendsQuote) {
        this.friendsQuote = friendsQuote;
    }

    public String getTrumpValue() {
        return trumpQuote;
    }

    public void setTrumpValue(String trumpValue) {
        this.trumpQuote = trumpValue;
    }
    
    
     
     
}
