class Solution(object):
    def shipWithinDays(self, weights, days):
        s, e = -1, 0
        for i in weights:
            s = max(s, i)
            e += i
        while s < e :
            mid = s + (e-s)//2
            need = 1
            curr = 0
            for i in weights:
                if curr + i > mid:
                    need += 1
                    curr = 0
                curr += i
            if need > days :
                s = mid + 1
            else :
                e = mid
        return s 