from __future__ import annotations
def minimalKSum( nums: list[int], k: int) -> int:
        nums = sorted(list(set(nums)))
        n = len(nums)
        
        if nums[n - 1] <= k + n:
            return (k + n) * (k + n + 1) // 2 - sum(nums)

        lft, rgt = 0, n - 1
        while rgt > lft:
            mid = (lft + rgt) // 2
            if nums[mid] - mid <= k:
                lft = mid + 1
            else:
                rgt = mid

        return (k + lft) * (k + lft + 1) // 2 - sum(nums[:lft])

nums = [2,4,7,10,11,13]
k = 5

print(minimalKSum(nums,k))
