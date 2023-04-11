package ch01;

public class ImgButton2 implements IButtonListener{

	@Override
	public void clickEvent(String event) {
		System.out.println("2번 이미지 버튼" + event);
	}	

}
