// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {


        solution("A");        
        }

    
    public static String solution(String input) {
    	char[] chars = input.toCharArray();
        String[] bCode = {
                            "100000", //a
                            "110000", //b
                            "100100", //c
                            "100110", //d
                            "100010", //e
                            "110100", //f
                            "110110", //g
                            "110010", //h
                            "010100", //i
                            "010110", //j
                            "101000", //k
                            "111000", //l
                            "101100", //m
                            "101110", //n
                            "101010", //o
                            "111100", //p
                            "111110", //q
                            "111010", //r
                            "011100", //s
                            "011110", //t
                            "101001", //u
                            "111001", //v
                            "010111", //w
                            "101101", //x
                            "101111", //y
                            "101011", //z
        };
        StringBuilder sb  = new StringBuilder ();
        for(int i = 0; i< chars.length; i++){
            char c = chars[i];
            if(c == ' '){
                sb.append("000000");
                continue;
            }
            else if(c < 'a'){
                c = (char)((int)c + 32);
                sb.append("000001");    
            }
            sb.append(bCode[c - 'a']);
        }
        return sb.toString();
    }
}
