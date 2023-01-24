package com.bootcamp.QA_Testers.exceptions;

import com.bootcamp.QA_Testers.dto.MessageExceptionDTO;

public class TestNotFoundException extends RuntimeException{

    private MessageExceptionDTO messageExceptionDTO;
    public TestNotFoundException(MessageExceptionDTO messageExceptionDTO){
        this.messageExceptionDTO=messageExceptionDTO;
    }

    public MessageExceptionDTO getMessageExceptionDto(){
        return this.messageExceptionDTO;
    }


}
