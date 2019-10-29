package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {

     /*
    There are following public apis
#	Route	        Method  Type	                    Full route	                                Description	Details
1	/employee	    GET	    JSON	http://dummy.restapiexample.com/api/v1/employees	    Get all employee data Details
2	/employee/{id}	GET	    JSON	http://dummy.restapiexample.com/api/v1/employee/{id}	Get a single employee data Details
3	/create	        POST	JSON	http://dummy.restapiexample.com/api/v1/create	        Create new record in database Details
4	/update/{id}	PUT	    JSON	http://dummy.restapiexample.com/api/v1/update/{id}	    Update an employee record Details
5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/{id}	    Delete an employee record Details
*/

    public String baseURI = RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    String employees = "employees";
    String employeeWithId = "employee/";
    String create = "create";
    String update = "update/";
    String delete ="delete/";

    @Test
    public void getAllEmployees() {
        Response response = given().when().get(employees).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath jsonpath = new JsonPath(response.asString());
        System.out.println(jsonpath.get("employee_name"));

    }

    @Test
    public void geOneEmployee() {
        Response response = given().when().get(employeeWithId + 8349).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath jsonpath = new JsonPath(response.asString());
        System.out.println(jsonpath.get("employee_name"));


    }

    @Test
    public void testPostData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "peopleNtech");
        jsonObject.put("salary", "10000");
        jsonObject.put("age", "23");

        Response response = given().header("Content-Type", "application/json")
                .body(jsonObject.toString()).when().post(create).then().statusCode(200).extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void testputcall(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "people");
        jsonObject.put("salary", "100000");
        jsonObject.put("age", "23");

        Response response =given().contentType(ContentType.JSON).body(jsonObject.toString()).put(update+13224);
        System.out.println(response.getStatusCode());

    }

    @Test
    public void testDelete(){
        Response response = given().contentType(ContentType.JSON).delete(delete+13224);
        System.out.println(response.statusCode());
    }


}
