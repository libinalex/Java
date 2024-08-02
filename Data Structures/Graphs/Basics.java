/* 
Connected Components:

Given an undirected graph with 10 nodes and 8 edges. 
The edges are (1,2), (1,3), (2,4), (4,3), (5,6), (5,7), (6,7), (8,9) .
The graph that can be formed with the given information is as follows:

1--2    5      8   
|  |   / \     |    10
3--4  6---7    9

Apparently, it's a graph, which is in 4 pieces, the last one being a single node. In this case, we can say, the graph has been broken down into 4 different connected components. 
So next time if you see two different parts of a graph and they are not connected, then do not say that it cannot be a single graph. 
In the above example, they can be 4 different graphs but according to the given question and the input, we can call them parts of a single graph.

n = 10, m = 8

Therefore, for any graph traversal, we use the visited[] array in order to traverse even the non connected components.
for(int i=1 -> 10)
    if(!visited[i])
        traversal(i);
        
*/