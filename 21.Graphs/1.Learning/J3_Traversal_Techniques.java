//* Traversal Techniques
//! (Medium)

//* Traversal Techniques : 
//? 1) BFS
//? 2) DFS

//? BFS of a Graph 
//? BFS --> Breadth First Search  {Breadth => Level wise}

//? DFS of a Graph
//? DFS --> Depth First Search

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class J3_Traversal_Techniques {

    //* BFS Traversal : 
    public static ArrayList<Integer> bfs_of_Graph(int v, List<List<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> qu = new ArrayDeque<>();

        qu.add(0);   //? Starting node = 0
        vis[0] = true;

        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.poll();

            bfs.add(node);

            for(int it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    qu.add(it);
                }
            }
        }

        return bfs;
    }
    //? Time Complexity : O(N) [outer while loop] + O(total degrees of vertex, which is 2*E) => O(N) + O(2E)  
    //?                   O(N) + O(2E) => O(V) + O(2E)
    //? Space Complexity : O(3N) => O(N) => O(V)

    //* DFS Traversal : 
    public static void dfs(int node, boolean[] vis, List<Integer> ls, List<List<Integer>> adj){
        vis[node] = true;
        ls.add(node);

        for(int it : adj.get(node)){
            if(vis[it] == false){
                dfs(it, vis, ls, adj);
            }
        }
    }
    public static ArrayList<Integer> dfs_of_Graph(int v, List<List<Integer>> adj){
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[v];

        int startingNode = 0;  //? Starting Node = 0
        dfs(startingNode, vis, ls, adj);

        return ls;
    }
    //? Time Complexity : O(N) + O(Total degrees) => O(N) + O(2*E)
    //?                   O(V) + O(2*E)
    //? Space Complexity : O(N) {ls} + O(N) {vis} + O(N) {recursive stack for worst case of skew-graph}
    //?                    O(V) + O(V) + O(V)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>(n);   //? Graph 0 based Index/Value undirected graph
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        sc.close();

        //! Graph is 0-indexed and undirected Graph

        //*  Traversal : 
        //? BFS
        ArrayList<Integer> bfs = bfs_of_Graph(n, adj);
        System.out.println(bfs);
        //? Time Complexity : O(N) [outer while loop] + O(total degrees of vertex, which is 2*E) => O(N) + O(2E)  
        //?                   O(N) + O(2E) => O(V) + O(2E)
        //? Space Complexity : O(3N) => O(N) => O(V)

        //? DFS 
        ArrayList<Integer> dfs = dfs_of_Graph(n, adj);
        System.out.println(dfs);
        //? Time Complexity : O(N) + O(Total degrees) => O(N) + O(2*E)
        //?                   O(V) + O(2*E)
        //? Space Complexity : O(N) {ls} + O(N) {vis} + O(N) {recursive stack for worst case of skew-graph}
        //?                    O(V) + O(V) + O(V)
    }
}
