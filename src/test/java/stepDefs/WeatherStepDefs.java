package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String city;
    private String country;
    private Response response;

    @Given("city is: {string}")
    public void set_city(String city) {
        this.city = city.toUpperCase();
    }

    @Given("country is: {string}")
    public void set_country(String country) {
        this.country = country.toLowerCase();
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester weatherRequester = new WeatherRequester();
        response = weatherRequester.requestWeather(city, country);
    }

    @Then("lon is {double}")
    public void check_lon(Double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(),
                "Wrong longitude!");
    }

    @Then("lat is {double}")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(),
                "Wrong latitude!");
    }

    @Then("id is {int}")
    public void check_id(int id) {
        Assertions.assertEquals(id,response.getWeathers().get(0).getId(),"Wrong id!");
    }

    @Then("main is {string}")
    public void check_main(String main) {
        Assertions.assertEquals(main,response.getWeathers().get(0).getMain(),"Wrong main!");
    }

    @Then("description is {string}")
    public void check_desctription(String description) {
        Assertions.assertEquals(description,response.getWeathers().get(0).getDescription(),"Wrong description!");
    }

    @Then("icon is {string}")
    public void check_icon(String icon) {
        Assertions.assertEquals(icon,response.getWeathers().get(0).getIcon(),"Wrong icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base,response.getBase(),"Wrong base!");
    }

    @Then("temp is {double}")
    public void check_temp(Double temp) {
        Assertions.assertEquals(temp,response.getMain().getTemp(),"Wrong temp!");
    }

    @Then("pressure is {int}")
    public void check_pressure(int pressure) {
        Assertions.assertEquals(pressure,response.getMain().getPressure(),"Wrong pressure!");
    }

    @Then("humidity is {int}")
    public void check_humidity(int humidity) {
        Assertions.assertEquals(humidity,response.getMain().getHumidity(),"Wrong humidity!");
    }

    @Then("temp_min is {double}")
    public void check_temp_min(Double temp_min) {
        Assertions.assertEquals(temp_min,response.getMain().getTemp_min(),"Wrong minimum temperature!");
    }

    @Then("temp_max is {double}")
    public void check_temp_max(Double temp_max) {
        Assertions.assertEquals(temp_max,response.getMain().getTemp_max(),"Wrong max temperature!");
    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        Assertions.assertEquals(visibility,response.getVisibility(),"Wrong visibility!");
    }

    @Then("speed is {double}")
    public void check_speed(Double speed) {
        Assertions.assertEquals(speed,response.getWind().getSpeed(),"Wrong speed!");
    }

    @Then("deg is {int}")
    public void check_deg(int deg) {
        Assertions.assertEquals(deg,response.getWind().getDeg(),"Wrong degree!");
    }

    @Then("all is {int}")
    public void check_all(int all) {
        Assertions.assertEquals(all,response.getClouds().getAll(),"Wrong all!");
    }

    @Then("dt is {int}")
    public void check_dt(int dt) {
        Assertions.assertEquals(dt,response.getDt(),"Wrong dt!");
    }

    @Then("type is {int}")
    public void check_type(int type) {
        Assertions.assertEquals(type,response.getSys().getType(),"Wrong type!");
    }

    @Then("id is: {int}")
    public void check_that_id(int id) {
        Assertions.assertEquals(id,response.getSys().getId(),"Wrong id!");
    }

    @Then("message is {double}")
    public void check_message(Double message) {
        Assertions.assertEquals(message,response.getSys().getMessage(),"Wrong message!");
    }

    @Then("country is {string}")
    public void check_country(String country) {
        Assertions.assertEquals(country,response.getSys().getCountry(),"Wrong country!");
    }

    @Then("sunrise is {int}")
    public void check_sunrise(int sunrise) {
        Assertions.assertEquals(sunrise,response.getSys().getSunrise(),"Wrong sunrise!");
    }

    @Then("sunset is {int}")
    public void check_sunset(int sunset) {
        Assertions.assertEquals(sunset,response.getSys().getSunset(),"Wrong sunset!");
    }

    @Then("id is : {int}")
    public void check_this_id(int id) {
        Assertions.assertEquals(id,response.getId(),"Wrong id!");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name,response.getName(),"Wrong name!");
    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod,response.getCod(),"Wrong cod!");
    }
}


//аннотация, область видимости перменной,перечислите аннотации огурца для описания степов, распишите метод для следующего
// шага "we are on home page", то такое API и для чего он используется, в чём разница запросов get и post, напишите сценарий 5-6
// на тестирование кофе на огурце, что такое PageObject, что такое константа, что такое конструктор,