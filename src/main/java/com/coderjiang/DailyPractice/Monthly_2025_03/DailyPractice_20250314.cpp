#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static bool isBalanced(const string &num) {
        int sum = 0;
        for (int i = 0; i < num.size(); ++i) {
            if (i & 1) sum += num[i] - '0';
            else sum -= num[i] - '0';
        }
        return sum == 0;
    }
};

int main() {
    return 0;
}
