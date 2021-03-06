package com.softgroup.server.rest.controller;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.filter.api.DenyAuthorizationRequestBorderFilterHandler;
import com.softgroup.server.tools.service.ControllerTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping(value = "/api")
public class PrivateController {

    @Autowired
    private DenyAuthorizationRequestBorderFilterHandler denyAuthorizationRequestBorderFilterHandler;

    @Autowired
    private ControllerTool controllerTool;

    @RequestMapping(value = "/private",method = RequestMethod.POST,consumes="application/json",produces = "application/json")
    @ResponseBody
    public Response privateController(@RequestParam String data) {
        Request<LinkedHashMap> request = controllerTool.parseRequestFromJson(data);
        request = controllerTool.setRoutingData(request);
        return denyAuthorizationRequestBorderFilterHandler.handle(request);
    }

}
