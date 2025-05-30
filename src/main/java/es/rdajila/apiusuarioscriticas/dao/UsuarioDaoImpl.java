package es.rdajila.apiusuarioscriticas.dao;

import es.rdajila.apiusuarioscriticas.model.Usuario;
import es.rdajila.apiusuarioscriticas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{
    public final IUsuarioRepository repository;

    @Autowired
    public UsuarioDaoImpl(IUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario eUsuario) {
        return repository.save(eUsuario);
    }

    @Override
    public Optional<Usuario> getById(int eId) {
        return repository.findById(eId);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Boolean delete(Integer eId) {
        repository.deleteById(eId);
        return true;
    }

    @Override
    public Optional<Usuario> getByCorreoAndEstado(String eCorreo, Integer eEstado) {
        return repository.findByCorreoAndEstado(eCorreo, eEstado);
    }

    @Override
    public Boolean existsByCorreo(String eCorreo) {
        return repository.existsByCorreo(eCorreo);
    }

    @Override
    public List<Usuario> getAllFilterRolesAdminOrUser() {
        return repository.getByRolesCodeAdminOrUser();
    }

    @Override
    public List<Usuario> getByNombresOrCorreoOrRolId(String eTxt, Integer eRolId) {
        return repository.getByNombresOrCorreoOrRolId(eTxt, eRolId);
    }

}
