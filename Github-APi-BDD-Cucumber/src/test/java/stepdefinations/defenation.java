package stepdefinations;

import java.util.Map;

import org.testng.Assert;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class defenation {

        public static String baseurl = "https://api.github.com";
        public static String bearer_token = "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";
        RequestSpecification requestspecification;
        Response response;
        JsonPath jsonpath;
        public static String Reponame;
        public static String ShaValue;
        public static int id;

        @Given("Make a post request with the resource1 {string}")
        public void make_a_post_request_with_the_resource1(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body("{\n" +
                                                "  \"name\": \"Team-star-catcherapirepo\",\n" +
                                                "  \"description\": \"This is your first repo!\"\n" +
                                                "}")
                                .when()
                                .post(resourcepath);
        }

        @When("Print the response in console2")
        public void print_the_response_in_console2() {
                jsonpath = new JsonPath(response.getBody().asString());
                System.out.println(response.getBody().asString());
        }

        @Then("Store Necessary data in the variable3")
        public void store_necessary_data_in_the_variable3() {
                jsonpath = new JsonPath(response.getBody().asString());

                Reponame = jsonpath.get("name");
                System.out.println(Reponame);
        }

        @Then("The response status code should be4 {int}")
        public void the_response_status_code_should_be4(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Then("Check Wether the RepoName is stored in variable5 {string}")
        public void check_wether_the_repo_name_is_stored_in_variable5(String reponame) {
                Assert.assertEquals(Reponame, reponame);
        }

        // update all
        @Given("Make a patch request with resource6 {string}")
        public void make_a_patch_request_with_resource6(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body("{\n" +
                                                "  \"name\": \"Team-sananana\",\n" +
                                                "  \"description\": \"This is your first repo!\"\n" +
                                                "}")
                                .when()
                                .patch(resourcepath);
        }

        @When("Print the response in console for update7")
        public void print_the_response_in_console_for_update7() {
                jsonpath = new JsonPath(response.getBody().asString());
                System.out.println();
        }

        @Then("Store Necessary data in the variable for update8")
        public void store_necessary_data_in_the_variable_for_update8() {
                jsonpath = new JsonPath(response.getBody().asString());

                Reponame = jsonpath.get("name");
                System.out.println(Reponame);
        }

        @Then("The response status code should be9 {int}")
        public void the_response_status_code_should_be9(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Then("Check the Updated RepoName10 {string}")
        public void check_the_updated_repo_name10(String reponame) {
                Assert.assertEquals(Reponame, reponame);
        }

        // get request for all
        @Given("Make a GET request with resource11 {string}")
        public void make_a_get_request_with_resource11(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath + Reponame);
        }

        @When("Print the response in console12")
        public void print_the_response_in_console12() {
                jsonpath = new JsonPath(response.getBody().asString());
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be13 {int}")
        public void the_response_status_code_should_be13(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        // create a put request
        @Given("Make a PUT request with the resource14 {string}")
        public void make_a_put_request_with_the_resource14(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body("{\n" +
                                                "  \"message\": \"File Successfully Created\",\n" +
                                                "  \"content\": \"SGVsbG8gV29ybGQ=\"\n" +
                                                "}")
                                .when()
                                .put(resourcepath);
        }

        @Then("Print the response in console15")
        public void print_the_response_in_console15() {
                System.out.println(response.getBody().asString());
        }

        @Then("Store Necessary data in the variable16")
        public void store_necessary_data_in_the_variable16() {
                jsonpath = new JsonPath(response.getBody().asString());
                ShaValue = jsonpath.get("content.sha");
        }

        @Then("The response status code should be17 {int}")
        public void the_response_status_code_should_be17(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Then("Check Wether the sha value is stored in variable18")
        public void check_wether_the_sha_value_is_stored_in_variable18() {
                System.out.println(ShaValue);
        }

        @Given("Make a POST request with the resource19 {string}")
        public void make_a_post_request_with_the_resource19(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body("{\n" +
                                                "  \"organization\": \" Team-Star-Catcher\",\n" +
                                                "  \"name\": \"New-Fork\"\n" +
                                                "}")
                                .when()
                                .post(resourcepath);
        }

        @Then("Print the response in console20")
        public void print_the_response_in_console20() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be21 {int}")
        public void the_response_status_code_should_be21(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request For FORKS with the resource22 {string}")
        public void make_a_get_request_for_forks_with_the_resource22(String resourcepath) throws InterruptedException {
                Thread.sleep(5000);
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);

        }

        @Then("Print the response in console23")
        public void print_the_response_in_console23() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be24 {int}")
        public void the_response_status_code_should_be24(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request For LIST OF REPOSITORY with the resource25 {string}")
        public void make_a_get_request_for_list_of_repository_with_the_resource25(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);
        }

        @Then("Print the response in console26")
        public void print_the_response_in_console26() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be27 {int}")
        public void the_response_status_code_should_be27(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request for repositories languages with the resource28 {string}")
        public void make_a_get_request_for_repositories_languages_with_the_resource28(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);
        }

        @Then("Print the response in console29")
        public void print_the_response_in_console29() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be30 {int}")
        public void the_response_status_code_should_be30(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request for public repositories with the resource31 {string}")
        public void make_a_get_request_for_public_repositories_with_the_resource31(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);
        }

        @Then("Print the response in console32")
        public void print_the_response_in_console32() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be33 {int}")
        public void the_response_status_code_should_be33(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a POST request to create a release with the resource34 {string}")
        public void make_a_post_request_to_create_a_release_with_the_resource34(String resourcepath) {
                Map<String, Object> jsonData = new HashMap<String, Object>();
                jsonData.put("tag_name", "GitHub");
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body(jsonData)
                                .when()
                                .post(resourcepath);
        }

        @Then("Print the response in console35")
        public void print_the_response_in_console35() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be36 {int}")
        public void the_response_status_code_should_be36(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request for repositories tags with the resource38 {string}")
        public void make_a_get_request_for_repositories_tags_with_the_resource38(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);
        }

        @Then("Print the response in console39")
        public void print_the_response_in_console39() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be40 {int}")
        public void the_response_status_code_should_be40(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a POST request For autolink with the resource42 {string}")
        public void make_a_post_request_for_autolink_with_the_resource42(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body("{\n" +
                                                "  \"key_prefix\": \"Github-Api-Testing\",\n" +
                                                "  \"url_template\": \"https://example.com/Api?query=<num>\"\n" +
                                                "}")
                                .when()
                                .post(resourcepath);
        }

        @Then("Print the response in console43")
        public void print_the_response_in_console43() {
                System.out.println(response.getBody().asString());
        }

        @Then("Store Necessary data in the variable44")
        public void store_necessary_data_in_the_variable44() {
                jsonpath = new JsonPath(response.getBody().asString());
                id = jsonpath.get("id");
                System.out.println(id);
        }

        @Then("The response status code should be45 {int}")
        public void the_response_status_code_should_be45(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a PUT request for repositories topics with the resource46 {string}")
        public void make_a_put_request_for_repositories_topics_with_the_resource46(String resourcepath) {
                Map<String, Object> jsonData = new HashMap<String, Object>();
                String[] myStringArray = { "github", "github-api", "github-api-testing" };
                jsonData.put("names", myStringArray);
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body(jsonData)
                                .when()
                                .put(resourcepath);
        }

        @Then("Print the response in console47")
        public void print_the_response_in_console47() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be48 {int}")
        public void the_response_status_code_should_be48(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request for repositories topics with the resource49 {string}")
        public void make_a_get_request_for_repositories_topics_with_the_resource49(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath);
        }

        @Then("Print the response in console50")
        public void print_the_response_in_console50() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be60 {int}")
        public void the_response_status_code_should_be60(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a GET request for repositories autolink with the resource62 {string}")
        public void make_a_get_request_for_repositories_autolink_with_the_resource62(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .get(resourcepath + id);
        }

        @Then("Print the response in console63")
        public void print_the_response_in_console63() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be64 {int}")
        public void the_response_status_code_should_be64(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a Delete request to delete autolink with the resource66 {string}")
        public void make_a_delete_request_to_delete_autolink_with_the_resource66(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .delete(resourcepath + id);
        }

        @Then("The Delete response status code should be67 {int}")
        public void the_delete_response_status_code_should_be67(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a Delete request with the resource68 {string}")
        public void make_a_delete_request_with_the_resource68(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .delete(resourcepath);
        }

        @Then("Print the response in console69")
        public void print_the_response_in_console69() {
                System.out.println(response.getBody().asString());
        }

        @Then("The response status code should be70 {int}")
        public void the_response_status_code_should_be70(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a Delete file request with the resource71 {string}")
        public void make_a_delete_file_request_with_the_resource71(String resourcepath) {
                Map<String, Object> jsonData = new HashMap<String, Object>();
                jsonData.put("message", "deleted file");
                jsonData.put("sha", ShaValue);
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .body(jsonData)
                                .when()
                                .delete(resourcepath);

        }

        @Given("The response status code should be72 {int}")
        public void the_response_status_code_should_be72(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

        @Given("Make a Delete request with the resource73 {string}")
        public void make_a_delete_request_with_the_resource73(String resourcepath) {
                response = given()
                                .baseUri(baseurl)
                                .header("Authorization", "Bearer " + bearer_token)
                                .contentType(ContentType.JSON)
                                .when()
                                .delete(resourcepath);
        }

        @Then("The Delete response status code should be74 {int}")
        public void the_delete_response_status_code_should_be74(int statuscode) {
                Assert.assertEquals(statuscode, response.getStatusCode());
                System.out.println(response.getStatusCode());
        }

}
