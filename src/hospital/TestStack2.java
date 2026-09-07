package hospital;

// Temporary test class to check that TreatmentStack works correctly.
public class TestStack2 {

    public static void main(String[] args) {
        TreatmentStack stack = new TreatmentStack();

        System.out.println("---- Try pop on empty stack ----");
        stack.pop();

        System.out.println("\n---- Push 3 completed treatments ----");
        Patient p1 = new Patient(301, "Nadeesha Perera", 33, "0741111111", "Migraine");
        Patient p2 = new Patient(302, "Roshan Silva", 47, "0752222222", "Sprained Ankle");
        Patient p3 = new Patient(303, "Ishara Fernando", 22, "0763333333", "Allergic Reaction");

        stack.push(p1, "Given pain relief medicine");
        stack.push(p2, "Ankle bandaged and rested");
        stack.push(p3, "Given antihistamine injection");

        System.out.println("\n---- Display treatment history ----");
        stack.display();

        System.out.println("\n---- Pop most recent treatment ----");
        stack.pop();

        System.out.println("\n---- Display treatment history after pop ----");
        stack.display();
    }
}