package com.travelease.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.BusNotFoundException;
import com.travelease.exception.HotelException;
import com.travelease.exception.PackagesException;
import com.travelease.exception.RouteNotFoundException;
import com.travelease.models.Bus;
import com.travelease.models.Hotel;
import com.travelease.models.Packages;
import com.travelease.models.Route;
import com.travelease.repository.BusRepository;
import com.travelease.repository.HotelDAO;
import com.travelease.repository.PackagesDAO;
import com.travelease.repository.RouteRepository;


@Service
public class PackagesServiceImpl implements PackagesService {

	@Autowired
	private PackagesDAO packRepo;
	
	@Autowired
	private HotelDAO hotelRepo;
	
	@Autowired
	private BusRepository busRepo;
	
	@Autowired
	private RouteRepository routeRepo;
	
	


	@Override
	public Packages createPackage(Packages pgs) throws HotelException, RouteNotFoundException, BusNotFoundException {
		Packages pkg = new Packages();
		
//		pkg.setPackageId(pgs.getPackageId());
		pkg.setPackageName(pgs.getPackageName());
		pkg.setPackageCost(pgs.getPackageCost());
		pkg.setPackageId(pgs.getPackageId());
		pkg.setPackageDescription(pgs.getPackageDescription());
		
		Hotel hotel= hotelRepo.findById(pgs.getHotel().getHotelId())
				.orElseThrow(() -> new HotelException("Hotel Not Found With HotelID : " + pgs.getHotel().getHotelId()));

		Route route = routeRepo.findById(pgs.getRoute().getRouteId())
				.orElseThrow(() -> new RouteNotFoundException("Route Not Found With Route ID : " + pgs.getRoute().getRouteId()));

		
		Bus bus = busRepo.findById(pgs.getBus().getBusID())
				.orElseThrow(() -> new BusNotFoundException("Bus Not Found With Bus ID : "+ pgs.getBus().getBusID()));
		pkg.setHotel(hotel);
		pkg.setRoute(route);
		pkg.setBus(bus);
		
		Packages newPkg= packRepo.save(pkg);
		
		hotelRepo.save(hotel);
		routeRepo.save(route);
		busRepo.save(bus);
		
		return newPkg;
	}

	@Override
	public List<Packages> AllPackages(Integer id) {
		return packRepo.findAll();
	}

	@Override
	public Packages getPackageById(Integer id) throws PackagesException {
		return packRepo.findById(id)
				.orElseThrow(() -> new PackagesException("Package is not available :" + id +" not found"));

	}

	@Override
	public Packages deletePackageById(Integer id) throws PackagesException {
		Packages p = packRepo.findById(id).orElseThrow(() -> new PackagesException("Package is not available :" + id+" not found"));
		
		
			packRepo.delete(p);
		
		return p;
	}

	@Override
	public Packages updatePackages(Packages p) {

		packRepo.save(p);
		return null;
	}

}
