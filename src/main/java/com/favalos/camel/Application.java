package com.favalos.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.PropertiesComponent;

public class Application {

    public static void main(String[] args) {

        WorkdayRouteBuilder workdayRouteBuilder = new WorkdayRouteBuilder();
        CamelContext camelContext = new DefaultCamelContext();
        PropertiesComponent pc = camelContext.getPropertiesComponent();
        pc.setLocation("classpath:/workday.properties");

        try {
            camelContext.addRoutes(workdayRouteBuilder);
            camelContext.start();
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
