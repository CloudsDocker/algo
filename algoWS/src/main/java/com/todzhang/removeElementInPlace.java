 public class removeElementInPlace{
         public static void main(String[] args){
                 System.out.println("=== Start ====");
 int[] ary=new int[]{2,7,2,1,3,5};
 System.out.println("the length is :"+removeElementsInPlace(ary,2));
         }

         // please be advised need to more *all* occurance in the array and return the *length* of new array
         private static int removeElementsInPlace(int[] ary, int value){
                 int j=0;
                 for(int i=0;i<ary.length;i++){
                         if(ary[i]==value){
                                 continue;
                         }
                         else{
                                 ary[j]=ary[i];
                                 ++j;
                         }
                 }
				 System.out.println(" the new array is :"+java.util.Arrays.toString(ary));
				 return j;
         }
 }
