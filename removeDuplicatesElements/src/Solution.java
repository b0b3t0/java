public class Solution {

    /**
     * Removing  all instances of that value in place.
     * @param nums input array
     * @param val search value to remove
     * @return the count of elements that are not equal to value
     */
    public static int removeDuplicatesElements(int[] nums, int val) {
        int count = 0;

        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3 , 3, 2};
        System.out.println(removeDuplicatesElements(nums, 3));
    }
}
