import org.junit.*;

//import org.hamcrest.
public class arrayRemove {
    private int removeLargerElement(int[] input, int threshold) {
        // try to find elements larger than the threshold, and remove those elements in place

        int j=0;
        for (int i = 0; i < input.length; i++) {
                if(input[i]==threshold){
                    continue;
                }
                input[j]=input[i];
                j++;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println("test to remove elements > given value in place");
    }

    @org.junit.Test
    public void testRemoveLargerElement(){

        arrayRemove inst=new arrayRemove();
        Assert.assertEquals(inst.removeLargerElement(new int[]{1,2,3,5,2,2,7,9},2),5);

    }
}