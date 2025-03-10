#include <bits/stdc++.h>
using namespace std;

typedef long long LL;

class Solution {
public:
    static int divisorSubstrings(const int num, const int k) {
        const auto s = to_string(num);
        LL subNum = 0;
        const LL mul = static_cast<LL>(pow(10, k));
        int count = 0;
        for (int i = 0; i < s.size(); ++i) {
            subNum = subNum * 10 + s[i] - '0';
            if (i >= k) {
                subNum -= (s[i - k] - '0') * mul;
            }
            if (i >= k - 1) {
                if (subNum != 0 && num % subNum == 0) ++count;
            }
        }
        return count;
    }
};

int main() {
    return 0;
}
