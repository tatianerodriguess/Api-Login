package projetofinal.apiprojetofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import projetofinal.apiprojetofinal.model.UsuarioModel;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer>{
    List<UsuarioModel> findAll();

    UsuarioModel findByCodigo(int codigo);
}