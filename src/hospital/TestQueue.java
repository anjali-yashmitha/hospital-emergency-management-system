package hospital;

// Temporary test class to check that EmergencyQueue works correctly.
public class TestQueue {

    public static void main(String[] args) {
        EmergencyQueue queue = new EmergencyQueue();

        System.out.println("---- Try dequeue on empty queue ----");
        queue.dequeue();

        System.out.println("\n---- Enqueue 3 patients ----");
        queue.enqueue(new Patient(201, "Sunil Rathnayake", 40, "0711111111", "Broken Arm"));
        queue.enqueue(new Patient(202, "Priya Jayasuriya", 28, "0722222222", "High Fever"));
        queue.enqueue(new Patient(203, "Chamara De Silva", 55, "0733333333", "Chest Pain"));

        System.out.println("\n---- Display waiting patients ----");
        queue.display();

        System.out.println("\n---- Dequeue next patient for treatment ----");
        Patient next = queue.dequeue();
        System.out.println("Now treating: " + next);

        System.out.println("\n---- Display waiting patients after dequeue ----");
        queue.display();
    }
}