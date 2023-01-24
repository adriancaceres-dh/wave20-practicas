package com.bootcamp.Joyeria.exceptions;

import com.bootcamp.Joyeria.dto.MessageExceptionDTO;

public class JoyaNotFoundException extends RuntimeException{

    private MessageExceptionDTO messageExceptionDTO;
    public JoyaNotFoundException(MessageExceptionDTO messageExceptionDTO){
        this.messageExceptionDTO=messageExceptionDTO;
    }

    public MessageExceptionDTO getMessageExceptionDto(){
        return this.messageExceptionDTO;
    }
}
