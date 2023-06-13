package kh.lclass.swing;

import javax.swing.JFrame;

public class TestSwing extends JFrame{

	public TestSwing() {

		setTitle("Hello Window 프레임");
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		TestSwing frame = new TestSwing();
	}
}
