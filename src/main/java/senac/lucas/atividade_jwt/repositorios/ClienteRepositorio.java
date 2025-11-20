package senac.lucas.atividade_jwt.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import senac.lucas.atividade_jwt.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {}
