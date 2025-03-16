
package project.hms.models;

public class StaffData {
    private int staffID;
    private String name;
    private char sex;
    private String position;
    private String contactNum;
    private String email;
    
    public StaffData(int staffID, String name, char sex, String position, String contactNum, String email){
        this.staffID = staffID;
        this.name = name;
        this.sex = sex;
        this.position = position;
        this.contactNum = contactNum;
        this.email = email;
    }
    
    public int getStaffID(){ return staffID; }
    public String getName(){ return name; }
    public char getSex(){ return sex; }
    public String getPosition() { return position; }
    public String getContactNum() { return contactNum; }
    public String getEmail() { return email; }
}
