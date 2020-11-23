  static void Main()
    {
        Console.WriteLine("Hello, World!");
    }
    
    //55346b3c5f
    string decodeRLE(string input){
        int i = 0;
        string numStr;
        
        StringBuilder numSB = new StringBuilder ();  
        
        while(i < input.Length){
            int count = 0;
            while(isNum(input[i]))
            {
                count = count *10+ int.Parse(input[i++].ToString());
            }
            
            //i is a letter
            char c = input[i];
            while(count>0){
                numSB.Append(c);
                count--;
            }
        
            i++;
        }
        
        return numSB.ToString();
        
}
