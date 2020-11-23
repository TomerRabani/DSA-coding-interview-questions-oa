// https://www.geeksforgeeks.org/check-if-concatenation-of-any-permutation-of-given-list-of-arrays-generates-the-given-array/


    // Given an array arr[] of N distinct integers and a list of arrays pieces[] of distinct integers, the task is to check if the given list of arrays can be concatenated in any order to obtain the given array. If it is possible, then print “Yes”. Otherwise, print “No”.

// t:O(N) s:O(k) k = p.length
class GFG {
    
     public static void main(String[] args){
        System.out.println("Hello World!");
        int[] t1= {1, 2, 4, 77,33,3};
        
         int[][] p1= {{1}, {4,77 ,33,3}, {2}};
        check(t1,p1); 
         
        int[][] p2 = {{1}, {2}, {3, 4}};
        check(t1, p2); 
    }
    
    public static void check(int[]t, int[][]p) {
        System.out.println(isValid(t, p)); 
    }
    static Boolean isValid(int[]t, int[][]p) {
        
        var map = new HashMap<Integer, int[]>();
        for(int[] a:p ){
            map.put(a[0], a);
        }
        int cur = 0;
        for(int i = 0;i < t.length; ){
           if(!map.containsKey(t[i]))
               return false;
            var a = map.get(t[i]);
            for(int n :a){
                if(t[i] != n)
                    return false;
                
                i++;
            }
        }
        return true;
    }
}
