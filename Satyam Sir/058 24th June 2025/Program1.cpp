/*

// P-1 Type writer


Aruna as a type writer, typing a document in her laptop. Suddently her system got
hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.

//T3 (hi(bye)sa(how)ola)


*/
#include<bits/stdc++.h>
using namespace std;
void func(string &ans, int l, int r){
    while(l <= r){
        char temp = ans[l];
        ans[l] = ans[r];
        ans[r] = temp;
        l++;
        r--;
    }
}
int main(){
    string s;
    cin >> s;
    int alp = 0, open = 0;
    string ans = "";
    map<int,int> brac;
    for(int i = 0; i < s.length(); i++){
        if(s[i] != '(' && s[i] != ')'){
            ans += s[i];
            alp++;
        }
        else if(s[i] == '('){
            open++;
            brac[open] = alp;
        }
        else if(s[i] == ')'){
            func(ans,brac[open],alp-1);
            open--;
        }
        //cout << open << " " <<  alp << " " << ans << endl;
    }
    cout << ans << endl;
}
