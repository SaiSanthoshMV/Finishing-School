//Same problem as of Program1 ,except the implementation is using tries
import java.util.*;
public class Program1b {
    static int NUM_CHARS = 26;
    static boolean isDeleted = false;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[NUM_CHARS];
    }
}
