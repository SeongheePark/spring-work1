package ch01;

/*
 * 1. 인터페이스가 필요하다
 * 2. 인터페이스를 컴포지션 관계(포함)로 선언한다.
 * 3. setter(인터페이스를 구현한 클래스를 받을) 메서드를 만들어준다.
 * 
 * */

public class Button {
	private String name;
	private IButtonListener iButtonListener;

	public Button(String name) {
		this.name = name;
	}

	// setter 만들어서 주입 시킨다
	public void setiButtonListener(IButtonListener iButtonListener) {
		this.iButtonListener = iButtonListener;
	}

	public void click(String message) {
		if (iButtonListener != null) {
			this.iButtonListener.clickEvent(message);
		}
	}
}
