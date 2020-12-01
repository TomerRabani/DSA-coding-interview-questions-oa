// in a n*n matrix find max sum of k*k matrix 
// 0<k<n

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static int getLineSum(int[][] m, int k, int r, int c, String type) {
    if(type=="row" && k+c>m.length
       ||type=="col" && k+r>m.length)
     return -99999;
      
    var s = 0;
    for(int i = 0; i<k; i++){
      if(type== "row")
        s+= m[r][c+i];
      else
        s+= m[r+i][c];
    }      
    
        // System.out.println(s);
    return s;
  }
  
  public static int getMaxKSum(int[][] m, int k) {
    var f = 0;
    for(int i= 0; i < k; i++)
      f+=getLineSum(m, k, i, 0, "row");
 
    
 
    var max = Integer.MIN_VALUE;
    
    for(int i= 0; i < m.length-k+1; i++){
      int s= f;
      
        // System.out.println(s);
        max = Math.max(max, f);
      for(int j= 1; j < m.length-k+1; j++){
        if(i==0 && j==0)
          continue;
        s-= getLineSum(m, k, i, j-1, "col");
        // System.out.println(i+" "+(j-1));
        s+= getLineSum(m, k, i, j+k-1, "col");
        // System.out.println(i+" "+(j+k-1));
      
        max = Math.max(max, s);
        // System.out.println(s);
      }
      
      f-= getLineSum(m, k, i, 0, "row");
      if(i+k<m.length)
        f+= getLineSum(m, k, i+k, 0, "row");
    
    }
      
    return max;
  }
  public static void main(String[] args) {
    int[][] m = {
        {1,2,3,4}
      , {4,500,6,7}
      , {7,8,9,10}
      , {7,8,9,10}
    };
    
    int k= 2;
    
    
    System.out.println(getMaxKSum(m, k));
  }
}
