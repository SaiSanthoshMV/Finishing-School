#include<bits/stdc++.h>
using namespace std;
int main(){
    string str;
    cin >> str;
    int len = str.length();
    int ans = 0;
    for(int i = 1; i < len-1; i++){
        if(isdigit(str[i-1]) && isalpha(str[i]) && isdigit(str[i+1])){
            ans++;
        }
    }
    cout << ans << endl;
}