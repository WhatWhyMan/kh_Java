package kh.lclass.io;

import kh.lclass.exception.UserException;

public class Main {
	public static void main(String[] args) {
//		new TestFileIO().testFileRead();
//		new TestFileIO().testFileRead2();
//		new TestFileIO().testRamda();
		new TestFileIO().testFileRead3();
		try {
			new TestFileIO().testRamda();
		} catch (UserException e) {
			e.printStackTrace();
		}
		System.out.println("==== Main ====");
	}

}
