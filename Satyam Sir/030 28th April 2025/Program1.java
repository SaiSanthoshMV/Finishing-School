// Barnaby loved finding hidden words in his big storybook. He had a special list of his favorite words.
// For each favorite word he found in the story, he would write down where it began and where it ended.
// Can you help Barnaby find all his favorite words and their starting and ending spots in the storybook?

// Example 1:
// ----------
// input= 
// thestoryofleetcodeandme
// story fleet leetcode

// Output=
// 3 7
// 9 13 
// 10 17

// Example 2:
// ----------
// input= 
// ababa
// aba ab
// output=
// 0 1 
// 0 2 
// 2 3
// 2 4

// Explanation: 
// Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].

// Note: Input formate is string and followed by substring ,
//       Output print starting and ending index pairs.
import java.util.*;

class Trie {
    static final int NUM_CHARS = 26;
    static boolean isDeleted = false;

    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean flag;

        TrieNode() {
            flag = false;
            for (int i = 0; i < NUM_CHARS; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root=new TrieNode();

    static void insert(String key) {
        int length = key.length();
        TrieNode currentNode = root;
        for (int level = 0; level < length; level++) {
            int index = key.charAt(level) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.flag = true;
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String story = sc.nextLine();
        String[] favoriteWords = sc.nextLine().split(" ");
        for (String word : favoriteWords) {
            Trie.insert(word);
        }

        int storyLen = story.length();
        for (int i = 0; i < storyLen; i++) {
            Trie.TrieNode currentNode = Trie.root;
            for (int j = i; j < storyLen; j++) {
                int index = story.charAt(j) - 'a';
                if (currentNode.children[index] == null)
                    break;
                currentNode = currentNode.children[index];
                if (currentNode.flag)
                    System.out.println(i + " " + j);
            }
        }
    }
}