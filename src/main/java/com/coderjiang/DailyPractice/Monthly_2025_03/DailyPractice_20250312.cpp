#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static int countOfSubstrings(const string &word, const int k) {
        const int n = word.length();
        unordered_map<char, int> mp = {
            {'a', 0}, {'e', 1}, {'i', 2},
            {'o', 3}, {'u', 4},
        };
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 4; j < n; ++j) {
                bitset<5> bs;
                int count = 0;
                for (int p = i; p <= j; ++p) {
                    if (isVowelLetter(word[p])) bs.set(mp[word[p]]);
                    else count++;
                }
                if (bs.all() && count == k) res++;
            }
        }
        return res;
    }

    static bool isVowelLetter(const char &ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
};


int main() {
    return 0;
}
