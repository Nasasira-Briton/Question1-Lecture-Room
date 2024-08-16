import java.util.Scanner;

public class LectureRoom {

    // Inner class for LectureRoom
    static class LectureRoom1 {
        private int numberOfStudents;
        private boolean[] lights; // true = on, false = off

        // Constructor
        public LectureRoom1() {
            this.numberOfStudents = 0;
            this.lights = new boolean[3]; // Assume 3 lights in the room
        }

        // Add students
        public void addStudents(int count) {
            if (count > 0) {
                numberOfStudents += count;
            }
        }

        // Remove students
        public void removeStudents(int count) {
            if (count > 0) {
                numberOfStudents = Math.max(0, numberOfStudents - count);
            }
        }

        // Turn on a specific light
        public void turnOnLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = true;
            }
        }

        // Turn off a specific light
        public void turnOffLight(int lightNumber) {
            if (lightNumber >= 1 && lightNumber <= 3) {
                lights[lightNumber - 1] = false;
            }
        }

        // Display status
        public void displayStatus() {
            System.out.println("Number of students: " + numberOfStudents);
            System.out.print("Lights status: ");
            for (int i = 0; i < lights.length; i++) {
                System.out.print("Light " + (i + 1) + ": " + (lights[i] ? "On" : "Off") + " ");
            }
            System.out.println();
        }
    }

    // Inner class for EasyReader
    static class EasyReader {
        private Scanner scanner;

        public EasyReader() {
            scanner = new Scanner(System.in);
        }

        public int readInt(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
                System.out.print(prompt);
            }
            return scanner.nextInt();
        }

        public String readString(String prompt) {
            System.out.print(prompt);
            return scanner.next();
        }
    }

    // Main method
    public static void main(String[] args) {
        LectureRoom1 room = new LectureRoom1();
        EasyReader reader = new EasyReader();
        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("W - Add students");
            System.out.println("X - Remove students");
            System.out.println("Y - Turn on a light");
            System.out.println("Z - Turn off a light");
            System.out.println("Q - Quit");

            String choice = reader.readString("Enter your choice: ").toUpperCase();

            switch (choice) {
                case "W":
                    int addCount = reader.readInt("Enter the number of students to add: ");
                    room.addStudents(addCount);
                    room.displayStatus();
                    break;

                case "X":
                    int removeCount = reader.readInt("Enter the number of students to remove: ");
                    room.removeStudents(removeCount);
                    room.displayStatus();
                    break;

                case "Y":
                    int lightOn = reader.readInt("Enter the number of the light to turn on (1, 2, or 3): ");
                    room.turnOnLight(lightOn);
                    room.displayStatus();
                    break;

                case "Z":
                    int lightOff = reader.readInt("Enter the number of the light to turn off (1, 2, or 3): ");
                    room.turnOffLight(lightOff);
                    room.displayStatus();
                    break;

                case "Q":
                    running = false;
                    System.out.println("Quitting the program.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
