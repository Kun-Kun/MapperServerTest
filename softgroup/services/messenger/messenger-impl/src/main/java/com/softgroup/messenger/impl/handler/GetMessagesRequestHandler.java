package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.message.GetMessagesRequest;
import com.softgroup.messenger.api.message.GetMessagesResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class GetMessagesRequestHandler extends AbstractRequestHandler<GetMessagesRequest,GetMessagesResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_messages";
    }

    @Override
    public Response<GetMessagesResponse> processRequest(Request<GetMessagesRequest> msg){
        return null;
    }
}
