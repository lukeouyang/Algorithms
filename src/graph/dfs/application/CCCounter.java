package graph.dfs.application;

import graph.basic.Graph;

public class CCCounter {

    private Graph G;
    private boolean[] visited;
    private int cccount = 0;

    public CCCounter(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        for(int v = 0; v < G.V(); v ++)
            if(!visited[v]){
                dfs(v);
                cccount ++;
            }
    }

    private void dfs(int v){

        visited[v] = true;
        for(int w: G.adj(v))
            if(!visited[w])
                dfs(w);
    }

    public int count(){
        return cccount;
    }

    public static void main(String[] args){

        Graph g = new Graph("g.txt");
        CCCounter ccCounter = new CCCounter(g);
        System.out.println(ccCounter.count());
    }
}
