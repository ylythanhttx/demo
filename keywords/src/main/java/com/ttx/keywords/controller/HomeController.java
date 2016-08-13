package com.ttx.keywords.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttx.adwords.MainApp;
import com.ttx.adwords.kwplan.ResourceUtil;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String home(Model model, String listKey) {

		try {

			// List<Map<String, Object>> results = MainApp.run(new String[] {
			// "Đánh nhau trong bóng đá", "Hài bóng đá",
			// "Clip hài bóng đá", "Hài bóng đá chọn lọc" });
			model.addAttribute("results", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/result", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String result(Model model, String listKey) {

		try {

			String[] ls = listKey.split(",");
			List<Map<String, Object>> results = MainApp.run(ls);
			model.addAttribute("results", results);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/resultws", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public List<Map<String, Object>> resultws(Model model, /* String listKey */
			@RequestBody Map<String, Object> data) {

		try {

			String[] ls = data.get("listKey").toString().split(",");
			ResourceUtil.setModeSearchFromClient(data.get("modesearchId")
					.toString());
			ResourceUtil
					.setLocationsFromClient(data.get("locationId") == null ? null
							: data.get("locationId").toString().split(","));
			ResourceUtil
					.setLanguagesFromClient(data.get("languageId") == null ? null
							: data.get("languageId").toString().split(","));
			List<Map<String, Object>> results = MainApp.run(ls);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/alldata", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Map<String, List<Map<String, String>>> alldata() {
		Map<String, List<Map<String, String>>> alldata = new HashMap<String, List<Map<String, String>>>();
		alldata.put("alllacation", ResourceUtil.getAllLocation());
		alldata.put("alllanguage", ResourceUtil.getAllLanguage());
		alldata.put("modesearch", ResourceUtil.getModeSearch());
		alldata.put("defaultInVn",
				Arrays.asList(ResourceUtil.getDefault_In_Vn()));
		alldata.put("defaultOutVn",
				Arrays.asList(ResourceUtil.getDefault_Out_Vn()));

		return alldata;
	}

	@RequestMapping(value = "/allLocation", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public List<Map<String, String>> getAllLocations() {

		List<Map<String, String>> results = ResourceUtil.getAllLocation();
		return results;
	}

	@RequestMapping(value = "/allLanguage", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public List<Map<String, String>> getAllLanguages() {

		List<Map<String, String>> results = ResourceUtil.getAllLanguage();
		return results;
	}

	@RequestMapping(value = "/modeSearch", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public List<Map<String, String>> modeSearch() {

		List<Map<String, String>> results = ResourceUtil.getModeSearch();
		return results;
	}

	public static void main(String... strings) throws Exception {

		List<Map<String, Object>> results = MainApp.run(new String[] {
				"Đánh nhau trong bóng đá", "Hài bóng đá", "Clip hài bóng đá",
				"Hài bóng đá chọn lọc" });
	}
}
