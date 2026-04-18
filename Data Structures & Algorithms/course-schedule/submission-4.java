class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(dfs(i, adj, visited, recStack)) {
                    return false;
                }
            }
        }

        return true;
        
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                         boolean[] visited, boolean[] recStack) {

            visited[node] = true;
            recStack[node] = true;

            for(int nei : adj.get(node)) {
                if(!visited[nei]) {
                    if(dfs(nei, adj, visited, recStack)) {
                        return true;
                    }
                } else if(recStack[nei]) {
                    return true;
                }
            }

            recStack[node] = false;

            return false;

    }
}
