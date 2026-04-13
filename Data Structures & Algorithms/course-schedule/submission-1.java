class Solution {

    private int[] visited;
    private List<List<Integer>> adj;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        visited = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                if(!dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node) {
        if(visited[node] == 1) {
            return false;
        }

        if(visited[node] == 2) {
            return true;
        }

        visited[node] = 1;

        for(int neighbour : adj.get(node)) {
            if(!dfs(neighbour)) {
                return false;
            }
        }

        visited[node] = 2;

        return true;
    }
}
