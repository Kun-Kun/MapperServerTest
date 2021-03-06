package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationSettingsRequestHandler extends AbstractRequestHandler<GetConversationSettingsRequest,GetConversationSettingsResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_conversation_settings";
    }

    @Override
    public Class<GetConversationSettingsRequest> getRequestDataClass() {
        return GetConversationSettingsRequest.class;
    }

    @Override
    public Response<GetConversationSettingsResponse> processRequest(Request<GetConversationSettingsRequest> msg){
        return null;
    }
}
