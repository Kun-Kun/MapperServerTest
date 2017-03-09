package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsByIdsRequest;
import com.softgroup.messenger.api.message.GetConversationsByIdsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationsByIdsRequestHandler extends AbstractRequestHandler<GetConversationsByIdsRequest,GetConversationsByIdsResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_conversations_by_ids";
    }


}