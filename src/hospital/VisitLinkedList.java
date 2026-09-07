package hospital;

// This class implements a Singly Linked List to store a patient's visit history.
// Each patient can have their own VisitLinkedList holding their past visits.
public class VisitLinkedList {

    // A Node holds one Visit and a link to the next Node in the list.
    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head; // the first visit in the list

    public VisitLinkedList() {
        head = null;
    }

    // ---------- ADD ----------
    // Adds a new visit to the end of the list.
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("Visit added: Visit ID " + visit.getVisitId());
    }

    // ---------- REMOVE ----------
    // Removes a visit from the list by Visit ID.
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return;
        }

        // If the visit to remove is the first one in the list.
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed.");
            return;
        }

        // Search the rest of the list.
        Node current = head;
        while (current.next != null) {
            if (current.next.visit.getVisitId() == visitId) {
                current.next = current.next.next; // skip over the removed node
                System.out.println("Visit ID " + visitId + " removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Visit ID " + visitId + " not found.");
    }

    // ---------- SEARCH ----------
    // Finds and returns a visit by Visit ID. Returns null if not found.
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null; // not found
    }

    // ---------- DISPLAY ----------
    // Shows all visits in the list, in the order they were added.
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("---- Visit history ----");
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.visit);
            current = current.next;
            count++;
        }
    }
}