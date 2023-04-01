package com.travelease.service;

import com.travelease.exception.AdminException;
import com.travelease.exception.ReportException;
import com.travelease.models.Report;
import com.travelease.models.ReportDTO;

public interface ReportServices {

	public Report addAReport(ReportDTO report) throws AdminException;
	
	public Report deleteAReportById(Integer reportID)throws ReportException;
}
