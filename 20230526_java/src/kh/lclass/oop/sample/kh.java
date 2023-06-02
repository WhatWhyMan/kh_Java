package kh.lclass.oop.sample;

import java.awt.AWTEvent;
import java.awt.Rectangle;
import java.awt.im.spi.InputMethodContext;
import java.io.Serializable;
import java.lang.Character.Subset;
import java.util.Locale;
import java.util.Set;

@SuppressWarnings("serial")
public class kh implements TestInterface, Serializable {
	// - The serializable class kh does not declare a static final serialVersionUID
	// field of type long
	static final long serrialVersionUID = 1L;

	public void khSpecial() {
		String str = "1111122222222";
		try {
			System.out.println("1");
			Car[] carArr = new Car[3];
//			carArr[0] = new Car();
			carArr[4].setPrice(5000); // ArrayIndexOutOfBoundsException
			System.out.println("2");
			carArr[0].setPrice(5000); // NullPointerException

			int a = Integer.parseInt(str); // NumberFormatException

			int c = 10 / 0; // ArithmeticException
			c = 0 / 10;
		} catch (NumberFormatException e) {
			System.out.println(Integer.MAX_VALUE + "까지의 정수만 입력해주세요");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눈 수는 나타낼 수 없습니다.");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("예기치 못한 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("데이터 범위를 벗어났습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("0으로 나눈 수는 나타낼 수 없습니다.");
			e.printStackTrace();
		} 

		System.out.println("여기가 마지막");
	}

	@Override
	public void method1() {

	}

	@Override
	public String method2() {
		return null;
	}

	@Override
	public int method3(int a, int b) {
		return 0;
	}

	@Override
	public void setInputMethodContext(InputMethodContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setLocale(Locale locale) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCharacterSubsets(Subset[] subsets) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCompositionEnabled(boolean enable) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCompositionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reconvert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispatchEvent(AWTEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyClientWindowChange(Rectangle bounds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate(boolean isTemporary) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideWindows() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNotify() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endComposition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getControlObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
