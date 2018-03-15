package com.metacube.employeedata;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * this class contains APIs which returns output as per request from the client
 * @author Satyam Bhadoria
 *
 */
@Path("/employee")
public class EmployeeAPI {
	
	private JSONParser parser = new JSONParser();
	private File file = new File("C:/Users/admin/Documents/myWorkPlace/WebService-Session-2/src/com/metacube/files/employee.json");

	/**
	 * Method which returns json of all employee
	 * @return json formated employee list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEmployees(){
		return getFileContent();
	}
	
	/**
	 * Method which return employee detail with particuolar id
	 * @param id - id of employee
	 * @return employee detail in json format
	 * @throws ParseException - exception in parsing
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeById(@PathParam("id") String id) throws ParseException{
		String message = "{}";
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		
		/*checking each employee*/
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(employee.get("id").toString().equalsIgnoreCase(id)){
				message = employee.toString();
				break;
			}
		}
		return message;
	}
	
	/**
	 * Method which returns employees detail with particular name
	 * @param employeeName - name of employee
	 * @return employees detail in json format
	 * @throws ParseException - exception in parsing
	 */
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeesByName(@QueryParam("name") String employeeName) throws ParseException{
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		
		/*checking each employee*/
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(!employee.get("name").toString().equalsIgnoreCase(employeeName)){
				employeesArray.remove(employee);
				i--;
			}
		}
		return employeesJsonObject.toString();
	}
	
	/**
	 * Method which add employee after creating
	 * @param employeeJsonString - employee json with detail
	 * @return message of success
	 * @throws ParseException - exception in parsing
	 */
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public String createEmployee(@QueryParam("employee") String employeeJsonString) throws ParseException{
		int id = 0;
		JSONObject employee = (JSONObject) parser.parse(employeeJsonString);
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		
		if(!employeesArray.isEmpty()) {
			id = Integer.parseInt(((JSONObject) employeesArray.get(employeesArray.size() - 1)).get("id").toString());
		}
		addEmployee(id + 1, employee);
		employeesArray.add(employee);
		insertIntoFile(employeesJsonObject.toString());
		return employee.toString();
	}
	
	/**
	 * Method which delete the employee with particular id
	 * @param id - id of employee
	 * @return message of success
	 * @throws ParseException - exception in parsing
	 */
	@GET
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@QueryParam("id") String id) throws ParseException {
		
		JSONObject employeesJsonObject = (JSONObject) parser.parse(getFileContent());
		JSONArray employeesArray = (JSONArray) employeesJsonObject.get("employee");
		JSONObject employee;
		
		/*checking each employee*/
		for ( int i = 0 ; i < employeesArray.size() ; i++ ){
			employee = ((JSONObject) employeesArray.get(i));
			
			if(employee.get("id").toString().equalsIgnoreCase(id)){
				employeesArray.remove(employee);
				break;
			}
		}

		insertIntoFile(employeesJsonObject.toString());
		return "success";
	}
	
	/**
	 * create employee
	 * @param id - id of created employee
	 * @param employee - detail of employee in json format
	 */
	private static void addEmployee(int id, JSONObject employee){
		employee.put("id", Integer.toString(id));
	}
	
	/**
	 * Method which returns file content
	 * @return employees json
	 */
	private String getFileContent(){
		String employeesJsonString="";
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				employeesJsonString += sc.nextLine();
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return employeesJsonString;
	}
	
	/**
	 * Method which insert employee data into file
	 * @param data - employee data
	 */
	private void insertIntoFile(String data){
		OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
