 public class removeElementOfSortedArrayInPlace{
         public static void main(String[] args){
                 System.out.println("=== Start ====");
 int[] ary=new int[]{1,2,2,2,3,5,5,7,9,9};
 System.out.println("the length is :"+removeElementOfSortedArrayInPlace(ary,2));
         }

         // please be advised need to more *all* occurance in the array and return the *length* of new array
		 // for sorted array, there is nature of ary[i+1]>=ary[i]
		 // similarly, use two pointers, increase j only in case ary[i]<>ary[j]
         private static int removeElementOfSortedArrayInPlace(int[] ary, int value){
                 int j=0;
                 for(int i=0;i<ary.length-1;i++){
                         if(ary[i]==ary[i+1]){
                                 continue;
                         }
                         else{
                                 ary[j]=ary[i];
                                 ++j;
                         }
                 }
				 // to save the last elements
				 ary[j]=ary[ary.length-1];
				 System.out.println(" the new array is :"+java.util.Arrays.toString(ary));
				 return j+1;
         }
 }
