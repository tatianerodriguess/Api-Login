package projetofinal.apiprojetofinal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetofinal.apiprojetofinal.model.UsuarioModel;
import projetofinal.apiprojetofinal.repository.UsuarioRepository;

import java.util.List;

@RestController
public class UsuarioController {


    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/lista")
    public List<UsuarioModel> selecionar(){
        return (List<UsuarioModel>) repository.findAll();
    }

    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel salvar (@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }

    @PutMapping(path = "/api/usuario/alterar")
    public UsuarioModel alterar(@RequestBody UsuarioModel obj){
        return repository.save(obj);
    }

    @DeleteMapping(path = "/api/{codigo}")
    public void remover(@PathVariable Integer codigo){

        UsuarioModel obj = repository.findByCodigo(codigo);
        repository.delete(obj);
    }

}
