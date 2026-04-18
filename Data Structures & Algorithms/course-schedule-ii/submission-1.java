class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(dfs(i, adj, visited, recStack, stack)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
        
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                         boolean[] visited, boolean[] recStack,
                         Stack<Integer> stack) {

            visited[node] = true;
            recStack[node] = true;

            for(int nei : adj.get(node)) {
                if(!visited[nei]) {
                    if(dfs(nei, adj, visited, recStack, stack)) {
                        return true;
                    }
                } else if(recStack[nei]) {
                    return true;
                }
            }

            recStack[node] = false;

            stack.push(node);

            return false;

    }
}
