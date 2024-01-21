package com.eltigro.memberinvitelink.exception;

public class InvalidInvitationException extends RuntimeException {
    public InvalidInvitationException() {
        super("유효하지 않은 초대 링크입니다.");
    }

    public InvalidInvitationException(String message) {
        super(message);
    }

    public InvalidInvitationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInvitationException(Throwable cause) {
        super(cause);
    }

    protected InvalidInvitationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
