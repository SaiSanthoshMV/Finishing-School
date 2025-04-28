// Sridhar brought his latest Apple iPhone 15 pro. He started his conversation 
// with one of his friend on WhatsApp with list of words.

// now it's our task to find and return what are most common words
// in the list of words he used in sorted order based on occurrence from 
// largest to smallest. If any of words he used are having same occurrence 
// then consider the lexicographic order.

// You will be given a list of words, you need to print top P number of 
// most common used words as described in the statement. 

// Input Format:
// -------------
// Line-1: comma separated line of words, list of words.
// Line-2: An integer P, number of words to display. 

// Output Format:
// --------------
// Print P number of most common used words.


// Sample Input-1:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
// 3

// Sample Output-1:
// ----------------
// [are, case, egg]



// Sample Input-2:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
// 3

// Sample Output-2:
// ----------------
// [are, egg, case]

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int k = sc.nextInt();
        System.out.println(getKWords(str, k));
    }

    private static List<String> getKWords(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (String st : words) {
            mp.put(st, mp.getOrDefault(st, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (b.getValue().equals(a.getValue())) {
                        return a.getKey().compareTo(b.getKey()); 
                    }
                    return b.getValue() - a.getValue();
                });

        pq.addAll(mp.entrySet());
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}
