#Problem: Search Pattern (Rabin-Karp Algorithm)
#geeksforgeeks problem of the day -> 6th June 2025
#python code
class Solution:
    def rabinKarp(self, txt, pat):
        n = len(txt)
        m = len(pat)

        if m > n:
            return []

        d = 256
        q = 101

        h = 1
        for _ in range(m - 1):
            h = (h * d) % q

        p_hash = 0
        t_hash = 0

        for i in range(m):
            p_hash = (d * p_hash + ord(pat[i])) % q
            t_hash = (d * t_hash + ord(txt[i])) % q

        ans = []

        for i in range(n - m + 1):
            if p_hash == t_hash:
                if txt[i:i + m] == pat:
                    ans.append(i)

            if i < n - m:
                t_hash = (d * (t_hash - ord(txt[i]) * h) +
                          ord(txt[i + m])) % q

                if t_hash < 0:
                    t_hash += q

        return ans