import org.junit.*;

/**
 * Created by todzhang on 2017/1/8.
 */
public class RemoveDupItemFromSortedArray {

    public int removeDup(int[] ary){
        int j=0;
        for (int i = 1; i <ary.length ; i++) {
            if(ary[i]!=ary[j]){
                ary[++j]=ary[i];
            }
        }
        return j+1;
    }
}
