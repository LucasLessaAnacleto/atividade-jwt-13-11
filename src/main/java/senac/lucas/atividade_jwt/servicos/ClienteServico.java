package senac.lucas.atividade_jwt.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import senac.lucas.atividade_jwt.controllers.dtos.CriarClienteDTO;
import senac.lucas.atividade_jwt.modelos.Cliente;
import senac.lucas.atividade_jwt.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServico(ClienteRepositorio clienteRepositorio){
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<Cliente> buscarTodos(){
        return clienteRepositorio.findAll();
    }

    public Cliente buscar(Long id){
        Optional<Cliente> clienteResult = clienteRepositorio.findById(id);
        if(clienteResult.isEmpty()){
            throw new RuntimeException("Cliente não encontrado!");
        }
        return clienteResult.get();
    }

    public void criar(CriarClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setDocumento(clienteDTO.getDocumento());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());
        clienteRepositorio.save(cliente);
    }

    public void excluir(Long id){
        if(!clienteRepositorio.existsById(id)){
            throw new RuntimeException("Cliente não existe!");
        }
        clienteRepositorio.deleteById(id);
    }

    public Cliente atualizar(Long id, CriarClienteDTO clienteDTO){
        Cliente clienteExistente = clienteRepositorio.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não existe!"));
    
        // Atualizar dados do cliente
        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setSobrenome(clienteDTO.getSobrenome());
        clienteExistente.setDocumento(clienteDTO.getDocumento());
        clienteExistente.setDataNascimento(clienteDTO.getDataNascimento());
        clienteExistente.setEmail(clienteDTO.getEmail());
        
        return clienteRepositorio.save(clienteExistente);
    }


}
