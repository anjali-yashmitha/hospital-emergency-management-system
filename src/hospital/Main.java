package hospital;

import java.util.Scanner;

// This is the main entry point of the Hospital Emergency Management System.
// It connects the BST, Queue, Stack, and Linked List through a simple text menu.
public class Main {

    // Shared data structures used by the whole program.
    private static PatientBST patientRecords = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentHistory = new TreatmentStack();

    // Each patient has their own visit history, stored using their Patient ID as the key.
    // We reuse the BST idea but keep it simple with a small helper map-like structure.
    private static java.util.HashMap<Integer, VisitLinkedList> visitHistories = new java.util.HashMap<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientRecords.displayInOrder();
                case 5 -> addToQueue();
                case 6 -> treatNextPatient();
                case 7 -> emergencyQueue.display();
                case 8 -> addVisitToHistory();
                case 9 -> viewVisitHistory();
                case 0 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // ---------- MENU DISPLAY ----------
    private static void printMenu() {
        System.out.println("\n===== Mini Hospital Emergency Management System =====");
        System.out.println("1. Add New Patient (BST)");
        System.out.println("2. Search Patient by ID (BST)");
        System.out.println("3. Delete Patient (BST)");
        System.out.println("4. Display All Patients (In-order, BST)");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient (Dequeue + Push to Treatment Stack)");
        System.out.println("7. Display Emergency Queue");
        System.out.println("8. Add Visit to Patient History (Linked List)");
        System.out.println("9. View Patient Visit History (Linked List)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // ---------- HELPER: safely read an integer ----------
    private static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // clear the leftover newline
        return value;
    }

    // ---------- 1. ADD PATIENT ----------
    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = readInt();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = readInt();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientRecords.insert(patient);
        visitHistories.put(id, new VisitLinkedList()); // give the patient an empty visit history
        System.out.println("Patient added successfully.");
    }

    // ---------- 2. SEARCH PATIENT ----------
    private static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = readInt();
        Patient found = patientRecords.search(id);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Patient not found.");
        }
    }

    // ---------- 3. DELETE PATIENT ----------
    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = readInt();
        patientRecords.delete(id);
        visitHistories.remove(id);
    }

    // ---------- 5. ADD TO QUEUE ----------
    private static void addToQueue() {
        System.out.print("Enter Patient ID to add to queue: ");
        int id = readInt();
        Patient patient = patientRecords.search(id);
        if (patient == null) {
            System.out.println("Patient not found. Please add the patient first (Option 1).");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    // ---------- 6. TREAT NEXT PATIENT ----------
    private static void treatNextPatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient == null) {
            return; // message already printed by dequeue()
        }
        System.out.print("Enter treatment note for " + patient.getName() + ": ");
        String note = sc.nextLine();
        treatmentHistory.push(patient, note);
    }

    // ---------- 8. ADD VISIT ----------
    private static void addVisitToHistory() {
        System.out.print("Enter Patient ID: ");
        int id = readInt();
        VisitLinkedList history = visitHistories.get(id);
        if (history == null) {
            System.out.println("Patient not found. Please add the patient first (Option 1).");
            return;
        }

        System.out.print("Enter Visit ID: ");
        int visitId = readInt();
        System.out.print("Enter Visit Date (e.g. 2025-01-10): ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();

        history.addVisit(new Visit(visitId, date, doctor, diagnosis, treatment));
    }

    // ---------- 9. VIEW VISIT HISTORY ----------
    private static void viewVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int id = readInt();
        VisitLinkedList history = visitHistories.get(id);
        if (history == null) {
            System.out.println("Patient not found.");
            return;
        }
        history.displayVisits();
    }
}