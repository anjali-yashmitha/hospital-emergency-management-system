package hospital;

// Temporary test class to check that VisitLinkedList works correctly.
public class TestLinkedList {

    public static void main(String[] args) {
        VisitLinkedList visits = new VisitLinkedList();

        System.out.println("---- Display when empty ----");
        visits.displayVisits();

        System.out.println("\n---- Add 3 visits ----");
        visits.addVisit(new Visit(1, "2025-01-10", "Dr. Perera", "Flu", "Rest and medicine"));
        visits.addVisit(new Visit(2, "2025-03-22", "Dr. Silva", "Fracture", "Cast applied"));
        visits.addVisit(new Visit(3, "2025-07-15", "Dr. Fernando", "Checkup", "No issues found"));

        System.out.println("\n---- Display all visits ----");
        visits.displayVisits();

        System.out.println("\n---- Search Visit ID 2 ----");
        Visit found = visits.searchVisit(2);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Visit not found.");
        }

        System.out.println("\n---- Search Visit ID 99 (should not exist) ----");
        Visit notFound = visits.searchVisit(99);
        if (notFound != null) {
            System.out.println("Found: " + notFound);
        } else {
            System.out.println("Visit not found.");
        }

        System.out.println("\n---- Remove Visit ID 2 ----");
        visits.removeVisit(2);
        visits.displayVisits();

        System.out.println("\n---- Remove Visit ID 99 (should show error) ----");
        visits.removeVisit(99);
    }
}