package ch02;

import java.util.Base64;

public class Base64Encoder implements IEncoder {

	@Override
	public String encode(String message) {
		// 인코딩 처리 ㅡ> Base64형식으로
		String resultEncode = Base64.getEncoder().encodeToString(message.getBytes());
		return resultEncode;
	}

}
