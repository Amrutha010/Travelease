package com.travelease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Bus;
import com.travelease.models.Route;
import com.travelease.repository.BusRepository;
import com.travelease.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService{
	
	
	@Autowired
	RouteRepository routeRepository;
	
	@Autowired
	BusRepository busRepository;
	

	@Override
	public Route addRoute(Route route) {
		// TODO Auto-generated method stub
		
		Route addedRoute = routeRepository.save(route);
		
		
		return addedRoute;
	}

	@Override
	public Route updateRoute(Route route) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Route> gotRoute = routeRepository.findById(route.getRouteId());
		
		if(gotRoute.isEmpty()) {
			throw new RouteNotFoundException("route not found");
		}
		
		Route updatedRoute = routeRepository.save(route);
		
		return updatedRoute;
	}

	@Override
	public Route removeRoute(Integer id) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		Optional<Route> gotRoute = routeRepository.findById(id);
		
		if(gotRoute.isEmpty()) {
			throw new RouteNotFoundException("route not found by entered id");
		}
		
		
		Route deletedRoute = gotRoute.get();
		
		
		//All the associated buses will be released and not deleted
		
		deletedRoute.getBus().stream().forEach(s->{
			s.setRoute(null);
		});
		
		
		routeRepository.delete(deletedRoute);
		
		
		return deletedRoute;
	}

	@Override
	public Route searchRoute(Integer id) throws RouteNotFoundException {
		// TODO Auto-generated method stub
		Optional<Route> gotRoute = routeRepository.findById(id);
		
		if(gotRoute.isEmpty()) {
			throw new RouteNotFoundException("route not found by entered id");
		}
		
		
		return gotRoute.get();
	}

	@Override
	public List<Route> viewRoute() throws RouteNotFoundException {
		// TODO Auto-generated method stub
		
		List<Route> routeList = routeRepository.findAll();
		
		if(routeList.isEmpty()) {
			throw new RouteNotFoundException("No routes found");
		}
		
		return routeList;
	}

}
