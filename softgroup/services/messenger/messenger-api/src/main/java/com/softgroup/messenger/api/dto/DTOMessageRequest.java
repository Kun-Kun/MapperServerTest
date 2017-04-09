package com.softgroup.messenger.api.dto;

import com.softgroup.common.protocol.enumeration.MessageType;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOMessageRequest implements Serializable{

    private static final long serialVersionUID = 7291994180216238396L;
    //id Conversation
    private	String conversationId;
    //type of the message
    private MessageType messageType;
    //message text
    private	String payload;
    //create time generated by user
    private	Long createTime;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
