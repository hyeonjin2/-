class Solution {
    boolean[] visited;    
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int answer = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int[][] map){
        visited[cur] = true;
        for(int i=0;i<map.length;i++){
            if(!visited[i]&&map[cur][i]==1){
                dfs(i,map);
            }
        }
    }
}