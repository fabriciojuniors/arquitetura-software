package service;

import dto.CadastroAnimalDto;
import dto.RespostaAnimalDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class AnimalService {

    private final Map<Integer, RespostaAnimalDto> BD = new HashMap<>();

    public void criar(CadastroAnimalDto novoAnimal) {
        var idGerado = BD.size() + 1;
        var animal = new RespostaAnimalDto(
                idGerado,
                novoAnimal.nome(),
                novoAnimal.raca(),
                true
        );
        BD.put(idGerado, animal);
    }

    public List<RespostaAnimalDto> listar() {
        return BD.values().stream().toList();
    }

    public RespostaAnimalDto buscar(Integer id) {
        return BD.get(id);
    }
}
