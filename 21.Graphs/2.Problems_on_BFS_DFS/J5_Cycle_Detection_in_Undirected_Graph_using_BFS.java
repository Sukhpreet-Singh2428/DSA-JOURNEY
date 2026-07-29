//* Cycle Detection in Undirected Graph using BFS 
//! (Hard Problem)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int node;
    int parent;

    public Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
public class J5_Cycle_Detection_in_Undirected_Graph_using_BFS {

    //* Cycle detection using BFS : 
    public static boolean detect(int src, List<List<Integer>> adjList, boolean[] vis){
        vis[src] = true;
        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(src, -1));

        while(!qu.isEmpty()){
            int node = qu.peek().node;
            int parent = qu.peek().parent;
            qu.poll();

            for(int it : adjList.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    qu.offer(new Pair(it, node));
                }
                else if(parent != it){
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean isCycle_usingBFS(List<List<Integer>> adjList){
        int v = adjList.size();

        boolean[] vis = new boolean[v];

        boolean ans = false;
        for(int i=0; i<v; i++){     ///? To check every component of Graph, if they had cycle or not ! 
            if(vis[i] == false){
                ans = detect(i, adjList, vis);
                if(ans) break;
            }
        }

        return ans;
    }
    //? Time Complexity : O(V + 2E)
    //? Space Complexity : O(V) [vis] + O(V) [queue]


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
        boolean ans = isCycle_usingBFS(adjList);
        System.out.println(ans);
        //? Time Complexity : O(V + 2E)
        //? Space Complexity : O(V) [vis] + O(V) [queue]
    }
}
