// In a research facility, N signal relay towers are installed in a straight line, each managed by one of three control centers 
// identified by IDs 1, 2, or 3. Their layout is described by an array towers[], where each element is a control center ID managing 
// that tower.

// A set of P signal drones must transmit messages to the nearest tower managed by a specific control center. 
// The instructions for each drone are given in instructions[], where instructions[i] = [pos, centerID]. 
// Each drone starts at position pos and needs to transmit to the nearest tower controlled by control center centerID.

// Your task is to calculate the minimum distance each drone must travel (either left or right) to reach a suitable tower.
// If no such tower exists for a given instruction, return -1.

// Input Format:
// --------------
// Line 1: Two space-separated integers N and P, the number of towers and drones.
// Line 2: N space-separated integers (1, 2, or 3) representing towers[].
// Next P lines: Each line contains two integers: drone's position pos and required control center centerID.

// Output Format:
// ---------------
// P space-separated integers, where each number represents the minimum distance the corresponding drone needs to travel.


// Sample Input-1:
// ---------------
// 6 2
// 1 1 2 2 3 3
// 1 3
// 2 2

// Sample Output-1:
// ----------------
// 3 0 

// Sample Input-2:
// ---------------
// 5 2
// 1 2 3 2 1
// 2 1
// 1 1

// Sample Output-2:
// ----------------
// 2 1

import java.util.*;

public class Program2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
    }
}