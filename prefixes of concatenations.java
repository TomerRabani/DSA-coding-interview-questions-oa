// https://leetcode.com/discuss/interview-question/928723/Uber-or-OA-or-CodeSignal
// Prefix String - given two string arrays A & B, find if all strings in B are prefixes of a concatenation of strings in A. 
//For example if A = {"one", "two", "three"} B = {"onetwo", "one"}, return True
//assuming all lower case words
public class Main {
    public static Boolean isPrefixStrings(String[] a,String[] b) {
    
        var map = new HashSet[26];
        for(var w :a){
            int ind= w.charAt(0) - 'a';
            if(map[ind]==null)
               map[ind] = new HashSet<String>();
            map[ind].add(w);
        }
        
        for(var w :b){
            int i = 0;
                        // System.out.println("## "+ w );
            while(i < w.length()){
                int ind = w.charAt(i)-'a';
                if(map[ind] == null)
                    return false;
                var set = (HashSet<String>)map[ind];
                Boolean found = false;
                for(String seg : set){
                    var len = seg.length();
                        // System.out.println("** "+ w + " "+seg+" "+ len
                        //                    +" " + (w.length() - i ));
                    if(seg.length()> w.length() - i ){
                        len = w.length() - i ;
                    }
                    if(w.substring(i, i + len).equals(seg.substring(0, len ))){
                        found = true;
                        i += len;
                        break;
                    }
                }
                if(found ==false)
                    return false;
             // System.out.println(i + " " + w);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        String[] a = {"one", "two", "three"};
        String[] b = {"onetwo","onetw", "one"};
        var r = isPrefixStrings(a,b);
        
        System.out.println(r);
        
    }
}

