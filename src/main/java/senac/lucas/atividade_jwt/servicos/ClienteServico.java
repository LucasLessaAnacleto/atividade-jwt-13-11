package senac.lucas.atividade_jwt.servicos;

import org.springframework.stereotype.Service;
import senac.lucas.atividade_jwt.modelos.Cliente;
import senac.lucas.atividade_jwt.repositorios.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {
    private ClienteRepositorio clienteRepositorio;

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

    public void criar(){

    }


}
