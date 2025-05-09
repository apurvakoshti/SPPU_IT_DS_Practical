// javac Bully.java
// java Bully

import java.util.*;

public class Bully {
    int coordinator;
    int max_processes;
    boolean[] processes;

    public Bully(int max) {
        max_processes = max;
        processes = new boolean[max_processes];
        coordinator = max;

        System.out.println("\nCreating processes...");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("P" + (i + 1) + " created");
        }
        System.out.println("Process P" + coordinator + " is the initial coordinator\n");
    }

    void displayProcesses() {
        System.out.println("\nProcess Status:");
        for (int i = 0; i < max_processes; i++) {
            System.out.println("P" + (i + 1) + " is " + (processes[i] ? "up" : "down"));
        }
        System.out.println("Current coordinator: P" + coordinator + "\n");
    }

    void upProcess(int process_id) {
        if (!processes[process_id - 1]) {
            processes[process_id - 1] = true;
            System.out.println("Process P" + process_id + " is now up.");
        } else {
            System.out.println("Process P" + process_id + " is already up.");
        }
    }

    void downProcess(int process_id) {
        if (!processes[process_id - 1]) {
            System.out.println("Process P" + process_id + " is already down.");
        } else {
            processes[process_id - 1] = false;
            System.out.println("Process P" + process_id + " is now down.");
        }
    }

    void runElection(int process_id) {
        System.out.println("\nElection initiated by Process P" + process_id);
        int elected = process_id;

        for (int i = process_id; i < max_processes; i++) {
            System.out.println("Election message sent from P" + process_id + " to P" + (i + 1));
            if (processes[i]) {
                elected = i + 1;
            }
        }

        coordinator = elected;
        System.out.println("P" + coordinator + " is elected as the new coordinator\n");
    }

    public static void main(String[] args) {
        Bully bully = null;
        int max_processes = 0, process_id;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Bully Algorithm Menu ===");
            System.out.println("1. Create processes");
            System.out.println("2. Display processes");
            System.out.println("3. Up a process");
            System.out.println("4. Down a process");
            System.out.println("5. Run election");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of processes: ");
                    max_processes = sc.nextInt();
                    bully = new Bully(max_processes);
                    break;
                case 2:
                    if (bully != null) bully.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter process number to bring up: ");
                    process_id = sc.nextInt();
                    bully.upProcess(process_id);
                    break;
                case 4:
                    System.out.print("Enter process number to bring down: ");
                    process_id = sc.nextInt();
                    bully.downProcess(process_id);
                    break;
                case 5:
                    System.out.print("Enter the process initiating election: ");
                    process_id = sc.nextInt();
                    bully.runElection(process_id);
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
