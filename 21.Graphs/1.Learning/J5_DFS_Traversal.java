//* DFS Traversal 
//! (Medium)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J5_DFS_Traversal {

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

        //* DFS 
        ArrayList<Integer> dfs = dfs_of_Graph(n, adj);
        System.out.println(dfs);
        //? Time Complexity : O(N) + O(Total degrees) => O(N) + O(2*E)
        //?                   O(V) + O(2*E)
        //? Space Complexity : O(N) {ls} + O(N) {vis} + O(N) {recursive stack for worst case of skew-graph}
        //?                    O(V) + O(V) + O(V)
    }
}
