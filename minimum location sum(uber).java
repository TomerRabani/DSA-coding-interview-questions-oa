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
        int[] from = {1,2,2,3,4,5,22,23,24,22,23,24, 24,24,22};
        int[] to   = {2,4,5,5,5,6,23,24,22,24,22,23, 5,3,1};
        var r =   getMinlocationSum(from,to);
        
        System.out.println(r);
    }
    
    public static HashMap<Integer, HashSet<Integer>> getGraph(int[] from,int[] to) {    
        var adj = new HashMap<Integer, HashSet<Integer>>();
        for(int i = 0; i<to.length; i++ ){
            if(adj.containsKey(from[i]) == false)
                adj.put(from[i], new HashSet());
            adj.get(from[i] ).add(to[i]);
            
            if(adj.containsKey(to[i]) == false)
                adj.put(to[i], new HashSet());
            adj.get(to[i] ).add(from[i]);
        }
        return adj;
    }
        
    public static int getLocationSum(HashSet<Integer> trio
                            , HashMap<Integer, HashSet<Integer>> g){
        HashSet<Integer> related= new   HashSet<Integer> ();
        
        for(Integer i : trio){
            related.addAll(g.get(i));
        }
         related.removeAll(trio);
        return related.size();
    }
    
    public static Boolean areConnected(HashSet<Integer> cur
                                    , int id 
                            , HashMap<Integer, HashSet<Integer>> g){
    
        for(int i : cur)
        {
            if(g.get(i).contains(id)==false)
                return false;
        }
        return true;
    }
            
            
    public static void getTrios(int i
                            , ArrayList<Integer> v    
                            , HashMap<Integer, HashSet<Integer>> g
                            , HashSet<Integer> cur
                            , ArrayList<HashSet<Integer>> trios) {
        
        if(cur.size() == 3){
            cur.toString();
            trios.add(cur);
            return;
        }
        if(i>=v.size()) return;
        
        //not add 
        getTrios(i+1, v, g, new HashSet<Integer>(cur), trios);
        
        
        //add
        Integer id = v.get(i);
        
//         if(cur.size()>0)
//             System.out.println(cur.toString()+"   "+id+ " "+areConnected(cur,id,g));
        if(cur.size()==0 || areConnected(cur,id,g)){
            cur.add(id);
            getTrios(i+1, v, g, cur, trios);
        }
    }
    
    public static int getMinlocationSum(int[] from,int[] to) {
        System.out.println("Hello World!");
        var g= getGraph(from, to);  
        System.out.println(g.size());
        // for(var trio : )
        var trios = new ArrayList<HashSet<Integer>>();
        var f = new ArrayList<>(g.keySet());
        // var f = (Integer[]) g.keySet().toArray();
        // var f = (Integer[])Collection.toArray( g.keySet());
     
        getTrios(0,f ,g,new HashSet<Integer>(), trios) ;
        
        System.out.println(trios.size());
        
        var r = Integer.MAX_VALUE;
        for(HashSet<Integer> trio : trios){
            var lSum = getLocationSum(trio, g);
            
            System.out.println(trio.toString()+"   "+ lSum);
            
            r = Math.min(r,lSum);
        }
        return r;
    }
}

