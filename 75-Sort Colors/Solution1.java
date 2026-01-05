class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> countFreq = new HashMap<>();  //<Color code, Frequency> 
        countFreq.put(0, 0); 
        countFreq.put(1, 0);
        countFreq.put(2, 0);

        for(int num : nums){
            countFreq.put(num, countFreq.get(num) + 1);
        }

        int index = 0;;
        for(int i = 0; i <= 2; i++){
            int freq = countFreq.get(i);
            for(int j = 0; j < freq; j++){
                nums[index] = i;
                index++;
            }
        }
    }
}