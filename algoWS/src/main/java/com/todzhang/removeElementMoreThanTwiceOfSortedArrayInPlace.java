 public class removeElementMoreThanTwiceOfSortedArrayInPlace{
         public static void main(String[] args){
                 System.out.println("=== Start ====");
 int[] ary=new int[]{1,2,2,2,3,5,5,7,9,9};
 System.out.println("the length is :"+removeElementMoreThanTwiceOfSortedArrayInPlace(ary,2));
         }

         // please be advised need to more *all* occurance in the array and return the *length* of new array
		 // for sorted array, there is nature of ary[i+1]>=ary[i]
		 // similarly, use two pointers, increase j only in case ary[i]<>ary[j]
		 // as there is additional limitation of at most twice, so need a counter for "2", 
		 // condition of this counter is: (1) increase if adjenct elements are same AND counter no larger than 2
		 // (2) reset when adjacent elemments are different
         private static int removeElementMoreThanTwiceOfSortedArrayInPlace(int[] ary, int value){
                 int j=0;
				 int counter=0;
                 for(int i=1;i<ary.length;i++){
                         if(ary[i]==ary[j] ){
							counter++;
							if(counter<2){
                                 ary[++j]=ary[i];
							}                                 
                         } else {
							ary[++j]=ary[i];
							counter=0;
						 }
					}
				 System.out.println(" the new array is :"+java.util.Arrays.toString(ary));
				 return j+1;
         }
		 
		 private static int removeElementMoreThanTwiceOfSortedArrayInPlaceMine_Wrong(int[] ary, int value){
                 int j=0;
				 int counter=0;
                 for(int i=0;i<ary.length-1;i++){
                         if(ary[i]!=ary[i+1] || counter>2){                         
                                 ary[j++]=ary[i];
                                 counter=0;
                         } else {
							++counter;
						 }
					}
                 
				 // to save the last elements
				 ary[j]=ary[ary.length-1];
				 System.out.println(" the new array is :"+java.util.Arrays.toString(ary));
				 return j+1;
         }
 }
