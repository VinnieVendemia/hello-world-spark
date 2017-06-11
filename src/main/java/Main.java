
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
        
        
	     // matches "GET /hello/foo" and "GET /hello/bar"
	     // request.params(":name") is 'foo' or 'bar'
	     get("/hello/:name", (request, response) -> {
	         return "Hello: " + request.params(":name");
	     });
	     
		  // matches "GET /say/hello/to/world"
		  // request.splat()[0] is 'hello' and request.splat()[1] 'world'
		  get("/say/*/to/*", (request, response) -> {
		      return "Number of splat parameters: " + request.splat().length;
		  });
    }
}
