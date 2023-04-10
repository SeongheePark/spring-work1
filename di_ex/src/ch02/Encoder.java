package ch02;

public class Encoder {
	private IEncoder iEncoder;

	// DI 의존 주입 설정 + 전략 패턴(스트래티지 패턴)
	public Encoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}

	// setter 만들면 ㅡ> 전략 패턴 완성
	public void setiEncoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}


	// 기능
	public String encode(String message) {
		return iEncoder.encode(message);
	}
}
