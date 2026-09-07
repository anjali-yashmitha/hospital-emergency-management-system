package hospital;

// This class represents one Visit record for a patient.
// It stores details of a past hospital visit and will be used inside a Singly Linked List.
public class Visit {

    // Fields (information about the visit)
    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    // Constructor - runs when we create a new Visit object
    public Visit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // Getter methods - used to read the visit's details
    public int getVisitId() {
        return visitId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    // This method prints the visit details in a readable format.
    @Override
    public String toString() {
        return "Visit ID: " + visitId +
               ", Date: " + visitDate +
               ", Doctor: " + doctorName +
               ", Diagnosis: " + diagnosis +
               ", Treatment: " + treatment;
    }
}