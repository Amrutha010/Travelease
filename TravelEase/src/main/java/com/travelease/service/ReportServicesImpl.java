package com.travelease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelease.exception.AdminException;
import com.travelease.exception.ReportException;
import com.travelease.models.Report;
import com.travelease.models.ReportDTO;
import com.travelease.repository.ReportDAO;

@Service
public class ReportServicesImpl implements ReportServices {

	@Autowired
	private ReportDAO rDao;
	
	@Autowired
	private AdminServices aServices;

	@Override
	public Report addAReport(ReportDTO report) throws AdminException {
		// TODO Auto-generated method stub
		
		Report myReport = new Report();
		myReport.setReportName(report.getReportName());
		myReport.setReportType(report.getReportType());
		myReport.setAdmin(aServices.getAdminById(report.getAdminId()));
		
		return rDao.save(myReport);
		
	}

	@Override
	public Report deleteAReportById(Integer reportID) throws ReportException {
		// TODO Auto-generated method stub
		
		Report report = rDao.findById(reportID).orElseThrow(()-> new ReportException("No Report found with that exception"));
		rDao.delete(report);
		return report;
		
	}
	
}
