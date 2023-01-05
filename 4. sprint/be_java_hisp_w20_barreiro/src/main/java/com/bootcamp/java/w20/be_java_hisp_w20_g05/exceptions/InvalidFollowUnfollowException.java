package com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;

public class InvalidFollowUnfollowException extends RuntimeException{

    private MessageExceptionDTO messageExceptionDTO;
    public InvalidFollowUnfollowException(MessageExceptionDTO messageExceptionDTO){
        this.messageExceptionDTO=messageExceptionDTO;
    }

    public MessageExceptionDTO getMessageExceptionDto(){
        return this.messageExceptionDTO;
    }


}
