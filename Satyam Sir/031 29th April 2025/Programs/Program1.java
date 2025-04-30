// /*
//  * Write a Java Code using Suffix Trie to Count the Distinct Substrings for the
//  * given input string
//  * 
//  * input = hello
//  * output = 14
//  * 
//  * Distinct Substrings for the word hello
//  * 
//  * "h", "he", "hel", "hell", "hello",
//  * "e", "el", "ell", "ello",
//  * "l", "ll", "llo",
//  * "lo", "o"
//  * 
//  */

package Programs;
import java.util.*;
 
public class Program1 {
    static class SuffixTrieNode {
        static final int MAX_CHAR = 26;
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

        SuffixTrieNode() {
            for (int i = 0; i < MAX_CHAR; i++) {
                children[i] = null;
            }
        }

        void insertSuffix(String word) {
            if (word.length() > 0) {
                char index = (char) (word.charAt(0) - 'a');
                if (children[index] == null) {
                    children[index] = new SuffixTrieNode();
                }
                children[index].insertSuffix(word.substring(1));
            }
        }
    }

    static class SuffixTrie {
        static final int MAX_CHAR = 26;
        SuffixTrieNode root;

        SuffixTrie(String str) {
            root = new SuffixTrieNode();
            for (int i = 0; i < str.length(); i++) {
                root.insertSuffix(str.substring(i));
            }
        }

        int countNodesInTrie(SuffixTrieNode node) {
            if (node == null)
                return 0;
            int cnt = 0;
            for (int i = 0; i < MAX_CHAR; i++) {
                if (node.children[i] != null) {
                    cnt += countNodesInTrie(node.children[i]);
                }
            }
            return cnt + 1;
        }

        int countNodesInTrie() {
            return countNodesInTrie(root);
        }
    }
        
    // static int countDistSub(String str) {
        SuffixTrie sTrie = new SuffixTrie(str);
        return sTrie.countNodesInTrie();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(countDistSub(str)-1);
    }    
}