// write a program to count the GrandChild/Child for given name 

// Assume the relations here limit only to child and grandChild only 

// All the inputs will be given in lower case characters(a-z) and are valid relations 

// The first line of input consists of number of relations followed by child name and fathers name 
// seperated by ',' 
// followed by a name. 

// Where the first string is "Child", second string is "Father".
// If the given name is Father print the count of his childrean
// If the given name is GrandFather print the count of his GrandChild

// Print -1 for any other boundary conditions 

// for given input like this

// input =
// 5
// kishore,ramesh
// dev,gopal
// gopal,ramu
// srinu,gopal
// praveen,ranjit
// ramu
// output = 2

// And given input "ramu" we have to find his no of grandchildren/child
// Here "ramu" has one direct child gopal and gopal has 2 children(dev,srinu).
// So ramu has 2 grand children dev,srinu. so output is 2

// example:2 

// input =
// 5
// ranjit,knr
// ramesh,pradeep
// kittu,ranjit
// yogesh,ranjit
// praveen,ranjit
// knr
// output=
// 3

// //given data for knr we need print the count of grand childern. 
// here knr direct child ranjit and ranjit has three children   ---- kittu,yogesh,praveen so print 3


// input = 
// 8
// a,b
// c,b
// d,b
// f,a
// g,a
// e,a
// m,c
// z,d
// b
// output =
// 5
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine()); // Number of relationships
        Map<String, List<String>> map = new HashMap<>();

        // Reading relationships and building map
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(",");
            String child = parts[0];
            String father = parts[1];
            map.computeIfAbsent(father, k -> new ArrayList<>()).add(child);
        }

        String name = sc.nextLine(); 

        if (!map.containsKey(name)) {
            System.out.println(-1);
            return;
        }

        List<String> children = map.get(name);
        int grandChildCount = 0;

        for (String child : children) {
            if (map.containsKey(child)) {
                grandChildCount += map.get(child).size();
            }
        }

        if (grandChildCount > 0) {
            System.out.println(grandChildCount); 
        } else {
            System.out.println(children.size()); 
        }
    }
}
