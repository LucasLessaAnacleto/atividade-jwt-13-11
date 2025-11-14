package senac.lucas.atividade_jwt.modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(unique = true, nullable = false)
    private String documento;

    @Column
    private Date dataNascimento;

    @Column(nullable = false)
    private String email;

}
