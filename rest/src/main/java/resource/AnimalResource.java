package resource;

import dto.CadastroAnimalDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.AnimalService;

@Path("/animais") // @RequestMapping
// Os dois -> @RestController
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService animalService;

    @GET
    public Response listar() {
        var animais = animalService.listar();
        return Response.ok(animais).build();
    }

    @POST
    public Response criar(CadastroAnimalDto cadastroAnimalDto) {
        animalService.criar(cadastroAnimalDto);
        return Response.status(201).build();
    }
}
