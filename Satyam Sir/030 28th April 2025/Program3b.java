// Same as Question 3 but using trie data structure


import java.util.*;

public class Program3b {
    static class Trie {
        static int NUM_CHARS = 26;
        static boolean isDeleted = false;
        static class TrieNode {
            TrieNode[] children = new TrieNode[NUM_CHARS];
            boolean isWord = false;
            int count = 0; 
            TrieNode() {
                for (int i = 0; i < NUM_CHARS; i++) {
                    children[i] = null;
                }
            }
        }
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new TrieNode();
                }
                currentNode = currentNode.children[index];
            }
            currentNode.isWord = true;
            currentNode.count++;
        }
        public void collectWords(TrieNode node, StringBuilder sb, List<WordFreq> list) {
            if (node == null)
                return;
            if (node.isWord) {
                list.add(new WordFreq(sb.toString(), node.count));
            }
            for (int i = 0; i < NUM_CHARS; i++) {
                if (node.children[i] != null) {
                    sb.append((char) ('a' + i));
                    collectWords(node.children[i], sb, list);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    static class WordFreq {
        String word;
        int freq;

        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    private static List<String> getKWords(String[] words, int k) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<WordFreq> list = new ArrayList<>();
        trie.collectWords(trie.root, new StringBuilder(), list);

        Collections.sort(list, new Comparator<WordFreq>() {
            public int compare(WordFreq a, WordFreq b) {
                if (b.freq != a.freq) {
                    return b.freq - a.freq;
                }
                return a.word.compareTo(b.word);
            }
        });

        List<String> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            res.add(list.get(i).word);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int k = sc.nextInt();
        System.out.println(getKWords(words, k));
    }
}