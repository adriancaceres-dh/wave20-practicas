package com.bootcamp._Link_Tracker.exceptions;

import com.bootcamp._Link_Tracker.dto.MessageExceptionDTO;

public class InvalidPasswordException extends RuntimeException{

    private MessageExceptionDTO messageExceptionDTO;
    public InvalidPasswordException(MessageExceptionDTO messageExceptionDTO){
        this.messageExceptionDTO=messageExceptionDTO;
    }

    public MessageExceptionDTO getMessageExceptionDto(){
        return this.messageExceptionDTO;
    }


}
