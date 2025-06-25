// P-3 spiral order

#include<bits/stdc++.h>
using namespace std;
int main(){
    int m,n;
    cin >> m >> n;
    vector<vector<int>> grid(m, vector<int>(n));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> grid[i][j];
        }
    }
    vector<int> ans;
    int r1 = 0, r2 = m-1,c1 = 0, c2 = n-1;
    while(r1 <= r2 && c1 <= c2){
        for(int j = c1; j <= c2; j++){
            ans.push_back(grid[r1][j]);
        }
        r1++;
        if(r1 > r2 || c1 > c2)
            break;
        for(int i = r1; i <= r2; i++){
            ans.push_back(grid[i][c2]);
        }
        c2--;
        if(r1 > r2 || c1 > c2)
            break;
        for(int j = c2; j >= c1; j--){
            ans.push_back(grid[r2][j]);
        }
        r2--;
        if(r1 > r2 || c1 > c2)
            break;
        for(int i = r2; i >= r1; i--){
            ans.push_back(grid[i][c1]);
        }
        c1++;
    }
    cout << "[";
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i] ;
        if(i != ans.size()-1)
            cout << ", ";
    }
    cout << "]" << endl; 
}

