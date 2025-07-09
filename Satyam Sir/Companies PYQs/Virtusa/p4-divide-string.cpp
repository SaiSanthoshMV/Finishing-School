#include<bits/stdc++.h>
using namespace std;
int main(){
    string str;
    cin >> str;
    map<char,int> mpp;
    for(auto x: str){
        mpp[x]++;
    }
    int ans = INT_MAX;
    for(auto x: mpp){
        if(x.second <ans){
            ans = x.second;
        }
    }
    cout << ans << endl;
}