package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODg1MDc5MjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4ODU1MTEyMSwidXNlcklkIjoiNTU1NCJ9.1TbPPr1d7lWjH-RoRk7egObvgih_7I8azOhGNO4RpVg";
    static String employee_id;

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);
        //hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //verify 2 ids: global and local
        Assert.assertEquals(employee_id, tempEmpId);
    }
    @Test
    public void acreateEmployee() {
        //prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" + "  \"emp_firstname\": \"sam\"," +
                        "\n" + "  \"emp_lastname\": \"smith\"," +
                        "\n" + "  \"emp_middle_name\": \"bob\"," +
                        "\n" + "  \"emp_gender\": \"M\"," +
                        "\n" + "  \"emp_birthday\": \"2022-02-24\"," +
                        "\n" + "  \"emp_status\": \"Confirmed\"," +
                        "\n" + "  \"emp_job_title\": \"SDET\"\n" + "}");

        //hitting the endpoint/send request
        Response response = preparedRequest.when().post("/createEmployee.php");
        //it will print output
        response.prettyPrint();
        //verifying the assertions/get response
        response.then().assertThat().statusCode(201);

        //to capture employee ID from the responce
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        //verifying the assertions/get response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("sam"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("smith"));

        //verifying the response header
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My testcase passed");

    }
    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"bob\",\n" +
                        "  \"emp_lastname\": \"brown\",\n" +
                        "  \"emp_middle_name\": \"john\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-06-28\",\n" +
                        "  \"emp_status\": \"trainee\",\n" +
                        "  \"emp_job_title\": \"ceo\"\n" +
                        "}");

        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        //to verify

    }


}
