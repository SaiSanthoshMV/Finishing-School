import java.util.*;

public class program3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String sb=sc.next();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(!(sb.charAt(i)=='A' || sb.charAt(i)=='E' || sb.charAt(i)=='I'|| sb.charAt(i)=='O' ||sb.charAt(i)=='U' || sb.charAt(i)=='a' || sb.charAt(i)=='e' || sb.charAt(i)=='i' || sb.charAt(i)=='o' || sb.charAt(i)=='u'))
                str.append('C');
            else str.append('V');
        }
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                str.deleteCharAt(i--);
            }
        }
        System.out.println(str.toString());
          sc.close();
    }
}
