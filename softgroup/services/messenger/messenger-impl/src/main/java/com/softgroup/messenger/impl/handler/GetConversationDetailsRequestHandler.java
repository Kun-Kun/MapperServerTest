package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsRequestHandler extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>  implements MessengerRequestHandler {

    public String getName(){
        return "get_conversation_details";
    }

}
