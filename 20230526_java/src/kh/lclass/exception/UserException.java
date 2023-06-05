package kh.lclass.exception;

import java.net.UnknownServiceException;

public class UserException extends Throwable {

	public UserException() {
		super("유저익섹션 메시지입니다.");
	}
	public UserException(String msg) {
		super(msg);
	}
}
