#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    int sum = 0,ans;
    for(int i = 0; i < n; i++){
        cin >> nums[i];
        sum += nums[i];
    }
    if(n == 1) 
        ans = sum;
    else 
        ans = max(sum-nums[0], sum - nums.back());
    cout << ans << endl;
}