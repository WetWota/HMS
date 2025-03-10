/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hms.models;


public class AccountData {
    private int accountID;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
    
    public AccountData(int accountID, String firstName, String lastName, String password, String role) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public int getAccountID() { return accountID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setFirstName() { this.firstName = firstName; }
    public void setLastName() { this.lastName = lastName; }
    public void setPassword() { this.password = password; }
    public void setRole() { this.role = role;}

}
