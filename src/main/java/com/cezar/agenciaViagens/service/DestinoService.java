package com.cezar.agenciaViagens.service;

import com.cezar.agenciaViagens.model.Destino;
import com.cezar.agenciaViagens.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository repository;

    public DestinoService(DestinoRepository repository) {
        this.repository = repository;
    }

    public Destino cadastrar(Destino destino) {
        return repository.save(destino);
    }

    public List<Destino> listarTodos() {
        return repository.findAll();
    }

    public Destino buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Destino> pesquisar(String termo) {

        List<Destino> resultado = new ArrayList<>();

        resultado.addAll(
                repository.findByNomeContainingIgnoreCase(termo)
        );

        repository.findByLocalizacaoContainingIgnoreCase(termo)
                .forEach(destino -> {
                    if (!resultado.contains(destino)) {
                        resultado.add(destino);
                    }
                });

        return resultado;
    }

    public Destino avaliar(Long id, Integer nota) {

        Destino destino = buscarPorId(id);

        if (destino == null) {
            return null;
        }

        double soma =
                destino.getNotaMedia()
                * destino.getQuantidadeAvaliacoes();

        destino.setQuantidadeAvaliacoes(
                destino.getQuantidadeAvaliacoes() + 1
        );

        destino.setNotaMedia(
                (soma + nota)
                / destino.getQuantidadeAvaliacoes()
        );

        return repository.save(destino);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Destino atualizar(Long id, Destino destinoAtualizado) {

        Destino destino = buscarPorId(id);

        if (destino == null) {
            return null;
        }

        destino.setNome(destinoAtualizado.getNome());
        destino.setLocalizacao(destinoAtualizado.getLocalizacao());
        destino.setDescricao(destinoAtualizado.getDescricao());

        return repository.save(destino);
    }
}