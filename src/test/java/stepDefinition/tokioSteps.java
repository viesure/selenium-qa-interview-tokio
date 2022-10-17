package stepDefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.fail;
import java.util.Arrays;

public class tokioSteps{
	private JsonPath jsonPathEvaluator;
	private String[] conditionArray;
	private String condition;
	private Integer celsius, celsiusapi;
	
	@Before
	public void the_data_is_requested() {
		RestAssured.baseURI = "https://backend-interview-tokio.tools.gcp.viesure.io";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/weather");
		jsonPathEvaluator = response.jsonPath();
		condition = response.jsonPath().getString("condition");
		Integer fahrenheitapi = jsonPathEvaluator.get("weather.tempInFahrenheit");
		celsiusapi = jsonPathEvaluator.get("weather.tempInCelsius");
		float ctemp, ftemp;
		ftemp = fahrenheitapi;
		ctemp = ((ftemp-32)*5)/9;
    	celsius = Math.round(ctemp);
	}
	
	@Before
	public void condition_rules() {
		conditionArray = new String[]{"placeholder", "clear", "windy", "mist", "drizzle", "dust"};
	}
	
	@When("I check the city field")
	public void i_check_the_city_field() {
		String city = jsonPathEvaluator.get("city");
		if(city == null) fail("The element is not string.");
		//System.out.println(city);
	}
	
    @When("I check the conditionID field")
	public void i_check_the_conditionid_field() {
		String conditionID = jsonPathEvaluator.get("conditionID");
		if(conditionID == null) fail("The element is missing from JSON data structure.");
		//System.out.println(conditionID);
    }
    
    @When("I check the condition field")
	public void i_check_the_condition_field() {
		boolean isValid = Arrays.asList(conditionArray).contains(condition);
		if(!isValid) fail("Invalid condition.");
		//System.out.println(condition);
    }
    
    @When("I check the icon field")
	public void i_check_the_icon_field() {
		String icon = jsonPathEvaluator.get("icon");
		if(!condition.equals(icon.substring(0, icon.length() - 4))) fail("Invalid icon.");
		//System.out.println(icon.substring(0, icon.length() - 4));
    }
    
    @When("I check the weather object")
	public void i_check_the_weather_object() {
    	if(celsiusapi != celsius) fail("Celsius was miscalculated");
    	//System.out.println(celsius);
    }
    
    @When("I check the description field")
	public void i_check_the_description_field() {
		String description = jsonPathEvaluator.get("description");
		String[] arrOfdesc = description.split(" ");
		description = (arrOfdesc[3].substring(0, arrOfdesc[3].length() - 1));
		//tem.out.println(description);
		//System.out.println(celsius);
		if((celsius <= 0 && !description.equals("freezing")) || (celsius > 0 && celsius < 10 && !description.equals("cold")) || (celsius >= 10 && celsius < 20 && !description.equals("mild")) || (celsius >= 20 && celsius < 25 && !description.equals("warm")) || (celsius >= 25 && !description.equals("hot"))) fail("Description is not accurate");
    }
    
    @When("I check Sydneys weather date and time")
    public void i_check_sydneys_weather_date_and_time() {
    	System.out.println("I had no time for the Selenium part, sorry!");
    }
}


