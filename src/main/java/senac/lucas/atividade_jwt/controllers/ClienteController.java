package senac.lucas.atividade_jwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import senac.lucas.atividade_jwt.controllers.dtos.CriarClienteDTO;
import senac.lucas.atividade_jwt.modelos.Cliente;
import senac.lucas.atividade_jwt.servicos.ClienteServico;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServico clienteServico;

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return ResponseEntity.ok( clienteServico.buscarTodos() );
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try {
            return ResponseEntity.ok( clienteServico.buscar(id) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    
    @PostMapping("/criar")
    public ResponseEntity<Void> criar(@RequestBody CriarClienteDTO clienteDTO){
        clienteServico.criar(clienteDTO);
        return ResponseEntity.ok(null);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        clienteServico.excluir(id);
        return ResponseEntity.ok(null);
    }
        
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody CriarClienteDTO clienteDTO){
        try {
            return ResponseEntity.ok(clienteServico.atualizar(id, clienteDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
