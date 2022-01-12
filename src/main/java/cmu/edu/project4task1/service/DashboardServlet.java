package cmu.edu.project4task1.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Akshay Singh
 * Navigate to http://localhost:8080/Project4Task1Service-1.0-SNAPSHOT/ after launching the app
 * References:
 * 1. https://stackoverflow.com/questions/802967/why-does-httpservlet-throw-an-ioexception
 * 2. https://docs.oracle.com/cd/E17802_01/products/products/servlet/2.5/docs/servlet-2_5-mr2/javax/servlet/ServletException.html
 */
@WebServlet(name = "dashboard", urlPatterns = {"/latencyChart", "/usageChart", "/errorChart", "/likelihoodsChart", "/requestersById", "/requestsByDay", "/covid-resources"})
public class DashboardServlet extends HttpServlet {
    CovidInfoExtractor service;

    public void init() {
        service = new CovidInfoExtractor();
    }

    /**
     * This method is the entry point to all GET requests to DashboardServlet
     *
     * @param request  HTTP request that comes in after the page is loaded
     * @param response HTTP response
     * @throws ServletException Defines a general exception a servlet can throw when it encounters difficulty
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    /**
     * This method acts as a web service endpoint as opposed to a servlet.
     * It calls the MIT server endpoint and formats the response to send it back to the calling app.
     *
     * @param request  HTTP request that comes in after the page is loaded
     * @param response HTTP response
     * @throws IOException Defines an input or output error is detected when the servlet handles the GET request
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=UTF-8;");
        JSONObject requestJSON = new JSONObject(request.getReader().readLine());
        // Fetch age range from the request body.
        JSONObject responseJSON = service.getCovidInfoJSON(requestJSON.getString("ageRange"));
        requestJSON.put("response", responseJSON);
        // Send back the JSON response
        PrintWriter out = response.getWriter();
        out.print(responseJSON);
        out.flush();
    }
}