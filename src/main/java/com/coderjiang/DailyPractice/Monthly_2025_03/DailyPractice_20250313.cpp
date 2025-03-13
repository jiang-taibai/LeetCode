#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static long long countOfSubstrings(const string &word, const int &k) {
        const int n = static_cast<int>(word.length());
        int l = 0, r = 0;
        unordered_map<char, int> mp;
        unordered_map<char, int> lastIndex;
        int firstIndex = -1;
        long long res = 0;
        while (r < n) {
            char chr = word[r];
            if (isVowel(chr)) {
                mp[chr]++;
                lastIndex[chr] = r;
            } else {
                mp['#']++;
                if (firstIndex == -1) firstIndex = r;
            }
            if (isValid(mp, k)) {
                // printf("Valid!\n");
                const int maxLeftIndex = minIndex(lastIndex, firstIndex);
                if (maxLeftIndex != -1) {
                    res += maxLeftIndex - l + 1;
                    // printf("l=%d, r=%d, maxLeftIndex=%d\n", l, r, maxLeftIndex);
                }
            } else {
                while (mp['#'] > k) {
                    char chl = word[l];
                    if (isVowel(chl)) {
                        if (lastIndex[chl] == l) lastIndex[chl] = -1;
                        mp[chl]--;
                    } else {
                        if (firstIndex == l) {
                            for (int i = l + 1; i < n; ++i) {
                                if (!isVowel(word[i])) {
                                    firstIndex = i;
                                    break;
                                }
                            }
                            if (firstIndex == l) firstIndex = -1;
                        }
                        mp['#']--;
                    }
                    ++l;
                }
                if (isValid(mp, k)) {
                    // printf("Valid!\n");
                    const int maxLeftIndex = minIndex(lastIndex, firstIndex);
                    if (maxLeftIndex != -1) {
                        res += maxLeftIndex - l + 1;
                        // printf("l=%d, r=%d, maxLeftIndex=%d\n", l, r, maxLeftIndex);
                    }
                }
            }
            // printf("l=%d, r=%d, firstIndex=%d, mp['#']=%d\n", l, r, firstIndex, mp['#']);
            ++r;
        }
        return res;
    }

    static bool isVowel(const char &ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    static bool isValid(unordered_map<char, int> &mp, const int &k) {
        return mp['a'] > 0 && mp['e'] > 0 && mp['i'] > 0 && mp['o'] > 0 && mp['u'] > 0 && mp['#'] == k;
    }

    static int minIndex(unordered_map<char, int> &lastIndexMap, const int &firstIndex) {
        int minIndex = INT_MAX;
        if (lastIndexMap.find('a') != lastIndexMap.end()) minIndex = min(minIndex, lastIndexMap['a']);
        if (lastIndexMap.find('e') != lastIndexMap.end()) minIndex = min(minIndex, lastIndexMap['e']);
        if (lastIndexMap.find('i') != lastIndexMap.end()) minIndex = min(minIndex, lastIndexMap['i']);
        if (lastIndexMap.find('o') != lastIndexMap.end()) minIndex = min(minIndex, lastIndexMap['o']);
        if (lastIndexMap.find('u') != lastIndexMap.end()) minIndex = min(minIndex, lastIndexMap['u']);
        if (firstIndex != -1) minIndex = min(minIndex, firstIndex);
        return minIndex == INT_MAX ? -1 : minIndex;
    }
};

int main() {
    const long long res = Solution::countOfSubstrings("ieaouqqieaouqq", 1);
    cout << res;
    return 0;
}

/*
ieaouqqieaouqq
可以被分为 ieaou q q ieaou q q
也就是说，滑动窗口，记录每一种元音的最后一个位置
那么每次窗口右边界向右移动，只要满足了两个条件，那么就计算当前窗口左边界到最后一个满足条件的左边界有多少个

 */
