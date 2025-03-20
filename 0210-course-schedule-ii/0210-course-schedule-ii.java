class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Fill adjacency list and compute indegree
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course); // prerequisite → course
            indegree[course]++;
        }

        // Step 3: Initialize queue with courses having no prerequisites (indegree == 0)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: Process courses using BFS and store the order
        int[] order = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;

            for (int neighbor : adj.get(course)) {
                indegree[neighbor]--; // Reduce indegree
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 5: If all courses are processed, return order; otherwise, return empty array (cycle detected)
        return index == numCourses ? order : new int[0];
    }
}
