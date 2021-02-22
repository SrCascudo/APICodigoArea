import com.google.gson.Gson;
import org.json.simple.JSONObject;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.*;

@Path("/srcascudo")
public class Service {

    @GET
    @Path("{ddd}")
    @Produces("text/plain")
    public String getMessege(@PathParam("ddd") String param){

        for (CodigoArea codigoArea : CodigoArea.codigoAreaBrasil()) {
            if (codigoArea.getDdd().equals(param.trim())){
                Gson gson = new Gson();
                return gson.toJson(codigoArea);
            }
        }
        return null;
    }

    @GET
    @Produces("text/plain")
    public String Index(){
        return "Informe um Parametro";
    }
}
