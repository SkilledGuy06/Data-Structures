import java.util.Random;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of items for superexpress line:");
        int numSuper = scanner.nextInt();

        System.out.println("Enter number of items for express line:");
        int numExp = scanner.nextInt();

        System.out.println("Enter number of standard counters:");
        int numStandLines = scanner.nextInt();

        System.out.println("Enter customer arrival rate per hour:");
        int arrivalRate = scanner.nextInt();

        System.out.println("Enter maximum number of items:");
        int maxItems = scanner.nextInt();

        System.out.println("Enter maximum simulation time:");
        int maxSimTime = scanner.nextInt();

        CheckoutCounter[] standardCounters = new CheckoutCounter[numStandLines];
        for (int i = 0; i < numStandLines; i++) {
            standardCounters[i] = new CheckoutCounter();
        }

        Random rand = new Random();

        for (int currentTime = 0; currentTime < maxSimTime; currentTime++) {
            if (rand.nextInt(60) < arrivalRate) {
                int items = rand.nextInt(maxItems) + 1;
                Customer customer = new Customer(items, currentTime);

                if (items <= numSuper) {
                    // Add to the shortest queue
                    int minQueue = 0;
                    for (int i = 1; i < standardCounters.length; i++) {
                        if (standardCounters[i].queue.size() < standardCounters[minQueue].queue.size()) {
                            minQueue = i;
                        }
                    }
                    standardCounters[minQueue].addCustomer(customer, currentTime);
                }
            }

            for (CheckoutCounter counter : standardCounters) {
                counter.processCustomer(currentTime);
            }
        }

        double totalAverageWaitTime = 0;
        int totalCustomers = 0;
        int totalFreeTime = 0;
        for (CheckoutCounter counter : standardCounters) {
            totalAverageWaitTime += counter.getAverageWaitTime() * counter.getTotalCustomers();
            totalCustomers += counter.getTotalCustomers();
            totalFreeTime += counter.getFreeTime();
        }

        System.out.println("Overall average wait time: " + (totalAverageWaitTime / totalCustomers));
        System.out.println("Overall free time: " + totalFreeTime);
    }
}
