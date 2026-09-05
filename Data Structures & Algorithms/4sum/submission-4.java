class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        HashSet<List<Integer>> result = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    for(int l=k+1; l<n; l++) {
                        if((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp  = new ArrayList<>();

                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);

                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;
        
    }
}