#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int scoreOfString(const string &s) {
        int res = 0;
        for (int i = 0; i < s.size() - 1; ++i) {
            res += abs(s[i] - s[i+1]);
        }
        return res;
    }
};

int main() {
    return 0;
}
