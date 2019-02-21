package com.sample.service.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.dbrepository.SchoolDataRepository;
import com.sample.service.format.RequestFormat;
import com.sample.service.format.Schooldata;

@CrossOrigin
@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	SchoolDataRepository sdr;
	
	@CrossOrigin
	@PostMapping("/getData")
	private String getSchoolData(@RequestBody RequestFormat request) throws JSONException {

		JSONObject response = new JSONObject();
		// Sample Type : Student Count | School Comparison 2017 / 2018
		// COUNT | COMPARISON
		
		// GET All DATA
		List<Schooldata> schoolDataList = sdr.findAll();
		
		if (request.getSampleType().equalsIgnoreCase("COUNT")) 
		{
			if (request.getChartType().equalsIgnoreCase("BAR") || request.getChartType().equalsIgnoreCase("LINE")) 
			{				
				JSONArray dataJArray = new JSONArray();
				JSONArray labelsArray = new JSONArray();
				JSONArray dataArray = new JSONArray();

				for (Schooldata s : schoolDataList) {
					if (s.getSchoolName().equalsIgnoreCase("MVM")) {
						// Bar | Line Same
						// labels : ['','','','','','','',''];
						// data: [{data: ['','','','','',''], label:'COUNT'}];

						labelsArray.put(s.getStandard());
						dataArray.put(s.getStudentCount());
					}
				}

				JSONObject dataLabel = new JSONObject();
				dataLabel.put("data", dataArray);
				dataLabel.put("label", "COUNT");
				
				dataJArray.put(dataLabel);

				response.put("data", dataJArray);
				response.put("label", labelsArray);

			}
			else if(request.getChartType().equalsIgnoreCase("PIE")) {
				response = getPieData(schoolDataList, "MVM");
			}
			else if(request.getChartType().equalsIgnoreCase("TABLE")) {
				/**GET All DATA*/
				response = getAllTableData(schoolDataList);
			}
		}
		else if(request.getSampleType().equalsIgnoreCase("COMPARISON")) 
		{
			if (request.getChartType().equalsIgnoreCase("BAR") || request.getChartType().equalsIgnoreCase("LINE"))
			{
				
				JSONArray labels = new JSONArray();
				JSONArray dataMVM = new JSONArray();
				JSONArray dataHVD = new JSONArray();
				
				for(Schooldata s : schoolDataList) {
					if(s.getSchoolName().equalsIgnoreCase("MVM")) {
						labels.put(s.getStandard());
						dataMVM.put(s.getStudentCount());
					}
					else
					{
						dataHVD.put(s.getStudentCount());
					}
				}
				
				JSONObject jdatamvm = new JSONObject();
				jdatamvm.put("data", dataMVM);
				jdatamvm.put("label", "MVM");
				
				JSONObject jdatahvd = new JSONObject();
				jdatahvd.put("data", dataHVD);
				jdatahvd.put("label", "HARVARD");
				
				JSONArray ja = new JSONArray();
				ja.put(jdatamvm);
				ja.put(jdatahvd);
				
				response.put("data", ja);
				response.put("label", labels);
			}
				
			else if(request.getChartType().equalsIgnoreCase("TABLE")) {
				response = getAllTableData(schoolDataList);
			}
			else if(request.getChartType().equalsIgnoreCase("PIE")) {
				response = getPieData(schoolDataList, "HARVARD");
			}
		}
		
		return response.toString();
	}
	
	
	private JSONObject getAllTableData(List<Schooldata> schoolDataList) throws JSONException {
		
		JSONObject response = new JSONObject();
		/**GET All DATA*/
		JSONArray ja = new JSONArray();
		JSONObject jo = null;
		
		for (Schooldata s : schoolDataList) {
			jo = new JSONObject(s);
			ja.put(jo);
		}
		
		return response.put("data", ja);
		
	}
	
	private JSONObject getPieData(List<Schooldata> schoolDataList, String type) throws JSONException {
		
		JSONObject response = new JSONObject();
		JSONArray dataJArray = new JSONArray();
		JSONArray labelsData = new JSONArray();
		JSONArray dataData = new JSONArray();

		for (Schooldata s : schoolDataList) {
			if (s.getSchoolName().equalsIgnoreCase(type)) {
				labelsData.put(s.getStandard());
				dataData.put(s.getStudentCount());
			}
			else if(s.getSchoolName().equalsIgnoreCase(type)) {
				labelsData.put(s.getStandard());
				dataData.put(s.getStudentCount());
			}
		}

		JSONObject dataObj = new JSONObject();
		dataObj.put("data", dataData);
		// dataObj.put("label", "COUNT");
		
		dataJArray.put(dataObj);

		response.put("data", dataJArray);
		response.put("label", labelsData);
		
		return response;
	}

}
