package project.hms.models;

public class PatientData {
    private int patientID;
    private String name;
    private char sex;
    private String address;
    private String contactNum;
    private String bloodGroup;
    
    public PatientData(int patientID, String name, char sex, String address, String contactNum, String bloodGroup){
        this.patientID = patientID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.contactNum = contactNum;
        this.bloodGroup = bloodGroup;
    }
    
    public int getPatientID() { return patientID; }
    public String getName() { return name; }
    public char getSex() { return sex; }
    public String getAddress() { return address; }
    public String getContactNum() { return contactNum; }
    public String getBloodGroup() { return bloodGroup; }
}
