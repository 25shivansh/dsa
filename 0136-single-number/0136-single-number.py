class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        xor =0
        n =len(nums)
        for i in range(n):
            xor^=nums[i]
        return xor 