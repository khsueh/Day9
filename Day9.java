   public class Day9
   {
   
      public static void main(String[] args)
      {
      int[] array =  {2, 4, 6, 2, 5};
      System.out.println(addUp(array));
      }
      public static int addUp(int nums[]) {
      if (nums.length == 0) { //If there are no numbers in nums
         return -1;
      }

      else if (nums.length == 1) { //If there is only one number in nums
         return nums[0];
      }

      int wayOne = helper(nums, 0, 0); //Calls twice because there are 2 possible starting indexes that are adj
      int wayTwo = helper(nums, 1, 0);


      if (wayOne > wayTwo) //Return the higher of the 2 recursion calls
         return wayOne;

      else 
         return wayTwo;
   }


   public static int helper(int nums[], int startingIndex, int previousSums) {

      int wayOne = previousSums + nums[startingIndex]; //2 possible paths the recursion can go
      int wayTwo = wayOne;


      if (nums.length - startingIndex - 1 >= 2) { // If there is a number 2 indexes ahead
         wayOne = helper(nums, startingIndex + 2, wayOne);
      }
      else if (nums.length - startingIndex - 1 >= 3) { // If there is a number 3 indexes ahead
         wayTwo = helper(nums, startingIndex + 3, wayTwo);
      }


      if (wayOne > wayTwo) //After recursion calls are over, compare the 2 numbers and then return the higher one
         return wayOne;

      else
         return wayTwo;

   }
   }
