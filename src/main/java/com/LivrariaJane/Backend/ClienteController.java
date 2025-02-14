package com.LivrariaJane.Backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ClienteController {
    @Autowired
    ClienteRepository bd;

    @PostMapping("/api/cliente")
    public void gravar(@RequestBody Cliente obj){
        bd.save(obj);
    }

    @PutMapping("/api/cliente")
    public void alterar(@RequestBody Cliente obj){
        bd.save(obj);
    }

    @GetMapping("/api/cliente/{codigo}")
    public Cliente carregar(@PathVariable int codigo){
        Optional<Cliente> obj = bd.findById(codigo);
        if(obj.isPresent()){
            return obj.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public void remover(@PathVariable int codigo){
        bd.deleteById(codigo);
    }

    @GetMapping("/api/clientes")
    public List<Cliente> listar(){
        return bd.findAll();
    }

    @PostMapping("/api/cliente/login")
    public Cliente fazerLogin(@RequestBody Cliente obj){
    Optional<Cliente> retorno = bd.login(obj.getEmail(), obj.getSenha());
    if(retorno.isPresent()){
        return retorno.get();
    } else {
        // Retornar um cliente com um campo de erro ou algo que o frontend possa verificar
        Cliente erro = new Cliente();
        erro.setCodigo(0);  // Um valor que indica erro de login
        return erro;
    }
}

    @PostMapping("/api/cliente/recupera")
    public Cliente recuperarSenha(@RequestBody Cliente obj){
        Optional<Cliente> retorno = 
            bd.recuperaSenha(obj.getEmail());
        if(retorno.isPresent()){
            return retorno.get();
        } else {
            return null;
        }
    }

    @GetMapping("/api/cliente/verificar")
    public boolean verificarCadastro(@RequestParam(required = false) String documento, @RequestParam(required = false) String email) {
        if (documento != null && bd.existsByDocumento(documento)) {
            return true; // CPF já cadastrado
        }
        if (email != null && bd.existsByEmail(email)) {
            return true; // E-mail já cadastrado
        }
        return false; // Nenhum dado encontrado
    }

}

