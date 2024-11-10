import java.util.LinkedList;
import java.util.Queue;

public class CheckoutCounter {
    protected Queue<Customer> queue;
    protected int totalWaitTime;
    protected int maxQueueLength;
    protected int totalCustomers;
    protected int freeTime;

    public CheckoutCounter() {
        queue = new LinkedList<>();
        totalWaitTime = 0;
        maxQueueLength = 0;
        totalCustomers = 0;
        freeTime = 0;
    }

    public void addCustomer(Customer customer, int currentTime) {
        queue.add(customer);
        totalCustomers++;
        int waitTime = (queue.size() - 1) * 5 * customer.getItems();
        totalWaitTime += waitTime;
        maxQueueLength = Math.max(maxQueueLength, queue.size());
    }

    public void processCustomer(int currentTime) {
        if (!queue.isEmpty()) {
            Customer current = queue.peek();
            int processingTime = current.getItems() * 5;
            if (processingTime <= 0) {
                queue.poll();
            }
        } else {
            freeTime++;
        }
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public double getAverageWaitTime() {
        return totalCustomers > 0 ? (double) totalWaitTime / totalCustomers : 0;
    }

    public int getFreeTime() {
        return freeTime;
    }
}
