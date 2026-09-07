# Mini Hospital Emergency Management System

## CIT300 - Data Structures and Algorithms - Individual Mid Assignment

### Overview

This project simulates a **Mini Hospital Emergency Management System** in Java. It manages patient registration, emergency treatment requests, treatment completion, and patient visit history using four core data structures.

### Data Structures Used

| Data Structure | Class | Purpose |
|---|---|---|
| Binary Search Tree (BST) | `PatientBST.java` | Stores patient records using Patient ID as the key. Supports insert, search, delete, and in-order traversal (patients displayed in ascending ID order). |
| Queue | `EmergencyQueue.java` | Manages patients waiting for emergency treatment using FIFO (First-In, First-Out). Supports enqueue, dequeue, and display. |
| Stack | `TreatmentStack.java` | Stores completed treatment records using LIFO (Last-In, First-Out). Supports push, pop, and display. |
| Singly Linked List | `VisitLinkedList.java` | Stores each patient's past hospital visit history. Supports adding, removing, searching, and displaying visits. |

### Supporting Classes

- `Patient.java` - Represents one patient record (ID, Name, Age, Contact Number, Medical Condition).
- `Visit.java` - Represents one visit record (Visit ID, Visit Date, Doctor Name, Diagnosis, Treatment).
- `Main.java` - The main entry point with a menu-driven interface connecting all data structures.

### How to Run

1. Clone this repository.
2. Open the project in Eclipse (or any Java IDE).
3. Run `Main.java` as a Java Application.
4. Follow the on-screen menu to interact with the system.

### Menu Options

1. Add New Patient (BST)
2. Search Patient by ID (BST)
3. Delete Patient (BST)
4. Display All Patients - In-order (BST)
5. Add Patient to Emergency Queue
6. Treat Next Patient (Dequeue + Push to Treatment Stack)
7. Display Emergency Queue
8. Add Visit to Patient History (Linked List)
9. View Patient Visit History (Linked List)
- **0** - Exit

### Project Structure

    hospital-emergency-management-system/
    └── src/
        └── hospital/
            ├── Patient.java
            ├── PatientBST.java
            ├── EmergencyQueue.java
            ├── TreatmentStack.java
            ├── Visit.java
            ├── VisitLinkedList.java
            └── Main.java

### Author

C. H. M. A. Y. K. Monarawila - 23DA2-0212
