//* Introduction to Graph

//! Introduction to Graph : 
//? Types, Conventions used

//! For Notes and Theory : Go and check the tuf+ 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class pair{
    int vertex;
    int weight;

    public pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "(" + vertex + "," + weight + ")";
    }
}

public class J1_Introduction_to_Graph {
    public static void main(String[] args) {
        
        //? To Store the Graph we use : 
        //* 1) Matrix  => called as, Adjacency Matrix 
        //* 2) List    => called as, Adjacency List

        Scanner sc = new Scanner(System.in);

        //? Graph Representation : 

        //! Undirected Graph :  
        //* Adjacency Matrix : 
        // int n = sc.nextInt();   //? vertices
        // int m = sc.nextInt();   //? edges

        // int[][] adj = new int[n+1][n+1];
        // for(int i=0; i<m; i++){
        //     int u = sc.nextInt();
        //     int v = sc.nextInt();

        //     adj[u][v] = 1;
        //     adj[v][u] = 1;
        // }
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(N^2)  or O(V^2)   [costly]


        //* Adjacency List : 
        // int n = sc.nextInt();
        // int m = sc.nextInt();

        // List<List<Integer>> adj = new ArrayList<>(n+1);
        // //? Initialize the adjacency list
        // for(int i=0; i<=n; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int i=0; i<m; i++){
        //     int u = sc.nextInt();
        //     int v = sc.nextInt();

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

        // System.out.println(adj);
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(2*M) or  O(V + 2*E)  [2 * No. of Edges]


        //! Directed Graph :  
        //* Adjacency Matrix : 
        // int n = sc.nextInt();   //? vertices
        // int m = sc.nextInt();   //? edges

        // int[][] adj = new int[n+1][n+1];
        // for(int i=0; i<m; i++){
        //     int u = sc.nextInt();
        //     int v = sc.nextInt();

        //     adj[u][v] = 1;
        // }
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(N^2)  or  O(V^2)  [costly]


        //* Adjacency List : 
        // int n = sc.nextInt();
        // int m = sc.nextInt();

        // List<List<Integer>> adj = new ArrayList<>(n+1);
        // //? Initialize the adjacency list
        // for(int i=0; i<=n; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int i=0; i<m; i++){
        //     int u = sc.nextInt();
        //     int v = sc.nextInt();

        //     adj.get(u).add(v);
        // }

        // System.out.println(adj);
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(M)  or  O(V + E)  [No. of Edges, O(E)]


        //! Weighted Graph : 

        //? In Adjacency Matrix : 
        // int n = sc.nextInt();   //? vertices
        // int m = sc.nextInt();   //? edges

        // int[][] adj = new int[n+1][n+1];
        // for(int i=0; i<m; i++){
        //     int u = sc.nextInt();
        //     int v = sc.nextInt();
        //     int w = sc.nextInt();

        //     adj[u][v] = w; 
        //     adj[v][u] = w;
        // }
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(M)  or  O(V^2)

        //? In Adjacency List : 
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<pair>> adj = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }

        System.out.println(adj);
        //? Time Complexity : O(M)  or  O(E)
        //? Space Complexity : O(M)  or  O(V + E)

        //! These above are for Undirected Graph, for Directed Graph
        //! Just simply store only for one edge i.e, u --> v

        sc.close();
    }
}
