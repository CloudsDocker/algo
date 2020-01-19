import java.util.ArrayList;
import java.util.Iterator;

public class StringPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("--- start ---");
        System.out.println("-1st approach---result--:");
        permutation("abcd");
        System.out.println("-2nd approach--better performance-result--:");
        permute2("abcd");
        
        System.out.println("-3rd approach---result--:");
        ArrayList<String> list=new ArrayList<String>();
        list=permutation3("abcd");
        System.out.println(list.toString());
    }
    
    private static void permutation(String str){
        permutation("",str);
    }
    
    private static void permutation(String prefix,String str){
        int n=str.length();
        if(n==0){
            System.out.println(prefix);
        }
        else{
            for(int i=0;i<n;i++){
                permutation(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,n));
            }
        }
    }
    
    // ---- second approach----
    // the wrapper method of permute
    private static void permute2(String str){
        int len=str.length();
        boolean[] used=new boolean[len];
        StringBuilder out=new StringBuilder();
        char[] in=str.toCharArray();
        doPermute(in, out, used, len, 0);
    }
    
    private static void doPermute(char[] in, StringBuilder out, boolean[] used, int length, int level){
        if(level==length){
            // print out one combination
            System.out.println(out.toString());
            return;
        }
        
        for(int i=0;i<length;i++){
            if(used[i]){
                // for used place, skip to increase performacne
                continue;
            }
            
            out.append(in[i]);
            used[i]=true; // mark this char used
            doPermute(in, out, used, length, level+1); // recusive call, by increaseing level
            used[i]=false; // reset this char to unused
            out.setLength(out.length()-1); // remove the last char
        }
    }
    
    
    // third solution:
    private static ArrayList<String> permutation3(String str){
        // the result
        ArrayList<String> res=new ArrayList<>();
        // if input string's length is 1, return s
        if(str.length()==1){
            res.add(str);
        }
        else if(str.length()>1){
            int lastIdx=str.length()-1;
            // find the last character
            String last=str.substring(lastIdx);
            String rest=str.substring(0,lastIdx);
            
            // perform permutation on the rest string 
            // and merge with the last char
            res=merge(permutation3(rest), last);
        }
        return res;
    }
    
    public static ArrayList<String> merge(ArrayList<String> list, String c){
        ArrayList<String> res=new ArrayList<String>();
        // loop through all the string in list
        for (String string : list) {
            // for each string, insert the last character to all possible positions
            // and add them to the new list
            for(int i=0;i<=string.length();++i){
                String ps=new StringBuffer(string).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }
    
    

}