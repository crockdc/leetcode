
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0;
        for i in nums:
            print("i ^ result in binary = " + bin(i) + " ^ " + bin(result))
            result = i ^ result
        print("binary result = " + bin(result))
        return result