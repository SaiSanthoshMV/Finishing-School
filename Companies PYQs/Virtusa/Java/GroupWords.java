/*
2.REDUCE TILL ZERO



Dev loves the number zero. HE gives Andrew two integers X and Y and asks him to perform  the steps shown below 
on X and Y, till the value of Y has been reduced to zero. The undernoted steps needs to be followed sequentially:


-> if X<Y , then swap the values of X and Y.

-> if Y=0, then return X.

-> Otherwise, let T = X-Y.

-> Set X=Y and then set Y=T.

-> Repeat from step 1.

Your task is to help Andrew find and return an integer value representing the value of X, when the value of Y has
been reduced to zero.

NOTE : At least one of the integers X or Y will be an non-zero integer


input specification:
--------------------

input1: An integer value X , representing the first number.
input2: An integer value Y, representing the second number.


output specification:
--------------------

Return an integer value representing the value of X when the value of Y has been reduced to zero.


Example 1:
----------

input1: 3
input2: 7

output: 1


Explanation:
-------------

Here in this example, the initial values of X and Y are 3 and 7 , respectively the example is solved in 7 iterations
following steps 1 to 5 as:

-> Iteration 1 : X=3 and Y=7

1. Swap the values of X and Y , since the X<Y condition is true.

2. Now X=7 and Y=3,and since Y is not equal to 0, we do not return X.

3.T=X-Y=7-3=4,T=4

4.Set X=Y which makes X=3 and set Y=T which makes ,y=4

5. repeat step 1


The new values of X and Y after the first iteration are 3 and 4 respectively .We repeat the process till iteration 7.

 Iteration 7: X=0 and Y=1
 
 1. Swap the values of X and Y , since the X<Y condition is true.
 
 2. Now X=1  and Y=0, since Y is Equal to 0, we return X.
 
 
 Since the value of Y becomes 0 , we return the value of X as 1. Hence 1 is retuned as the output.
 
 
 
 
 Example 2:
 ----------
 
 input1: 0
 input2: 3
 
 
 output:3
 
 
 Explanation:
 ------------
 
 
 Here in this example, the initial values of X and Y are 0 and 3, respectively  this example is solved in 1 iteration 
 following Steps 1 and 2 as:
 
 Iteration 1: X=0 and Y=3
 
 1.swap the values of X and Y , since the X<Y condition is true
 
 2. Now X=3 and Y=0 , since Y is equal to 0 , we return X.
 
 
 since the value of Y becomes 0 ,we return the value o f X as 3. Hence 3 is returned as output.
 
 
*/
import java.util.*;

public class GroupWords {
    public static Map<Character, List<String>> groupWordsByFirstLetter(String[] words) {
        Map<Character, List<String>> map = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            char firstChar = word.charAt(0);
            map.putIfAbsent(firstChar, new ArrayList<>());
            map.get(firstChar).add(word);
        }

        return map;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "art", "banana", "bat", "cat", "car"};
        Map<Character, List<String>> grouped = groupWordsByFirstLetter(words);

        for (char key : grouped.keySet()) {
            System.out.println(key + " -> " + grouped.get(key));
        }
    }
}
