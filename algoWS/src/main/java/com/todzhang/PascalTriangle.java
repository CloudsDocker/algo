import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by todzhang on 2017/1/12.
 */
public class PascalTriangle {
    public static int[][] genPascalTriangle(int n){
        int[][] rtn=new int[n][n];
        rtn[0][n/2+1]=1;
        for (int i = 1; i < n; i++) {
           rtn[i][0]=1;
            rtn[i][n-1]=1;
            for (int j = 1; j < n-1; j++) {
                rtn[i][j]=rtn[i-1][j-1]+rtn[i-1][j];
            }
        }
        return rtn;
    }

    public static List<List<Integer>> getPascalTrigleList(int n){
        List<List<Integer>> list=new ArrayList<List<Integer>>();

        // init row of arraylist
        List<Integer> row=new ArrayList<Integer>();
//        list.add(Arrays.asList(new int[]{1}));
        for (int i = 0; i < n; i++) {
//            row=new ArrayList<Integer>();
            // insert "1" at the begining of the row
            // secondly, add a new element of the row,  following line
            // use this row.size() represent of the row
            row.add(0,1);
//            if(i>0) {
//                row.add(i, 1);
            // start from 1, to the row.size()
                for (int j = 1; j < row.size()-1; j++) {
                   row.set(j,row.get(j)+row.get(j+1));
//                    row.set(j,(list.get(i-1).get(j-1)+list.get(i-1).get(j)));
                }

            // init a List by passing corrent modified Row element
            // add the new created List to whole rows
            list.add(new ArrayList<Integer>(row));
//            }
//            list.add(row);
        }
        return list;

    }
}
