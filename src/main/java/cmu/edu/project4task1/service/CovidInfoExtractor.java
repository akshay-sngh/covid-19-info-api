package cmu.edu.project4task1.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Service class that handles requests to 3rd party API.
 * <p>
 * References:
 * https://github.com/CMU-Heinz-95702/lab4-http-server
 */
public class CovidInfoExtractor {
    private static final String API_ENDPOINT = "http://covidsurvey.mit.edu:5000/query?age=";
    private static final String API_TAILER = "&gender=all&country=US&signal=locations_would_attend";

    /**
     * Extracts useful info required by the android application that calls the rest service.
     * More importantly, it flattens the input JSON and makes processing on the client side easier.
     *
     * @param json JSON response returned by the external server
     * @return formatted JSON with only the required values
     */
    public static JSONObject jsonToSurveyResultJSON(String json) {
        JSONObject obj = new JSONObject(json);
        JSONObject surveyResults;
        JSONObject locations = new JSONObject();
        if (obj.has("locations_would_attend")) {
            surveyResults = obj.getJSONObject("locations_would_attend");
            // Flatten the JSON to make processing easier for the android app
            for (String locationName : surveyResults.keySet()) {
                JSONObject weight = surveyResults.getJSONObject(locationName).getJSONObject("weighted");
                locations.put(locationName, String.format("%s, -%s", weight.getDouble("Yes"), weight.getDouble("No")));
            }

            obj.put("survey_results", locations);
            obj.remove("locations_would_attend");
        } else
            obj.put("error", "No data returned");
        obj.remove("input_params");
        obj.remove("results_count");

        return obj;
    }

    /**
     * Creates a GET request for the external API, gets the response, extracts useful info and returns
     * it to the caller.
     *
     * @param ageRange input for the external API
     * @return JSONObject with necessary output
     */
    public JSONObject getCovidInfoJSON(String ageRange) {
        String requestURL = createRequestURL(ageRange);
        String apiResponse = fetch(requestURL);
        return extractCovidInfoJSON(apiResponse);
    }

    private JSONObject extractCovidInfoJSON(String apiResponse) {
        return jsonToSurveyResultJSON(apiResponse);
    }

    private String createRequestURL(String ageRange) {
        return API_ENDPOINT + ageRange + API_TAILER;
    }

    /**
     * Make an HTTP request to a given URL
     *
     * @param urlString The URL of the request
     * @return A string of the response from the HTTP GET.  This is identical
     * to what would be returned from using curl on the command line.
     */
    private String fetch(String urlString) {
        String response = "";
        try {
            URL url = new URL(urlString);
            /*
             * Create an HttpURLConnection.  This is useful for setting headers
             * and for getting the path of the resource that is returned (which
             * may be different than the URL above if redirected).
             * HttpsURLConnection (with an "s") can be used if required by the site.
             */
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String str;
            // Read each line of "in" until done, adding each to "response"
            while ((str = in.readLine()) != null) {
                // str is one line of text readLine() strips newline characters
                response += str;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("An exception occurred.");
        }
        return response;
    }
}