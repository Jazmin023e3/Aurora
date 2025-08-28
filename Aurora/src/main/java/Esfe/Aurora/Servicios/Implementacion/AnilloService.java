package Esfe.Aurora.Servicios.Implementacion;

import Esfe.Aurora.Modelos.Anillo;
import Esfe.Aurora.Repositorios.AnilloRepository;
import Esfe.Aurora.Servicios.Interfaces.IAnilloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;



@Service
public class AnilloService implements IAnilloService {

    @Autowired
    private AnilloRepository anilloRepository;

    AnilloService(AnilloRepository anilloRepository) {
        this.anilloRepository = anilloRepository;
    }
    
    @Override
    public Page<Anillo> buscarTodos(Pageable pageable){
        return anilloRepository.findAll(pageable);
    }

    @Override
    public   List<Anillo> obtenerTodos(){
       return  anilloRepository.findAll();
    }

    @Override
    public Optional<Anillo>  buscarPorId(Integer id){
        return anilloRepository.findById(id);
    }

    @Override
    public  Anillo crearOeditar(Anillo anillo){
        return anilloRepository.save(anillo);
    }
    
     @Override
    public  void eliminarPorId(Integer id){
        anilloRepository.deleteById(id);
    }

}
