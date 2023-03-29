package com.travelease.service;

import java.util.List;

import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Route;


public interface RouteService {

	
public Route addRoute(Route route);
	
	public Route updateRoute(Route route) throws RouteNotFoundException;
	
	public Route removeRoute(Integer id) throws RouteNotFoundException;
	
	public Route searchRoute(Integer id) throws RouteNotFoundException;
	
	public List<Route> viewRoute() throws RouteNotFoundException;
}
