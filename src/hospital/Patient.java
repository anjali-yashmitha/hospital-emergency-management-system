package hospital;

// This class represents one Patient record.
// It stores the patient's details and will be used inside the BST (Binary Search Tree).
public class Patient {

    // Fields (information about the patient)
    private int patientId;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;

    // Constructor - runs when we create a new Patient object
    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    // Getter methods - used to read the patient's details
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    // This method prints the patient details in a readable format.
    // We will use this when displaying patients from the BST.
    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age +
               ", Contact: " + contactNumber +
               ", Condition: " + medicalCondition;
    }
}