//* Number of Provinces
//! (Medium Problem)

//? 0-Indexed Based Undirected Graph

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J1_Number_of_Provinces {

    //? using dfs traversal 
    public static void dfs(int node, boolean[] vis, List<List<Integer>> adj){
        vis[node] = true;

        for(int it : adj.get(node)){
            if(vis[it] == false){
                dfs(it, vis, adj);
            }
        }
    }
    public static int numberOfProvinces(List<List<Integer>> adj){
        int v = adj.size();

        boolean[] vis = new boolean[v];
        int cnt = 0;
        
        for(int i=0; i<v; i++){
            if(vis[i] == false){
                cnt++;
                dfs(i, vis, adj);   //? or we can use bfs traversal
            }
        }

        return cnt;
    }
    //? Time Complexity :  O(N) + O(N + 2*M) => O(V) + O(V + 2*E)
    //? Space Complexity : O(V) [recursive stack space] + O(V) [vis]


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>(n);
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

        //* Optimal : 
        int provinces = numberOfProvinces(adj);
        System.out.println(provinces);
        //? Time Complexity :  O(N) + O(N + 2*M) => O(V) + O(V + 2*E)
        //? Space Complexity : O(V) [recursive stack space] + O(V) [vis]
    }

    //! If Problem is given with adjacency Matrix, instead of adjacency List
    public List<List<Integer>> adjMatrix_To_adjList(int[][] isConnected){
        int v = isConnected.length;

        List<List<Integer>> adjList = new ArrayList<>(v+1);
        for(int i=0; i<=v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i+1).add(j+1);
                }
            }
        }

        return adjList;
    }
    public void dfs(int node, List<List<Integer>> adjList, boolean[] vis){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(vis[it] == false){
                dfs(it, adjList, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> adjList = adjMatrix_To_adjList(isConnected);

        boolean[] vis = new boolean[v+1];
        int cnt = 0;
        for(int i=1; i<=v; i++){
            if(vis[i] == false){
                cnt++;
                dfs(i, adjList, vis);
            }
        }

        return cnt;
    }
}
