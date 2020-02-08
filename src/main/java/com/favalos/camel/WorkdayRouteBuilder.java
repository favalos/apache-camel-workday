package com.favalos.camel;

import org.apache.camel.builder.RouteBuilder;

public class WorkdayRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer://reportTimer?delay=0&period=10000").
                to("workday:report:/ISU_Camel/All_Active_Workers?" +
                        "Include_Subordinate_Organizations=1&Is_Active=1&" +
                        "host={{workday.host}}&tenant={{workday.tenant}}&" +
                        "clientId={{workday.clientId}}&clientSecret={{workday.clientSecret}}&" +
                        "tokenRefresh={{workday.tokenRefresh}}").
                to("stream:out");

    }

}
