#include<bits/stdc++.h>
using namespace std;
int pairs(vector<int> &nums, int n){
    set<int> st;
    for(auto x: nums){
        st.insert(x);
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(st.count(i*j)){
                ans++;
            }
        }
    }
    return ans;
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    int maxi = INT_MIN;
    for(int i = 0; i < n; i++){
        cin >> nums[i];
        maxi = max(maxi,nums[i]);
    }
    cout << pairs(nums,maxi) << endl;
}