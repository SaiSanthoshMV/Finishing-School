/*


// P-2 Typing Test


Ralph is learning how to type fast and use some of the shortcuts provided by the keyword such as
undoing a previous operation.copy-pasting and cut-pasting.Now,he has completed the course and 
is appearing for his final exam.In the exam he is given some operations to perform over a string.

He is given two strings one he has to type and the other string is the operations that he has to 
perform. The three major operations that he needs to perform are:

1.If the operation is w, he has to type in the next charater in the operation string until the 
  next operation is encountered.
2.If the operation is d, he has to delete 'N' characters which he last typed
3.If the operation is u, he has to undo the last operation he performed.

you have to find the final string which was typed by Ralph


Input specification:
--------------------
input1:The initial string Ralph had to type
input2:The operation string
input3:'N',used in operation 2


Output Specification:
---------------------
Return the final string Ralph typed.

Example 1:
----------

input1: aa
input2: wabsbdwasbajsud
input3: 1


Output: aaab


Explanation:
------------
First,Ralph typed aa as the initial string,then as the operation was w,he typed the characters 
which appeared in the operation string, until he was given the next operation so he typed aaabsb.

Next he had to delete 1 character, so he deleted 'b' to get aaabs.

for the next operation again he had to type characters and so he wrote:
aaabsasbajs


Next, he had to perform undo,which meant he got aaabs and finally he deleted 1 character to get 
aaab.


Example 2:
----------
input1: bbhfg
input2: wbsydwtreaxcbuwsasxasd
input3: 3

Output: bbhfgsas

*/