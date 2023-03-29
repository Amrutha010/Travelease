package com.travelease.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.Exceptions.PackagesException;
import com.travelease.models.Packages;
import com.travelease.repository.HotelDAO;
import com.travelease.repository.PackagesDAO;


@Service
public class PackagesServiceImpl implements PackagesService {

	@Autowired
	private PackagesDAO packageDAO;
	
	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public Packages createPackage(Packages pgs) {
		return packageDAO.save(pgs);
		
	}

	@Override
	public List<Packages> AllPackages(Integer id) {
		return packageDAO.findAll();
	}

	@Override
	public Optional<Packages> getPackageById(Integer id) throws PackagesException {
		return packageDAO.findById(id);
	}

	@Override
	public Packages deletePackageById(Integer id) throws PackagesException {
		Packages p = packageDAO.findById(id).orElseThrow(() -> new PackagesException("Package is not available :" + id));
		
		if (p != null) {
			packageDAO.deleteById(id);
		}
		return p;
	}

	@Override
	public Packages updatePackages(Packages p) {

		packageDAO.save(p);
		return null;
	}

}
