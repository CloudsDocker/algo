/**
 * Created by todzhang on 2017/1/8.
 */
public class RemoveDupItemFromSortedArrayLargerThan2 {

//   public int removeDupItemsForTwoOccurance(int[] ary){
//       int j=0;
//
//       int k=0;
//       for (int i = 1; i < ary.length; i++) {
//           if(ary[i]!=ary[j]){
//              ++k;
//           }
//           if(k>2){
//               ary[++j]=ary[i];
//               k=0;
//           }
//       }
//       return j+1;
//   }

    public int removeDupItemsForTwoOccurance(int[] ary) {
        int j = 0;

        int k = 0;

        for (int i = 1; i <ary.length; i++) {
            // if there is repeat, increase k
            if(ary[i]==ary[j]){
                k++;
                if(k<2){
                    // if k less than 2 (max allow recurance is 2)
                    // move cursor j and replace the value
                    ary[++j]=ary[i];
                }
            }
            else{
                // if the fast and slower cursor are different
                // move j forward and replace value
                ary[++j]=ary[i];
                // reset k
                k=0;
            }
        }
        return j+1;
    }
}
