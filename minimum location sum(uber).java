// https://leetcode.com/discuss/interview-question/892214/Uber-or-OA-or-CodeSignal
// Uber is trying to assess customer route patters and offer suggestions to other user based on this. Each from and to for a route can be represented as an undirected edge. A group of n locations is uniquely numbered from 1 to n. A trio is defined as a group of 3 related locations that all connected by an edge.
// Trios are scored by counting the number of related locations outside of the trio, this is referred to as location sum.

// Given location relation data, determine the minimum location sum for all trios of related locations in the group, if no such trio return -1

// Example input:
// location_nodes = 6
// location_edges = 6
// from = [1,2,2,3,4,5]
// to = [2,4,5,5,5,6]

// Undirected Edges are basically from[i] to to[i] for each i and vice versa since they are undirected

// Example output
// Answer is 3
// Explanation: The trio here is [2,4,5] and location sum for it is 3 becaue 2 is connected to 1 outside of trio and 3 is connected to 5 outside of trio and 6 is connected to 4 outside of trio. So a total of 3 connected locations outside of the trio.

// If there are multiples trios, return the smallest location sum for those trios
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        
        // location_nodes = 6
        // location_edges = 6
        int[] from = {1,1,2,2,3,4};
        int[] to   = {2,3,3,4,4,5};
        var r =   getMinlocationSum(from,to);
        System.out.println(r);        
        
        
        
        int[] f1 = {1,2,2,3,4,5};
        int[] t1   = {2,4,5,5,5,6};
        r =   getMinlocationSum(f1,t1);
        System.out.println(r);        

        
    }
    
    public static int getMinlocationSum(int[] from,int[] to) {
        // System.out.println("Hello World!$$$");
        var graph = new HashMap<Integer,HashSet<Integer>>();    
        var visited = new HashSet<HashSet>();
        int min_location_sum = Integer.MAX_VALUE;
        for (int i = 0; i< from.length; i++){
            var v1_neibors =  graph.getOrDefault(from[i], new HashSet<Integer>());
            var v2_neibors =  graph.getOrDefault(to[i], new HashSet<Integer>());
            v1_neibors.add(to[i]);
            v2_neibors.add( from[i]);
            graph.put(from[i], v1_neibors);
            graph.put(to[i], v2_neibors);
        }
        for(Map.Entry<Integer, HashSet<Integer>> node: graph.entrySet() ) {
            var neighbors = node.getValue();  // Find the neighbors of that node
                // System.out.println(Arrays.toString(neighbors.toArray()));
            for(Integer neighbor : neighbors){ 
                var neighbor_neighbors = graph.get(neighbor); //
                // System.out.println(Arrays.toString(neighbor_neighbors.toArray()));
                var shared_neighbors = new HashSet<Integer>(neighbor_neighbors);
                shared_neighbors.retainAll(neighbors); 
                // System.out.println(Arrays.toString(neighbor_neighbors.toArray()));
                for (Integer shared_neighbor : shared_neighbors){
                    var trio = new HashSet(Arrays.asList(node, neighbor, shared_neighbor));
                    if (visited.contains( trio)== false){
                        visited.add(trio);
                        var degree = neighbors.size() 
                            + neighbor_neighbors.size() 
                            + graph.get(shared_neighbor).size();
                        var location_sum = degree - 6; //Degree minus 6!
                        min_location_sum = Math.min(min_location_sum, location_sum);
                    }
                }
            }
        }
        return min_location_sum;
    }
}                        







