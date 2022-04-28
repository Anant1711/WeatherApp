package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String APPID = "46d9adbc476fe27669cee3acad29f242";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?appid="+APPID;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("Enter the city >> ");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        sc.close();
        List<String> data = getWeatherInfo(city);
        data.forEach(System.out::println);
    }

    public static List<String> getWeatherInfo(String city) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL+"&q="+city))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return parseData(response.body());
    }

    public static List<String> parseData(String data) {
        JSONObject jsonObj = new JSONObject(data);
        List<String> result = new ArrayList<String>();
        String name = jsonObj.getString("name");
        String weatherDesc = jsonObj.getJSONArray("weather").getJSONObject(0).getString("description");
        String temp = String.format("%.2f", jsonObj.getJSONObject("main").getDouble("temp") - 273) + " degree celsius";
        String tempFeelsLike = String.format("%.2f", jsonObj.getJSONObject("main").getDouble("feels_like") - 273) + " degree celsius";
        String tempMin = String.format("%.2f", jsonObj.getJSONObject("main").getDouble("temp_min") - 273) + " degree celsius";
        String tempMax = String.format("%.2f", jsonObj.getJSONObject("main").getDouble("temp_max") - 273) + " degree celsius";
        String pressure = "" + jsonObj.getJSONObject("main").getInt("pressure");
        String humidity = "" + jsonObj.getJSONObject("main").getInt("humidity");
        String visibility = "" + jsonObj.getInt("visibility");
        String windSpeed = String.format("%.2f", jsonObj.getJSONObject("wind").getDouble("speed")) + " m/s";
        result.add("Name: " + name);
        result.add("Weather description: " + weatherDesc);
        result.add("Current temp: " + temp);
        result.add("Feels like: " + tempFeelsLike);
        result.add("Minimum temp: " + tempMin);
        result.add("Maximum temp: " + tempMax);
        result.add("Pressure: " + pressure);
        result.add("Humidity: " + humidity);
        result.add("Visibility: " + visibility);
        result.add("Wind speed: " + windSpeed);

        return result;
    }
}