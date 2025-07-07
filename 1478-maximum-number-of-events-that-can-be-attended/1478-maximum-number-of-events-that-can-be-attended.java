class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int day = 0;
        int idx = 0;
        int cnt = 0;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        while(idx < n || !pq.isEmpty()) {
            if(pq.isEmpty())  { 
                day = events[idx][0];
            }
            while(idx < n && events[idx][0] <= day) {
                pq.offer(events[idx][1]);
                idx++;
            }
            pq.poll();
            day++;
            cnt++;
            while(!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        return cnt;
    }
}