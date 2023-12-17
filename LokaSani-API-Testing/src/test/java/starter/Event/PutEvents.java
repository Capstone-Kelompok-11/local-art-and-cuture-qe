package starter.Event;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.apache.http.client.methods.RequestBuilder.put;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class PutEvents {
    // background
    private static String url = "https://lokasani.my.id/";
    @Step("I set API endpoint for update event")
    public String setAPIForUpdateEvent(){
        return url + "event/2";
    }

    //SUCCESSFUL UPDATE NAME EVENT INFORMATION
    @Step("I send a request PUT request to update name information")
    public void sendPUTRequestEventWithNameInformation(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("'data'.'eventName'", "Taylor Swift");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIForUpdateEvent());

        //generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateEvent());
    }
    @Step("I should receive a 200 OK response")
    public void receiveStatusShouldEqualCode200ForUpdateEvent() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("The response should contain of the updated event with the changed event name")
    public void receiveValidDataForUpdateEventWithNameInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'eventName'", equalTo("Taylor Swift")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //SUCCESSFUL UPDDATE DESCRIPTION EVENT INFORMATION
    @Step("I send a request PUT request to update a description")
    public void sendPUTRequestEventWithDescriptionInformation(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("'data'.'eventDescription'", "This is taylor swift");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIForUpdateEvent());
        //generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateEvent());
    }
    @Step("The response should contain of the updated event with the changed event description")
    public void receiveValidDataForUpdateEventWithDescriptionInformatpm() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'eventDescription'", equalTo("This is taylor swift")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //SUCCESSFUL UPDDATE DATE EVENT INFORMATION
    @Step("I send a request PUT request to update a date")
    public void sendPUTRequestEventWithDateInformation(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("'data'.'fromDate'", "2023-12-31T19:00:00Z");
        requestBody.put("'data'.'toDate'", "2023-12-31T19:00:00Z");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIForUpdateEvent());
        //generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateEvent());
    }
    @Step("The response should contain of the updated event with the changed event description")
    public void receiveValidDataForUpdateEventWithDateInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'data'.'fromDate'", equalTo("2023-12-31T19:00:00Z")));
        restAssuredThat(response -> response.body("'data'.'toDate'", equalTo("2023-12-31T19:00:00Z")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //UPDATED EVENT WITH INVALID ID
    @Step("I set API endpoint for update event with invalid event ID")
    public String setAPIForUpdateEventWithInvalidID(){
        return url + "event/12";
    }
    @Step("I send a request PUT request to update a date with invalid event ID")
    public void sendPUTRequestEventWithInvalidID(){
        SerenityRest.given().put(setAPIForUpdateEventWithInvalidID());

//        generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateEventWithInvalidID());
    }
    @Step("I should receive a 404 code")
    public void receiveStatusShouldEqualCode404ForUpdateEvent() {
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("The response should contain an error message indicating that the event ID is not found")
    public void responseShouldContainErrorMessageIDIsNotFound() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_ID_UPDATE_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("can't find any Event with this id")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    //UPDATED EVENT WITH INVALID URL
    @Step("I set invalid endpoint API for update event with invalid event URL")
    public String setAPIForUpdateEventWithInvalidURL(){
        return url + "/eventsw/12";
    }
    @Step("I send a request PUT request to update a date with invalid event URL")
    public void sendPUTRequestEventWithInvalidURL(){
        SerenityRest.given().put(setAPIForUpdateEventWithInvalidURL());

        //        generate token
//        String data = GenerateToken.generateToken();
//
//        SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .header("Authorization", "Bearer " + data)
//                .put(setAPIForUpdateEventWithInvalidURL());
    }
    @Step("I should receive a 400 code")
    public void receiveStatusShouldEqualCode400ForUpdateEvent() {
        restAssuredThat(response -> response.statusCode(400));
    }
    @Step("The response should contain an error message indicating that bad request")
    public void responseShouldContainErrorMessageIsBadRequest() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INVALID_URL_UPDATE_EVENT_SCHEMA);
        restAssuredThat(response -> response.body("'message'",is("missing or malformed jwt")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
