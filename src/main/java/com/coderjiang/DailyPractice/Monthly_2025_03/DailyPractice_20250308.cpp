class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        int n = flowers.size();
        for(auto& x:flowers) x = min(x, target);
        sort(flowers.begin(), flowers.end(), greater<int>());
        long long sum = accumulate(flowers.begin(), flowers.end(), 0LL);
        long long pre = 0LL;
        int j = 0;
        long long ans = 0LL;
        if(static_cast<long long>(target) * n - sum <= newFlowers) ans = static_cast<long long>(full) * n;
        for(int i=0;i<n;++i) {
            if(i>0) pre+=flowers[i-1];
            if(flowers[i]==target) continue;
            long long rest = static_cast<long long>(newFlowers) - (static_cast<long long>(target) * i - pre);
            if(rest < 0) break;
            while(j < i || static_cast<long long>(flowers[j]) * (n - j) - sum > rest) {
                sum -= flowers[j];
                j++;
            }
            rest -= static_cast<long long>(flowers[j]) * (n - j) - sum;
            ans = max(ans,
                static_cast<long long>(full) * i + static_cast<long long>(partial) * min(flowers[j] + rest / (n - j),
                    static_cast<long long>(target) - 1));
        }
        return ans;
    }
};