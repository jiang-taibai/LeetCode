#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static vector<int> maximumBeauty(vector<vector<int> > &items, vector<int> &queries) {
        map<int, int> mp;
        for (auto &item: items) mp[item[0]] = max(mp[item[0]], item[1]);
        int maxBeauty = 0;
        for (auto &p: mp) {
            maxBeauty = max(maxBeauty, p.second);
            p.second = maxBeauty;
        }
        vector<int> res;
        for (auto &price: queries) {
            auto it = mp.lower_bound(price);
            if (it == mp.end() || it->first > price) {
                if (it == mp.begin()) {
                    res.push_back(0);
                } else {
                    --it;
                    res.push_back(it->second);
                }
            } else {
                res.push_back(it->second);
            }
        }
        return res;
    }
};

int main() {
    Solution solution;
    return 0;
}
