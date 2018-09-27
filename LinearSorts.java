
package linearsorts;
import java.util.Random;
/**
 *
 * @author Paul Bosonetto
 * CSCI 333 
 * HW4 RAMSort&Select
 * 2018.09.27
 */
public class LinearSorts {
    
    
    /**
     * Finds the ith smallest value
     * @param nums int array on which to operate
     * @param p int starting index
     * @param r int ending index
     * @param i ith order statistic
     * @return int representing the ith order statistic
     */
    private int randomizedQuickselect(int[] nums, int p, int r, int i){
        
        int[] copy = java.util.Arrays.copyOf(nums, nums.length);
        
        //base case
        if (p == r)
            return copy[p];
        
        //get a random pivot
        Random rand = new Random();
        int random = rand.nextInt(r-p) + p;
        
        //swap copy[random] with copy[r]
        int temp = copy[random];
        copy[random] = copy[r];
        copy[r] = temp;
        
        
        int pivot = partition(copy, p, r);
        int k = pivot - p + 1; //calculate the order statistic k of the pivot
        if (i == k)
            return copy[pivot];
        else if (i < k)
            return randomizedQuickselect(copy, p, pivot-1, i);
        else 
            return randomizedQuickselect(copy, pivot+1, r, i-k);
        
        
    }
    
    /**
     * Method that partitions an int array based on the start and end parameters
     * @param A int array to be sorted
     * @param start starting index
     * @param end ending index
     * @return return the pivot index
     */
    private int partition(int[] A, int start, int end) {
        
        int x = A[end];
        int i = start-1;
        
        for (int j = start; j < end; j++){
            
            if (A[j] <= x){ //swap A[i] with A[j]
                i = i + 1;
                
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        //swap A[i+1] with A[end]
        int temp1 = A[i+1];
        A[i+1] = A[end];
        A[end] = temp1;
        
        return i + 1;
        
    }
    
    
    
    /**
     * This method implements counting sort with 0-indexed arrays
     * @param nums int array to be sorted
     * @param sorted int array with sorted output
     * @param k int max value
     */
    private int[] countingSort(int[] nums, int[] sorted,int k ){
        
        int[] counts = new int[k+1];
        
        for (int i = 0; i <= k; i++)
            counts[i] = 0;
        
        //increment counter array if value j is seen
        //counts[i] will contain the number of elements equal to i
        //after this loop
        for (int j = 0; j < nums.length;j++)
            counts[nums[j]] = counts[nums[j]]+1;
        
        //counts[i] will now contain the number of elements <= i
        for (int i = 1; i <= k; i++){
            counts[i] = counts[i] + counts[i-1];
        }
        
        for (int j = nums.length-1; j >= 0; j--){
            sorted[counts[nums[j]]-1] = nums[j];
            counts[nums[j]] = counts[nums[j]] - 1;
        }
        
        return sorted;
    }
    
    /**
     * Simple method to nicely print an array
     * @param nums int array to be printed 
     */
    private void printArray(int[] nums){
        for (int i: nums){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    
    /**
     * Method to find the largest value in an array
     * @param nums int array you wish to find the max of
     * @return max largest int in the array nums
     */
    private int findMax(int[] nums){
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }
    
    
    /**
     * This main method runs 5 test cases on each of the sorts implemented above
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        
        
        int[] nums1 = {2,14,16,24,10};
        int[] nums11 = new int[nums1.length];
        int[] nums2 = {1,5,4,7,8,34,16,9,2};
        int[] nums22 = new int[nums2.length];
        int[] nums3 = {32, 25, 16, 98, 28, 87, 36, 5, 58, 21, 40, 71, 55, 21, 4, 52, 32, 51, 4, 44};
        int[] nums33 = new int[nums3.length];
        int[] nums4 = {27, 5, 21, 51, 64, 88, 5, 77, 67, 87, 81, 17, 95, 88, 46, 32, 63, 76, 18, 83};
        int[] nums44 = new int[nums4.length];
        int[] nums5 = {49, 52, 34, 47, 62, 71, 12, 6, 63, 87, 85, 94, 69, 55, 39, 46, 3, 70, 57, 65,
            67, 58, 84, 43, 21, 50, 93, 74, 96, 43, 20, 50, 7, 25, 77, 73, 12, 28, 9, 58, 30, 16, 23,
            48, 72, 22, 63, 73, 60, 99, 60, 80, 69, 58, 43, 16, 46, 37, 81, 5, 59, 61, 84, 14, 84, 19,
            98, 3, 45, 46, 25, 77, 50, 14, 29, 50, 54, 53, 1, 59};
        int[] nums55 = new int[nums5.length];
        
        LinearSorts ls = new LinearSorts();
        
        ls.printArray(nums2);
        ls.printArray(ls.countingSort(nums2, nums22, ls.findMax(nums2)));
        System.out.println("-----------------------------------------");
        
        ls.printArray(nums1);
        ls.printArray(ls.countingSort(nums1, nums11, ls.findMax(nums1)));
        System.out.println("-----------------------------------------");
  
        ls.printArray(nums3);
        ls.printArray(ls.countingSort(nums3, nums33, ls.findMax(nums3)));
        System.out.println("-----------------------------------------");
 
        ls.printArray(nums4);
        ls.printArray(ls.countingSort(nums4, nums44, ls.findMax(nums4)));
        System.out.println("-----------------------------------------");
        
        ls.printArray(nums5);
        ls.printArray(ls.countingSort(nums5, nums55, ls.findMax(nums5)));
        System.out.println("-----------------------------------------");
        
        System.out.print("The 8th order of nums3 is ");
        System.out.println(ls.randomizedQuickselect(nums3, 0, nums3.length-1, 8));
        System.out.print("The 4th order of nums3 is ");
        System.out.println(ls.randomizedQuickselect(nums3, 0, nums3.length-1, 4));
        System.out.print("The 1th order of nums3 is ");
        System.out.println(ls.randomizedQuickselect(nums3, 0, nums3.length-1, 1));
        System.out.print("The 1th order of nums1 is ");
        System.out.println(ls.randomizedQuickselect(nums1, 0, nums1.length-1, 1));
        System.out.print("The 5th order of nums1 is ");
        System.out.println(ls.randomizedQuickselect(nums1, 0, nums1.length-1, 5));
        System.out.print("The 2nd order of nums2 is ");
        System.out.println(ls.randomizedQuickselect(nums2, 0, nums2.length-1, 2));
        
    }
    
}