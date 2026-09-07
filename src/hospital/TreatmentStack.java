package hospital;

// This class implements a Stack to store completed treatment records.
// It follows LIFO (Last-In, First-Out): the most recently completed treatment is removed first.
public class TreatmentStack {

    // A Node holds one treatment record and a link to the node below it.
    private class Node {
        Patient patient;
        String treatmentNote;
        Node next;

        Node(Patient patient, String treatmentNote) {
            this.patient = patient;
            this.treatmentNote = treatmentNote;
            this.next = null;
        }
    }

    private Node top; // the most recently completed treatment

    public TreatmentStack() {
        top = null;
    }

    // ---------- PUSH ----------
    // Adds a completed treatment record on top of the stack.
    public void push(Patient patient, String treatmentNote) {
        Node newNode = new Node(patient, treatmentNote);
        newNode.next = top;
        top = newNode;

        System.out.println("Treatment recorded for: " + patient.getName());
    }

    // ---------- POP ----------
    // Removes and returns the most recently completed treatment record.
    public Node pop() {
        if (isEmpty()) {
            System.out.println("No treatment records to remove.");
            return null;
        }

        Node removed = top;
        top = top.next;
        return removed;
    }

    // ---------- DISPLAY ----------
    // Shows all treatment records, most recent first.
    public void display() {
        if (isEmpty()) {
            System.out.println("No treatment records yet.");
            return;
        }

        System.out.println("---- Treatment history (most recent first) ----");
        Node current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.patient + " | Treatment: " + current.treatmentNote);
            current = current.next;
            count++;
        }
    }

    // ---------- EMPTY CHECK ----------
    // Returns true if there are no treatment records.
    public boolean isEmpty() {
        return top == null;
    }
}