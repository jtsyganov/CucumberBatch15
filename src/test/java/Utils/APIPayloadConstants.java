package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"john\",\n" +
                "  \"emp_lastname\": \"smith\",\n" +
                "  \"emp_middle_name\": \"bob\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2022-02-24\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"SDET\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","john");
        obj.put("emp_lastname","smith");
        obj.put("emp_middle_name","bob");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2022-02-24");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","SDET");
        return obj.toString();
    }
    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","86077A");
        obj.put("emp_firstname","ivan");
        obj.put("emp_lastname","ivanov");
        obj.put("emp_middle_name","ivanych");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2012-02-24");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","DevOps");
        return obj.toString();
    }
}
