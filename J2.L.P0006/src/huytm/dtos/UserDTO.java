/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.dtos;

/**
 *
 * @author acer
 */
public class UserDTO {
    String userID;
    String fullName;
    String password;
    boolean status;

    public UserDTO() {
    }

    public UserDTO(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }
    
    

    public UserDTO(String userID, String fullName, String password, boolean status) {
        this.userID = userID;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
