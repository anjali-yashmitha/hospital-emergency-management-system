package hospital;

// This class implements a Queue to manage patients arriving at the emergency unit.
// It follows FIFO (First-In, First-Out): the first patient added is the first treated.
public class EmergencyQueue {

    // A Node holds one Patient and a link to the next Node in the queue.
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front; // the patient next in line to be treated
    private Node rear;  // the last patient who joined the queue

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // ---------- ENQUEUE ----------
    // Adds a new patient to the back of the waiting queue.
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            // Queue was empty, so this new patient is both front and rear.
            front = newNode;
            rear = newNode;
        } else {
            // Add the new patient after the current rear.
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Added to queue: " + patient.getName());
    }

    // ---------- DEQUEUE ----------
    // Removes and returns the patient at the front of the queue (next for treatment).
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No patients waiting.");
            return null;
        }

        Patient treated = front.patient;
        front = front.next;

        if (front == null) {
            // Queue is now empty, so rear must also be reset.
            rear = null;
        }

        return treated;
    }

    // ---------- DISPLAY ----------
    // Shows all patients currently waiting, in order from front to back.
    public void display() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }

        System.out.println("---- Patients waiting in queue ----");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }

    // ---------- EMPTY CHECK ----------
    // Returns true if there are no patients waiting.
    public boolean isEmpty() {
        return front == null;
    }
}