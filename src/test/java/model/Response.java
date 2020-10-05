package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
    private Coord coord;

    @JsonProperty("weather")
    private List<Weathers> weathers;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weathers> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weathers> weathers) {
        this.weathers = weathers;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
//{
//        "coord": {
//        "lon": -0.13,
//        "lat": 51.51
//        },
//        "weathers": [
//        {
//        "id": 300,
//        "main": "Drizzle",
//        "description": "light intensity drizzle",
//        "icon": "09d"
//        }
//        ],
//        "base": "stations",
//        "main": {
//        "temp": 280.32,
//        "pressure": 1012,
//        "humidity": 81,
//        "temp_min": 279.15,
//        "temp_max": 281.15
//        },
//        "visibility": 10000,
//        "wind": {
//        "speed": 4.1,
//        "deg": 80
//        },
//        "clouds": {
//        "all": 90
//        },
//        "dt": 1485789600,
//        "sys": {
//        "type": 1,
//        "id": 5091,
//        "message": 0.0103,
//        "country": "GB",
//        "sunrise": 1485762037,
//        "sunset": 1485794875
//        },
//        "id": 2643743,
//        "name": "London",
//        "cod": 200
//        }