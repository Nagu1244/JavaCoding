package datastructure;

public class PivotalIndex {
    public static int index(int[] nums){
      int totalSum = 0;
      for(int i=0;i<nums.length;i++){
          totalSum = totalSum + nums[i];
      }
      int leftSum = 0;
      int rightSum = totalSum;
      for(int i=0;i<nums.length;i++){
          leftSum = leftSum + nums[i];
          if(leftSum == rightSum){
              return i;
          }
          rightSum = rightSum - nums[i];
      }
        return -1;
    }
    public static void main(String args[]){
        int[] nums =  {1,7,3,6,5,6};
        //Pivotal index = the lest and right sum becomes equal from the pivotal index
        /** Let's consider in this case: 6 is pivotal index b'z left and right sum both are equal.
         * pivotal index = sum of left + sum of right*/ //return the index of pivotal index
        int pivotalIndex = PivotalIndex.index(nums);
        System.out.println(pivotalIndex);
    }
}
