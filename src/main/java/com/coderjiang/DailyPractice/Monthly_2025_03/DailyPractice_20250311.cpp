#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int sumOfBeauties(const vector<int> &nums) {
        const int n = nums.size();
        vector<int> preMax(n), postMin(n);
        int temp = -1;
        for (int i = 0; i < n; ++i) {
            preMax[i] = temp = max(temp, nums[i]);
        }
        for (int i = n - 1; i >= 0; --i) {
            postMin[i] = temp = min(temp, nums[i]);
        }
        int res = 0;
        for (int i = 1; i <= n - 2; ++i) {
            if (preMax[i - 1] < nums[i] && nums[i] < postMin[i + 1]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res++;
            }
        }
        return res;
    }
};

int main() {
    return 0;
}
