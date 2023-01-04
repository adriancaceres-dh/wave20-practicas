package com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;

public class InvalidPostDataException extends RuntimeException{
    private MessageExceptionDTO messageExceptionDTO;

    public InvalidPostDataException(MessageExceptionDTO messageExceptionDTO) {
        this.messageExceptionDTO = messageExceptionDTO;
    }

    public MessageExceptionDTO getMessageExceptionDTO() {return this.messageExceptionDTO;}
}
