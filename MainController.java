package com.example.demo;


import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class MainController {
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("/register")
	public String register() {
		//DataStorage.storingData();
		
		return "register.jsp";
	}

	
	@RequestMapping("/adduser")
	@ResponseBody
	public List<User> addUser(User user) {
		userRepo.save(user);
		return userRepo.findAll();
	}
	
	@RequestMapping("/checkWithUserName")
	@ResponseBody
	public User checkWithUserName(@RequestParam("userName") String userName) {
		User user = userRepo.findByUserName(userName);
		return user;
	}
	
	@RequestMapping("/checkWithId")
	@ResponseBody
	public Optional<User> checkWithUserId(@RequestParam("userId") int userId) {
		Optional<User> user = userRepo.findById(userId);
		return user;
	}
	
	@RequestMapping("/checkWithUserNameAndPassword")
	@ResponseBody
	public User checkWithUserNameAndPassword(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		User user = userRepo.findByUserNameAndPassword(userName, password);
		return user;
	}
	

	
	@RequestMapping("/readingUrl")
	@ResponseBody
	public String readingDataFromURL() {
		
		List<String> userNameList = userRepo.getAllUserNames();
		
		//Optional<String> firstUserName = userNameList.stream().findFirst();
		
		
//		for (String userName: userNameList) {
//			System.out.println(userName);
//		}
		//userNameList.forEach(userName -> System.out.println(userName));
		//Iterable<User> usersList = userRepo.findAll();
		//usersList.forEach(user -> System.out.println(user.getUserName().toUpperCase()));
		return userNameList.toString();
	}
	
	@RequestMapping("/weather")
	public String gettingWeatherForParticularCity(@RequestParam("city") String city, Model model) {
		String json = ClientBuilder.newClient().target("http://api.apixu.com/v1/current.json?key=3bea2b2943ba4c72ab7130939191806&q="+ city).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(json);
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		model.addAttribute("jsonData", (jsonObject.get("location")).getAsJsonObject().get("name").toString().replace("\"",""));
		model.addAttribute("temp", jsonObject.get("current").getAsJsonObject().get("temp_c"));
		model.addAttribute("icon", jsonObject.get("current").getAsJsonObject().get("condition").getAsJsonObject().get("icon"));
		return "weather.jsp";
	}
	
}
