// Venkatadri is a maths teacher.
// He is teaching matrices to his students.
// He is given a matrix of size m*n, and it contains only positive numbers.
// He has given a task to his students to find the special matrix, 
// in the given matrix A[m][n].
// A special matrix has following property:
// 	- The sum of elements in each row, each column and the two diagonals are equal.
// 	- Every 1*1 matrix is called as a special matrix.
// 	- The size of the special matrix should be a square, i.e., P*P.

// Your task is to help the students to find the speical matrix  with max size P.


// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the matrix.
// Next M lines: N space separated integers m and n.

// Output Format:
// --------------
// Print an integer, maximum size P of the special matrix.


// Sample Input-1:
// ---------------
// 5 5
// 7 8 3 5 6
// 3 5 1 6 7
// 3 5 4 3 1
// 6 2 7 3 2
// 5 4 7 6 2

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// The special square is:
// 5 1 6
// 5 4 3
// 2 7 3


// Sample Input-2:
// ---------------
// 4 4
// 7 8 3 5
// 3 2 1 6
// 3 2 3 3
// 6 2 3 3

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// The special square is:
// 3 3
// 3 3


import java.util.*;

public class Program1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        for(int size=Math.min(m,n);size>=1;size--){
            if(isSpecialMat(matrix,m,n,size)){
                System.out.println(size);
                return;
            }
        }
    }
    private static boolean isSpecialMat(int[][] matrix,int m,int n,int size){
        for(int i=0;i<=m-size;i++){
            for(int j=0;j<=n-size;j++){
                if(sumOfMatrix(matrix,i,j,size)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean sumOfMatrix(int[][] matrix,int row,int col,int size){
        int tarSum=0;
        for(int i=0;i<size;i++){
            tarSum+=matrix[row][col+i];
        }
        for(int i=0;i<size;i++){
            int rowSum=0;
            for(int j=0;j<size;j++){
                rowSum+=matrix[row+i][col+j];
            }
            if(rowSum!=tarSum)
                return false;
        }
        for(int i=0;i<size;i++){
            int colSum=0;
            for(int j=0;j<size;j++){
                colSum+=matrix[row+j][col+i];
            }
            if(colSum!=tarSum)
                return false;
        }
        int diagSum1=0,diagSum2=0;
        for(int i=0;i<size;i++){
            diagSum1+=matrix[row+i][col+i];
        }
        if(diagSum1!=tarSum)
            return false;
        for(int i=0;i<size;i++){
            diagSum2+=matrix[row+i][size+col-i-1];
        }
        if(diagSum2!=tarSum)
            return false;
        return true;
    }
}