/**
 * @URL: https://leetcode.com/problems/car-pooling/
 */

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // return carPooling1(trips, capacity);
        return carPooling2(trips, capacity);
    }

    /**
     * Time : O(nlog(n))
     * Space: O(n)
     */
    public boolean carPooling1(int[][] trips, int capacity) {
        // As we are going in only one direction, sort the given trips based on starting location.
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        if (trips[0][0] > capacity) {
            return false;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] trip : trips) {
            // For each trip, drop all the passenger whose drop location is before the current trip's start location.
            // Also increasing the current capacity by the number of passengers dropped.
            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                capacity += pq.poll()[0];
            }

            // Reduce the capacity by number of new passengers picked. If we can't pick the new passengers, return false.
            capacity -= trip[0];
            if (capacity < 0) {
                return false;
            }
            pq.offer(trip);
        }
        return true;
    }

    /**
     * Time : O(n)
     * Space: O(1)
     */
    public boolean carPooling2(int[][] trips, int capacity) {
        // Keep picking and dropping the passengers according to their respective trip information.
        int[] picked = new int[1001];
        for (int[] trip : trips) {
            picked[trip[1]] += trip[0];
            picked[trip[2]] -= trip[0];
        }

        if (picked[0] > capacity) {
            return false;
        }

        // Check if at any point of time the current passenger count is more than capacity. If there is any then return false.
        for (int i = 1; i <= 1000; ++i) {
            picked[i] += picked[i - 1];
            if (picked[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}