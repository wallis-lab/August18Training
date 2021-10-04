package TestNg;
import java.lang.reflect.Type;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

public class ApiProject {
	final Type type = null;
	@Test
	public void TestGetSingleUser() {

		given().get("/api/users/2").then()
		.statusCode(200)
		.body("data.email", equalTo("janet.weaver@reqres.in"));
	}

	@Test
	public void TestPostLogin() {
		String loginInfo = "{\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\n"
				+ "    \"password\": \"cityslicka\"\n"
				+ "}";

		given()
		.contentType(ContentType.JSON)
		.body(loginInfo)
		.post("/api/login")
		.then().statusCode(200)
		.body("token", equalTo("QpwL5tke4Pnpja7X4"));
	}

	@Test
	public void TestDelect() {
		given().delete("/api/users/2").then()
		.statusCode(204);
		//Response code 204: no content
		//Successful request and no content display
	}

	@Test
	public void TestPatch() {
		String updateInfo = "{"
				+ "\"name\":\"Morpheus 2\""
				+ "}";

		String currentTimeStamp = given()
				.patch("/api/users/2")
				.then()
				.extract()
				.path("updatedAt");


		given()
		.header("Content-Type","application/json")
		.body(updateInfo)
		.patch("/api/users/2")
		.then()
		.statusCode(200)
		.body("name", equalTo("Morpheus 2"))
		.body("updatedAt", not(equalTo(currentTimeStamp)));	
	}

	@Test
	public void TestPut() {
		String updateInfo = "{"
				+ "\"name\":\"Morpheus 2\""
				+ "}";

		String currentTimeStamp = given()
				.patch("/api/users/2")
				.then()
				.extract()
				.path("updatedAt");

		given()
		.header("Content-Type","application/json")
		.body(updateInfo)
		.put("/api/users/2")
		.then()
		.statusCode(200)
		.body("name", equalTo("Morpheus 2"))
		.body("updatedAt", not(equalTo(currentTimeStamp)));	
	}

	@Test
	public void TestDeserializeIntoObject() {

		String jsonString = given().get("/api/users/2").then().statusCode(200).extract().asString();

		singleUser s = new Gson().fromJson(jsonString, singleUser.class);

		Assert.assertEquals(s.data.id, 2);
		Assert.assertEquals(s.data.email, "janet.weaver@reqres.in");
		Assert.assertEquals(s.data.first_name, "Janet");
		Assert.assertEquals(s.data.last_name, "Weaver");
		Assert.assertEquals(s.data.avatar, "https://reqres.in/img/faces/2-image.jpg");
	}

	@Test
	public void TestDeserializeIntoCollectionObject() {

		String jsonString = new Gson().toJson(given().get("/api/users?page=2").then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response().path("data"));

		singleUser.Data[] singleuser = new Gson().fromJson(jsonString, singleUser.Data[].class);

		Assert.assertEquals(singleuser[1].id, 8);
		Assert.assertEquals(singleuser[0].email, "michael.lawson@reqres.in");
		Assert.assertEquals(singleuser[0].first_name, "Michael");
		Assert.assertEquals(singleuser[0].last_name, "Lawson");
		Assert.assertEquals(singleuser[0].avatar, "https://reqres.in/img/faces/7-image.jpg");
	}

	@BeforeTest
	public void beforeTest() {
		RestAssured.baseURI="https://reqres.in/";
	}
}


