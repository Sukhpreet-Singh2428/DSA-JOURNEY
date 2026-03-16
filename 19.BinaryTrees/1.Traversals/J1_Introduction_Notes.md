### Binary Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-vnNsZFi8)

**Binary Tree:** A fundamental hierarchical data structure in computer science that comprises nodes arranged in a tree-like structure. It consists of nodes, where each node can have at most two children nodes, known as the left child and the right child.

**Nodes:** Each node in a binary tree contains a piece of data, often referred to as the node’s value or key. This node also contains references and pointers to its left and right children so that we can traverse from one node to another in a hierarchical order.

### Root Node

**Root Node:** The topmost node of a binary tree from which all other nodes stem out. This serves as the entry point for traversing the tree structure.

### Children Nodes

**Children Nodes:** Nodes directly connected to a parent node. In a binary tree, a parent node can have zero, one, or two children nodes, each situated to the left or right of the parent node.

**Leaf Nodes:** Nodes that do not have any children. These nodes lie on the outermost ends of the tree branches and are the terminal points of the traversal.

### Ancestors

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-hpgjbioN)

**Ancestors:** Nodes that lie on the path from a particular node to the root node. They are the nodes encountered while moving upwards from a specific node through its parent nodes until reaching the root of the tree.

### Full Binary Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/--wVHj5sP)

**Full Binary Tree:** Also known as a Strict Binary Tree, where every node has either zero or two children. No node of this tree has just a single child; all internal nodes have exactly two children or no children if they are leaf nodes.

The property that each node has either 2 or 0 children contributes significantly to the tree’s balance, making traversal, searching, and insertion options more predictable and efficient. The emphasis on having exactly two children optimises space utilisation and makes the tree more balanced.

### Complete Binary Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-biZvAp4M)

**Complete Binary Tree:** A specialised form of Binary Tree where all levels are filled completely except possibly the last level, which is filled from left to right. All levels of the tree, except possibly the last one, are fully filled. If the last level is not completely filled, it is filled from left to right, ensuring that nodes are positioned as far left as possible.

In a complete binary tree, all leaf nodes are in the last level or the second-to-last level, and they are positioned towards the leftmost side.

This structure is particularly useful for storing data in structures like heaps, where efficient access to the top element (root) or certain properties (e.g., maximum or minimum values in a heap) is crucial. The completeness property aids in achieving balanced structures, making it easier to implement algorithms and ensuring reasonably consistent performance.

Although it might seem similar to a full binary tree, a complete binary tree doesn't require all nodes to have two children; it's about the positioning and arrangement of nodes.

### Perfect Binary Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-xs24GWXC)

**Perfect Binary Tree:** A type of Binary Tree where all leaf nodes are at the same level and the number of leaf nodes is maximised for that level. Every node in a perfect binary tree has either zero or two children. This means that every internal node (non-leaf node) has exactly two children and all leaf nodes are at the same level.

All levels of this tree are fully filled with nodes including the last level. Perfect Binary Trees have a balanced structure that maximises the number of nodes for a given height, creating a dense structure where the number of nodes doubles as we move down each level of the tree.

Properties of perfect binary trees make them efficient for certain operations like searching and sorting due to their balanced nature. However, achieving and maintaining perfect balance, especially when the number of nodes is not a power of two, might not be feasible in many practical applications.

### Balanced Binary Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-siXk-w3q)

**Balanced Binary Tree:** A type of Binary Tree where the heights of the two subtrees of any node differ by at most one. This property ensures that the tree remains relatively well-balanced, preventing the tree from becoming highly skewed or degenerate.

In a balanced binary tree, the height of the tree should be log2N at maximum, where N is the number of nodes. This ensures that the tree does not become heavily skewed or imbalanced. The distribution of nodes of both the left and right subtrees remains relatively even throughout the tree.

### Degenerate Tree

 ![](https://static.takeuforward.org/premium/Binary%20Trees/Theory%20and%20Traversals/Introduction/-cu7EWvR9)

**Degenerate Tree:** A Binary Tree where the nodes are arranged in a single path leaning to the right or left. The tree resembles a linked list in its structure where each node points to the next node in a linear fashion.

Each level of this tree only has one node. The height of the tree reaches ‘n’, i.e., the number of nodes in the tree, resulting in inefficient search operations. Though degenerate trees are not commonly used intentionally due to their inefficient nature for most operations, they may occur inadvertently in scenarios where nodes are inserted in a specific order (e.g., always to the right or left), causing the tree to lose its balanced properties.

Understanding degenerate trees is essential in analysing the worst-case time complexity of algorithms in scenarios where the tree structure degrades to this linear form, as it can help in optimising algorithms for these situations.

### In Summary

 ![](https://takeuforward.org/plus/dsa/problems/introduction-?source=strivers-a2z-dsa-track)

In summary, Binary Trees introduce a hierarchical arrangement taking a step ahead of the linear structure we have studied so far.

Binary Trees comprise nodes, each capable of hosting at most two children hence the predecessor ‘Binary’. These structures mirror the hierarchical organisation seen in file systems.

Full Binary Trees impose the constraint that each node possesses either zero or two children, promoting a well-balanced structure and enhancing predictability in operations like traversal and insertion.

Complete Binary Trees embrace a specialised form where all levels, save possibly the last, are completely filled. Their design ensures nodes are positioned leftmost on the last level, proving valuable for efficient data storage and access, resembling the organised arrangement of folders and files in a computer system.

Perfect Binary Trees showcase a balanced structure where all leaf nodes align at the same level. Such trees optimise space by filling all levels with nodes, creating a dense structure.

Balanced Binary Trees ensure the difference in heights between subtrees of any node remains minimal, preventing significant skewing or imbalance.

Degenerate Trees represent a case where nodes arrange linearly, akin to a linked list, posing inefficiencies in search operations due to the lack of balance.