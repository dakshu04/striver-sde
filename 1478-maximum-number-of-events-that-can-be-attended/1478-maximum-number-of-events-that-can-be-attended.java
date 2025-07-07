class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;

        int day = 0;        // Current day we're considering attending an event
        int idx = 0;        // Index to track position in sorted events array
        int cnt = 0;        // Count of events attended

        // Sort the events by their start day (ascending)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Min-heap to store event end days — lets us always attend the event that ends earliest
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Main loop continues until all events are processed and heap is empty
        while (idx < n || !pq.isEmpty()) {

            // If heap is empty, no event is available to attend today, so jump to next available event's start day
            if (pq.isEmpty()) {
                day = events[idx][0];
            }

            // Add all events starting today or earlier (but not yet added) to the heap
            while (idx < n && events[idx][0] <= day) {
                pq.offer(events[idx][1]);  // Push end day of the event
                idx++;
            }

            // Attend the event that ends the earliest (greedy choice)
            pq.poll();
            day++;      // Move to the next day after attending an event
            cnt++;      // Increment count of attended events

            // Remove all expired events (whose end day is before current day)
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }

        // Return the total number of events attended
        return cnt;
    }
}
