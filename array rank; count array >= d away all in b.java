// Given two integer arrays a and b, and an integer value d, your task is to find the comparator value between these arrays.

// The comparator value is defined as the number of elements x ∈ a such that there are no elements y ∈ b where |x - y| ≤ d. 
// In other words, it's the number of elements in a that are more than d away from any element of b.
//|x - y| > d
// -d > x-y > d
// -d > x-min     x-max > d
// -d +min > x    x > d + max

    
// Return the comparator value as an integer.

// For eg. a = [2, 9] and b = [16, 13, 8], d = 3 should return 1.

// n = 9
// 9 - 16 = 7 > 3
// 9 - 13 = 4 > 3
// 9 - 8 = 1 < 3

// n = 2
// 2 - 16 = 14 > 3
// 2 - 13 = 11 > 3
// 2 - 8 = 6 > 3
    
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        int[] a = {1, 2,3,7, 9,8, 99,11,12} ; 
        int[] b = {16, 13, 8};
        int  d = 3;
    
        System.out.println(
            arrayRankOf(a,b,d));
    }
    
    public static int arrayRankOf(int[] a, int[] b, int d) {
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for(int n: b){
            max = Math.max(n,max);
            min = Math.min(n,min);
        }
        
        // System.out.println(min+" , "+max);
        
        Arrays.sort(a, 0, a.length);
        // System.out.println(Arrays.toString(a));
        
        
// -d +min > x    x > d + max
        var i1 = Arrays.binarySearch(a, -d + min);
        if(i1 < 0)
            i1 = -(i1 + 1);
        // System.out.println(i1);
        
        
        var i2 = Arrays.binarySearch(a, d + max);
        if(i2 < 0)
            i2 = -(i2 + 1);
        // System.out.println(i2);
        
        int r = a.length - i2 + i1;
            
        return r;
        
        // return -1;
    }
}



