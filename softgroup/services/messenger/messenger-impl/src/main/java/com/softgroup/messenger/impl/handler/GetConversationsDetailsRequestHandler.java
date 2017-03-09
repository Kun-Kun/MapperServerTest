package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationsDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationsDetailsRequestHandler extends AbstractRequestHandler<GetConversationsDetailsRequest,GetConversationsDetailsResponse>implements MessengerRequestHandler {

    public String getName(){
        return "get_conversations_details";
    }

}