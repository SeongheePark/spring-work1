package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		// 옵저버 패턴
		Button button = new Button("button1");
		ImgButton1 button1 = new ImgButton1();
		ImgButton2 button2 = new ImgButton2();

		
		// 인터페이스 ㅡ> 익명클래스 ㅡ> 익명구현클래스
		button.setiButtonListener(new IButtonListener() {

			@Override
			public void clickEvent(String event) {
				// 하고싶은 동작, 알고리즘을 구현하면 된다
				System.out.println("콜백 들어옴!" + event);
			}
		});
		///////////////// 옵저버 패턴 설계 완료 /////////////////
		button.setiButtonListener(button1);
		button.click("집에 가!");
		button.click("콜백");
		button.setiButtonListener(button2);
		button.click("옵저버");

				
		
//		Button button2 = new Button("button2");
//		button2.setiButtonListener(new IButtonListener() {
//
//			@Override
//			public void clickEvent(String event) {
//				System.out.println("버튼클릭" + event);
//			}
//			
//		});
//		button2.click("실행!");
//		button2.click("동작!");
//		button2.click("종료!");
	}

}
