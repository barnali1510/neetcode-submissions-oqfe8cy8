class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int size = nums.length;
        ArrayList<Integer>[] bucket = new ArrayList[size+1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            int frequency = map.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int counter = 0;

        for(int i=bucket.length-1; i>=0 && counter<k; i--) {
            if(bucket[i] != null) {
                for(Integer j : bucket[i]) {
                    result[counter++] = j;
                }
            }
        }
        
        return result;
    }
}
