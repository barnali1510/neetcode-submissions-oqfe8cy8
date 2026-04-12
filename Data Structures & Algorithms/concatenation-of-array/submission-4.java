class Solution {
    public int[] getConcatenation(int[] nums) {

        int size = nums.length;
        int[] result = new int[2*size];

        for(int i=0; i<nums.length; i++) {
            result[i] = nums[i];
        }

        for(int i=0; i<nums.length; i++) {
            result[size+i] = nums[i];
        }

        return result;
        
    }
}