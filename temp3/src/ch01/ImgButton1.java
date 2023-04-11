package ch01;

public class ImgButton1 implements IButtonListener{

	@Override
	public void clickEvent(String event) {
		System.out.println("여기는 이미지 버튼 1 " + event);
	}

}
