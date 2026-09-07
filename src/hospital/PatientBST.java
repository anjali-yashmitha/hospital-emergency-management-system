package hospital;

// This class implements a Binary Search Tree (BST) to store Patient records.
// The Patient ID is used as the key to organize the tree.
public class PatientBST {

    // A Node holds one Patient, plus links to left and right child nodes.
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root; // the top of the tree

    public PatientBST() {
        root = null;
    }

    // ---------- INSERT ----------
    // Adds a new patient into the correct position in the tree.
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node current, Patient patient) {
        // If we found an empty spot, place the new patient here.
        if (current == null) {
            return new Node(patient);
        }

        // Compare Patient ID to decide left or right.
        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            // Same ID already exists - do not insert duplicate.
            System.out.println("Patient ID " + patient.getPatientId() + " already exists.");
        }

        return current;
    }

    // ---------- SEARCH ----------
    // Finds and returns a patient by their Patient ID. Returns null if not found.
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node current, int patientId) {
        if (current == null) {
            return null; // not found
        }

        if (patientId == current.patient.getPatientId()) {
            return current.patient; // found it
        } else if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        } else {
            return searchRec(current.right, patientId);
        }
    }

    // ---------- DELETE ----------
    // Removes a patient from the tree by Patient ID.
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node current, int patientId) {
        if (current == null) {
            System.out.println("Patient ID " + patientId + " not found.");
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
        } else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
        } else {
            // Found the node to delete.

            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: one child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 3: two children
            // Find the smallest patient in the right subtree (in-order successor).
            Patient smallest = findMin(current.right);
            current.patient = smallest;
            current.right = deleteRec(current.right, smallest.getPatientId());
        }

        return current;
    }

    // Helper method to find the smallest patient in a subtree (used for delete).
    private Patient findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.patient;
    }

    // ---------- IN-ORDER TRAVERSAL ----------
    // Displays all patients in ascending order of Patient ID.
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);           // visit left side first
            System.out.println(current.patient); // print current patient
            inOrderRec(current.right);          // then visit right side
        }
    }
}