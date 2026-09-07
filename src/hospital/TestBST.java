package hospital;

// This is a temporary test class to check that PatientBST works correctly.
// It is not part of the final menu system - just for testing during development.
public class TestBST {

    public static void main(String[] args) {
        PatientBST bst = new PatientBST();

        // Insert some test patients
        bst.insert(new Patient(105, "Nimal Perera", 45, "0771234567", "Chest Pain"));
        bst.insert(new Patient(102, "Kamala Silva", 30, "0777654321", "Fracture"));
        bst.insert(new Patient(110, "Saman Kumara", 60, "0712345678", "Fever"));
        bst.insert(new Patient(101, "Anusha Fernando", 25, "0709876543", "Asthma"));
        bst.insert(new Patient(108, "Ruwan Bandara", 50, "0765432198", "Diabetes"));

        System.out.println("---- All patients (in-order, sorted by ID) ----");
        bst.displayInOrder();

        System.out.println("\n---- Search for Patient ID 102 ----");
        Patient found = bst.search(102);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n---- Search for Patient ID 999 (should not exist) ----");
        Patient notFound = bst.search(999);
        if (notFound != null) {
            System.out.println("Found: " + notFound);
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n---- Delete Patient ID 102 ----");
        bst.delete(102);
        bst.displayInOrder();

        System.out.println("\n---- Delete Patient ID 999 (should show error) ----");
        bst.delete(999);
    }
}