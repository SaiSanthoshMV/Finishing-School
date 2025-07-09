#include<bits/stdc++.h>
using namespace std;
int gcd(int x, int y){
    if(x < y){
        swap(x,y);
    }
    if(y == 0)
        return x;
    return gcd(y,x-y);
}
int main(){
    int x;
    int y;
    cin >> x >> y;
    cout << gcd(x,y);
}