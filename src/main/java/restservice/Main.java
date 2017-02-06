package restservice;

import static spark.Spark.after;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.port;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
	private static UserService userService=new UserService();
	private static ObjectMapper mapper=new ObjectMapper();
	public static void main(String[] args) {
		port(5678);
		get("/user", (request,response)->{
			List<User> oUserList = userService.getAllUser();				
			return mapper.writeValueAsString(oUserList);
		});
		
		get("/user/:id", (request,response)->{
			int id=Integer.parseInt(request.params(":id"));
			User oUser=userService.getUserByID(id);
			return mapper.writeValueAsString(oUser);
		});
		
		post("/user", (request,response)->{
			User oUser=mapper.readValue(request.body(), User.class);
			boolean result=userService.addUser(oUser);
			return mapper.writeValueAsString(result);
		});
		
		put("/user/:id", (request,response)->{
			int id=Integer.parseInt(request.params(":id"));
			User oUser=mapper.readValue(request.body(), User.class);
			oUser=userService.updateUser(id, oUser);
			return mapper.writeValueAsString(oUser);
		});
		
		delete("/user/:id", (request,response)->{
			int id=Integer.parseInt(request.params(":id"));
			boolean result=userService.deleteUser(id);
			return mapper.writeValueAsString(result);
		});
		
		after((request,response)->response.type("application/json"));
	}

}
