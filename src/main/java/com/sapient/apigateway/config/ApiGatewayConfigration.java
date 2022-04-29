package com.sapient.apigateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class ApiGatewayConfigration {
	
	
	@Bean
	public RouteLocator getWayRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/get")
						.filters(f->f.addRequestHeader("MYHeader","MyURI")
									.addRequestParameter("param","myvalue"))
						.uri("http://httpbin.org:80"))
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.build();
	}

}
