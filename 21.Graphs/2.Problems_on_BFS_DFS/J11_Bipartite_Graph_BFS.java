//* Bipartite Graph
//! (Medium Problem)

//* Bipartite Graph => color the graph with 2 colors such that no adjacent nodes have same color.

//! Linear Graph with no cycle is always an Bipartite Graph
//! Any Graph with even cycle length graph --> Bipartite Graph
//? Any Graph with odd length cycle can never be Bipartite Graph

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class J11_Bipartite_Graph_BFS {

    //? (Bipartite Graph using BFS)
    public static boolean bfs(int start, List<List<Integer>> adjList, int[] color){
        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(start);
        color[start] = 0;   //? starting with color 0

        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.poll();

            for(int it : adjList.get(node)){
                //? if the adjacent node is yet not colored
                //? you will give the opposite color of the node [here, we are using 0 and 1 as 2 different colors]
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    qu.offer(it);
                }
                //? is the adjacent guy having the same color
                //? someone did color it on some other path
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean isBipartiteGraph(List<List<Integer>> adjList){
        int n = adjList.size();

        int[] color = new int[n];
        for(int i=0; i<n; i++){
            color[i] = -1;;
        }

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(bfs(i, adjList, color) == false){
                    return false;
                }
            }
        }

        return true;
    }
    //? Time Complexity :  O(V + 2*E)
    //? Space Complexity : O(V)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
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
        boolean ans = isBipartiteGraph(adjList);
        System.out.println(ans);
        //? Time Complexity :  O(V + 2*E)
        //? Space Complexity : O(V)
    }
}
