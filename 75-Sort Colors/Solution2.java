class Solution {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while(mid <= right) {
            if(nums[mid] == 0){
                int tmp = nums[left];
                nums[left++] = nums[mid];
                nums[mid++] = tmp;
            } 
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                int tmp = nums[mid];
                nums[mid] = nums[right];
                nums[right--] = tmp;
            }
        }

    }
}