// https://leetcode.com/discuss/interview-question/928723/Uber-or-OA-or-CodeSignal
// Prefix String - given two string arrays A & B, find if all strings in B are prefixes of a concatenation of strings in A. For example if A = {"one", "two", "three"} B = {"onetwo", "one"}, return True
//assuming all lower case words
public class Main {
    public static Boolean isPrefixStrings(String[] a,String[] b) {
    
        var data = new HashMap<String, Boolean>();
        for(var w :a){
            data.put(w, true);
        }
        for(var w :b){
            if(isPrefixStrings(w,a, data) == false)
                return false;
        }
        return true;
    }
    public static Boolean isPrefixStrings(String w,String[] a
                                          , HashMap<String, Boolean> data) {
        if(data.containsKey(w) )
                return data.get(w) ;
        for(int i = 1; i<= w.length(); i++)
            for(String word : a){
                if(w.startsWith(word)
                   && isPrefixStrings(w.substring(i), a , data)){
                    data.put(w, true);
                    return true;
                }
            }
        data.put(w, false);
        return false;
    }
    
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        
        String[] a = {"one", "two", "three"};
        String[] b = {"onetwo","one", "one"};
        var r = isPrefixStrings(a,b);
        
        System.out.println(r);
        
    }
}

