package me.todzhang;

public class EnumSingletonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(EnumSingleton.INSTANCE);
			
		}

	}

}
