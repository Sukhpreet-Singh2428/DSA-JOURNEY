//* BFS Traversal 
//! (Medium)

//? BFS of a Graph 
//? BFS --> Breadth First Search  {Breadth => Level wise}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class J4_BFS_Traversal {

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

        //* BFS
        ArrayList<Integer> bfs = bfs_of_Graph(n, adj);
        System.out.println(bfs);
        //? Time Complexity : O(N) [outer while loop] + O(total degrees of vertex, which is 2*E) => O(N) + O(2E)  
        //?                   O(N) + O(2E) => O(V) + O(2E)
        //? Space Complexity : O(3N) => O(N) => O(V)
    }
}
