
// javac Ring.java
// java Ring
import java.util.*;

public class Ring {
    int max_processes;
    int coordinator;
    boolean[] processes;
    ArrayList<Integer> pidList;

    public Ring(int max) {
        max_processes = max;
        coordinator = max;
        processes = new boolean[max];
        pidList = new ArrayList<>();

        System.out.println("\nCreating processes...");
        for (int i = 0; i < max; i++) {
            processes[i] = true;
            System.out.println("P" + (i + 1) + " created");
        }
        System.out.println("P" + coordinator + " is the initial coordinator\n");
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

    void initElection(int process_id) {
        System.out.println("\nElection initiated by P" + process_id);

        pidList.clear();
        int temp = process_id - 1;

        while (true) {
            if (processes[temp]) {
                pidList.add(temp + 1);
                System.out.print("P" + (temp + 1) + " passing list: ");
                displayList(pidList);
            }

            temp = (temp + 1) % max_processes;
            if (temp == process_id - 1)
                break;
        }

        coordinator = Collections.max(pidList);
        System.out.println("P" + coordinator + " is elected as the new coordinator\n");
    }

    void displayList(ArrayList<Integer> list) {
        System.out.print("[ ");
        for (Integer id : list) {
            System.out.print("P" + id + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Ring ring = null;
        int max_processes = 0, process_id;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Ring Algorithm Menu ===");
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
                    ring = new Ring(max_processes);
                    break;
                case 2:
                    if (ring != null) ring.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter process number to bring up: ");
                    process_id = sc.nextInt();
                    ring.upProcess(process_id);
                    break;
                case 4:
                    System.out.print("Enter process number to bring down: ");
                    process_id = sc.nextInt();
                    ring.downProcess(process_id);
                    break;
                case 5:
                    System.out.print("Enter the process initiating election: ");
                    process_id = sc.nextInt();
                    ring.initElection(process_id);
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
