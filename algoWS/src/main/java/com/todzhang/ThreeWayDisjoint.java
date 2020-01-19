public class ThreeWayDisjoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean disjoint1(int[]  groupA, int[] groupB, int[] groupC){
		for ( int i : groupA) {
			for (int j : groupB) {
				for (int k : groupC) {
					if(i==j && j==k){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static boolean disjoint2(int[]  groupA, int[] groupB, int[] groupC){
		for ( int i : groupA) {
			for (int j : groupB) {
				if(i==j){
					// add this checking to reduce complexitiy
					for (int k : groupC) {
						if(j==k){
							return false;
						}
					}
				}
				
			}
		}
		return true;
	}
}
