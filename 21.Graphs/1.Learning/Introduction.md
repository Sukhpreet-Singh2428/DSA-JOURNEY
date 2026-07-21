>  **==Best is to go on tuf+ and study there !==** 

## **What are the different types of data structure?**

Data structures can be broadly classified into two types:

* Linear: Linear data structures are those where data elements are arranged in a sequential(linear) manner. Example: Arrays, Linked List, Stacks, Queues, etc.
* Non-linear: Non-linear data structures are those where data elements are not arranged in a sequential manner. They form a hierarchical or interconnected structure. Example: Trees, Graphs, etc.

  \

## **What is a Graph data structure?**

A graph is a non-linear data structure consisting of nodes that have data and are connected to other nodes through edges. Graphs have a wide-ranging application in real life. These include analysis of electrical circuits, finding the shortest routes between two places, building navigation systems like Google Maps, even social media using graphs to store data about each user, etc.

**There are two main components of graphs:**

* Node(Vertex):
  * Nodes are fundamental units of a graph, representing entities or objects. They store the data.
  * Nodes are circles represented by number (ordering does not matter).
  * They are also referred as vertices.
* Edges(Links):
  * Edges are connection between nodes, representing relationships or interactions between the nodes.
  * Edges are represented by a line connecting two nodes. Edges can also be termed as a pair of vertices.
  * Edges can be of two types:
    * Directed Edges: Edges that have direction, indicating a one-way relationship. Each edge is represented as an ordered pair (u, v), meaning there is a connection from vertex u to vertex v.
    * Undirected Edges: Edges that do not have a direction, indicating a two-way relationship. Each edge is represented as an unordered pair {u, v}, meaning there is a mutual connection between vertex u and vertex v.

    \

## **Types of graphs:**

* **Directed graph:** A graph where all the edges are directed edges, i.e., unidirectional in nature. It contains an ordered pair of vertices. It implies each edge is represented by a directed pair <u, v>. Therefore, <u, v> and <v, u> represent two different edges.
* **Undirected graph:** A graph where all the edges are undirected edges, i.e., bidirectional in nature. In an undirected graph, the pair of vertices representing any edge is unordered. Thus, the pairs (u, v) and (v, u) represent the same edge.

  \

- [ ] Note: An undirected graph can be converted to a directed graph by converting all the undirected edges into directed edges. An undirected edge between two nodes u and v can be represented as pair of two directed edges, one from node u to v, and other from node v to u as shown in the figure:

  \

> Example:
> Consider the following undirected graph:
>
> Here, the graph contains, Number of nodes = 5 and Number of edges = 6 namely:
>
> Between node 1 and node 2.
> Between node 1 and node 4.
> Between node 2 and node 3.
> Between node 2 and node 5.
> Between node 3 and node 5.
> Between node 4 and node 5.

## **Cycle in a graph:**

A graph is said to have a cycle if it is possible to start from a node and end at the same node. A graph may or may not contain cycles in it. Based on this, the graphs can be classified as:

* Cyclic: Graphs having at least one cycle in them.
* Acyclic: Graphs that do not have a cycle in them.

  \

**Note:** A graph's classification as directed or undirected is independent of whether it is cyclic or acyclic. A graph can be any combination of these characteristics: directed and cyclic, directed and acyclic, undirected and cyclic, or undirected and acyclic.

## **Components of a graph:**

It is not necessary that all the nodes in the graph are connected to each other. Here, comes the concept of a component in the graph. A component of a graph is a group of nodes which are connected to each other directly or indirectly and which are not connected any node from any other group.

Example: Consider the following graph:

This graph contains 4 components- {1, 2, 3, 4}, {5, 6, 7}, {8, 9} and {10}.

## **Path in a graph:**

A path in a graph is a sequence of vertices where each adjacent pair of vertices is connected by an edge. A path always contain unique nodes, i.e., a node cannot appear twice in a path.
It can be of two types:

* Simple Path: A path where no vertex is repeated.
* Closed Path (Cycle): A path that starts and ends at the same vertex, with no other repetitions of vertices and edges.

  \

Example:
Consider the following graph:

Here, one of the paths in the graph is: 1 2 3 5.

Note:

* 1 2 3 2 1 is not a path, because a node can't appear twice in a path.
* 1 3 5 is not a path, as adjacent nodes must have an edge and there is no edge between 1 and 3.

## **Degree of a node in graph:**

The degree of a node in a graph is a measure of the number of edges connected to that node.


**==For an undirected graph:==**
Degree: The degree of a vertex is the total number of edges connected to it.


Example:

The degrees of all nodes in the above graph are as follows:
Degree(1) = 2
Degree(2) = 2
Degree(3) = 3
Degree(4) = 2
Degree(5) = 3


Property: The total degree of a graph (sum of degrees of all the nodes) is equal to twice of the number of edges. This is because every edge is associated/connected to two nodes.
Hence, Total degree of graph = 2+2+3+2+3 = 2 X E (where E = 6)


**==For a directed graph:==**
In directed graphs, edges have directions (from one vertex to another), hence, there are two types of degrees:

* In-degree: The in-degree of a vertex is the number of incoming edges to that vertex.
* Out-degree: The out-degree of a vertex is the number of outgoing edges from that vertex.

  \

Example:  The in-degrees and out-degrees of all nodes in the above graph are as follows: In-degree(1) = 0 and Out-degree(1) = 2 In-degree(2) = 2 and Out-degree(2) = 0 In-degree(3) = 1 and Out-degree(3) = 2 In-degree(4) = 2 and Out-degree(4) = 0 In-degree(5) = 1 and Out-degree(5) = 2

## **Edge Weight:**

Some graphs have edges that have weights associated to them. It is often referred to as the cost of the edge.

Based on whether the edges in graph are weighted or unweighted, the graphs can be divided into two types:
Weighted Graphs: Having edges that have weights associated with them.
Unweighted Graphs: Having edges that do not have weights associated with them.

Note: In applications, weight may be a measure of the cost of a route. For example, if vertices A and B represent towns in a road network, then weight on edge AB may represent the cost of moving from A to B, or vice versa.