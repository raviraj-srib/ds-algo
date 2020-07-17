package practice.array;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2};
		new RemoveDuplicate().removeDuplicates(array);

	}
	
	
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1, size = nums.length; i < size; i++){
            while (i < size && nums[j] == nums[i]){
               i= i +1 ;
            }
            j ++;
            nums[j] = nums[i];
            
        }
        return j;
    }

}
