/*

A record of (B, A) pair indicates B is child of A. Assume one may be child of single parent.

Write a function to generate report:
how many nodes could be descendants of each node in the list.
Input:
1) a list of pairs<name1, name2>
2) a list of names

Example:
1) {(B, A), (C, A), (D, B), (E, B), (F, C), (G, E), (H, B)}  
2) {A, G, B}   
-
      A
     / \
    B   C
   /\\   \
  D E H   F
    /
   G

Output: print a report like below
A : 7
G : 0
B : 4

Clarification
* There may be multiple 'root' nodes.
* No assumption on the names in the report(can be nodes at any level)
* All names are unique.
    
    */

public class c1{
    Dictionary<string, int> data = new Dictionary<string, int>();
    
    public static void Main(string[] args){
        var pairs = 
            new string[][]{new string[]{"B", "A"}, new string[]{"C", "A"}, new string[]{"D", "B"}, new string[]{"E", "B"}, new string[]{"F", "C"}, new string[]{"G", "E"}, new string[]{"H", "B"}};  

        var names = new string[]{"A", "G", "B"} ;  // names needed for the report 
    
     (new c1()).
        report1(pairs, names);
                          
    }
        

    public  void report1(string[][] records, string[] names){
        Dictionary<string ,List<string>> adj = new Dictionary<string ,List<string>>(); 
        for(int i =0 ; i< records.Length; i++)
        {
            var dest = records[i][0];
            var source = records[i][1];
            
            // Console.WriteLine(source +" "+dest);
            
            if(!adj.ContainsKey(source)){
                adj.Add(source, new List<string>());
            }

            adj[source].Add(dest);
        }
        // Console.WriteLine("");

//         for(int i =0 ; i < names.Length; i++){
//             var name = names[i];
//             treeSize(adj, name);
//         } 
//         // Console.WriteLine("");

//         for(int i =0 ; i< names.Length; i++){
//             var name = names[i];
//             Console.WriteLine(name + " " + data[name]);
//         }
        for(int i =0 ; i< names.Length; i++){
            var name = names[i];
            Console.WriteLine(  name +" "+ treeSize(adj, name));
        }
    }

    public  int treeSize(Dictionary<string ,List<string>> adj, string name){

        if(data.ContainsKey(name))
            return data[name];
        if(!adj.ContainsKey(name)){
            data.Add(name, 0);
            return 0;
        }

        int counter = 0;
        List<string> childList = adj[name];
        // Console.WriteLine("");
        // Console.WriteLine(name+">>");

        // Console.WriteLine("");
        foreach(var n1 in childList){
            
            // Console.Write(n1+" ");
            int size = treeSize(adj, n1);
                counter += size + 1;
        }
        data[name] = counter;

        return counter;
    }
}










