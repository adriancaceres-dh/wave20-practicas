package com.example.link_tracker.exception;

import com.example.link_tracker.dto.LinkDto;
import com.example.link_tracker.dto.MessageLinkDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LinkAlreadyExist extends RuntimeException {

    MessageLinkDto messageLinkDto;
    public LinkAlreadyExist(MessageLinkDto messageLinkDto) {
        this.messageLinkDto = messageLinkDto;
    }
}
