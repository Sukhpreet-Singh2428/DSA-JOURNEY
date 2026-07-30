//* Detect a Cycle in an Undirected Graph using DFS
//! (Hard Problem)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J6_Detect_a_Cycle_in_an_Undirected_Graph_usingDFS {

    //* Cycle detection using DFS : 
    public static boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adjList){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(vis[it] == false){
                if(dfs(it, node, vis, adjList) == true){
                    return true;
                }
            }
            else if(it != parent){
                return true;
            }
        }

        return false;
    }
    public static boolean isCycle_usingDFS(List<List<Integer>> adjList){
        int v = adjList.size();

        boolean[] vis = new boolean[v];
        boolean ans = false;

        for(int i=0; i<v; i++){
            if(vis[i] == false){
                ans = dfs(i, -1, vis, adjList);
                if(ans) return true;
            }
        }

        return false;
    }
    //? Time Complexity : O(N + 2*M)  =>  O(V + 2*E)
    //? Space Complexity : O(N) [recursive stack space] + O(N) [vis]  =>  O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        sc.close();


        //* Optimal : 
        boolean ans = isCycle_usingDFS(adjList);
        System.out.println(ans);
        //? Time Complexity : O(N + 2*M)  =>  O(V + 2*E)
        //? Space Complexity : O(N) [recursive stack space] + O(N) [vis]  =>  O(N)
    }
}
