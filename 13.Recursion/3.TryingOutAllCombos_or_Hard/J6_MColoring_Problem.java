//* M Coloring Problem
//! (Hard Problem)

//? Input : N = 4 , M = 3 , E = 5 , Edges = [ (0, 1) , (1, 2) , (2, 3) , (3, 0) , (0, 2) ]
//? Output : true
//* Explanation : Consider the three colors to be red, green, blue.
//* We can color the vertex 0 with red, vertex 1 with blue, vertex 2 with green, vertex 3 with blue.
//* In this way we can color graph using 3 colors at most.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J6_MColoring_Problem {
    public static boolean isSafe(int color, int node, int[] colors, List<List<Integer>> adj){
        for(int i=0; i<adj.get(node).size(); i++){
            int adjNode = adj.get(node).get(i);
            if(colors[adjNode] == color){
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int node, int m, int n, int[] colors, List<List<Integer>> adj){
        if(n == node){
            return true;
        }

        for(int i=1; i<=m; i++){
            if(isSafe(i, node, colors, adj)){
                colors[node] = i;

                if(solve(node+1, m, n, colors, adj)){
                    return true;
                }

                colors[node] = 0;
            }
        }

        return false;
    }
    public static boolean graphColoring(int[][] edges, int m, int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] colors = new int[n];

        return solve(0, m, n, colors, adj);
    }
    //? Time Complexity : O(M^N) where m is the number of colors and n is the number of nodes, 
    //?                     since each node can be colored in m ways and there are n nodes to color.
    //? Space Complexity : O(N) for the colors array and O(n) for the adjacency list, 
    //?                    resulting in O(N) total space complexity.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for(int i=0; i<e; i++){
            for(int j=0; j<2; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        sc.close();

        //* Optimal : 
        System.out.println(graphColoring(edges, m, n));
        //? Time Complexity : O(M^N) where m is the number of colors and n is the number of nodes, 
        //?                     since each node can be colored in m ways and there are n nodes to color.
        //? Space Complexity : O(N) for the colors array and O(n) for the adjacency list, 
        //?                    resulting in O(N) total space complexity.
    }
}
