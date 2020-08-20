package module;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/valida_cpf")
public class Cpf_Service {
    @GET
    @Path("{cpf}")
    @Produces("text/plain")
    public String getMessege(@PathParam("cpf") String cpf){

        cpf = CPF_VALIDATOR.clearNumberText(cpf);

        if(CPF_VALIDATOR.isCPF(cpf))
            return cpf;

        else
            return null;
    }

    @GET
    @Produces("text/plain")
    public String Index(){

        return "Informe o CPF!";
    }

}
