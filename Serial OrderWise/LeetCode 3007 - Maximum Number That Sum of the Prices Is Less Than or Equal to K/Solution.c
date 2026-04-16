long long count(long long k, int rigthmost, int x)
{
        if (k < rigthmost)
                return 0;
        long long n = 1, bits = rigthmost, p = 1;
        while (2 * bits + (p % x == 0 ? n : 0) <= k)
        {
                bits = 2 * bits + (p % x == 0 ? n : 0);
                n *= 2;
                ++p;
        }
        return n + count(k - bits, rigthmost + (p % x == 0), x);
}
long long findMaximumNumber(long long k, int x)
{
        return count(k, 0, x) - 1;
}