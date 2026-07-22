//! Connected Components

//? Intuition:
//* A component is like a group of directly or indirectly connected nodes 
//* and no other nodes outside of the group. Every node in a component can be visited from every other node in the same province.
//* To solve this problem, all the nodes and their connections can be explored to identify these groups. 
//* For this, the traversal techniques BFS and DFS can be used and every time, we had to start from a new node, a new group of nodes(component) is explored.

public class J2_Connected_Components {
    public static void main(String[] args) {

        //? To see the example go to tuf+ : 

        //?  n = 10
        //?  m = 8
        //? (There are 4 different graphs, here called as 4 components as these whole 4 itself is an Graph but not directly connected)

        //? so for this particular example : 
        
        //! idea/way/algo : 
        // int[] visited = new int[11];  //? n+1 size
        // int cnt = 0;

        // for(int i=1; i<=10; i++){   //? i=1 to i<=n  (for 1 based value vertices graph)
        //     if(visited[i] != 1){
        //         cnt++;
        //         traversal(i, adj, visited);    //? we haven't done traversal yet so that implementation will be in upcoming files
        //         //? and there as we move in traversal we will mark visited[i] = 1
        //     }
        // }

        //* So at higher level, this is the algo/way to count no. of components

        //? Time Complexity : O(V + E)
        //? Space Complexity : O(V + E)
    }
}
