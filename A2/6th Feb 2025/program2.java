// Mr.Bob and Mr.Cob are working on a Military Mission. 
// They are supposed to encode the message and send the message to the under-cover team.

// Where Cob has written a script. Where the Script says double all the ascii values other than mentioned in the bracket
// (97,101,105,111,117,65,69,73,79,85) and place a '#' in between. 

// Help Bob in writing the Code. 


// Sample Test Case-1
// input = attack the enemy
// output = at#tt#tac#ck#k t#th#he en#nem#my#y

import java.util.Scanner;

public class program2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' ')
                System.out.print(" ");
            else if(!((int)ch==97 || (int)ch==101 ||(int)ch==105 || (int)ch==111|| (int)ch==117 || (int)ch==65 || (int)ch==69 || (int)ch==73 || (int)ch==79 || (int)ch==85)){
                System.out.print(ch+"#"+ch);
            }
            else {
                System.out.print(ch);
            }
            sc.close();
        }
    }
}