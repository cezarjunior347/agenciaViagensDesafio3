package com.cezar.agenciaViagens.controller;

import com.cezar.agenciaViagens.model.Destino;
import com.cezar.agenciaViagens.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    @Autowired
    private DestinoService service;

    @PostMapping
    public Destino cadastrar(@RequestBody Destino destino) {
        return service.cadastrar(destino);
    }

    @GetMapping
    public List<Destino> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Destino buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/pesquisa")
    public List<Destino> pesquisar(@RequestParam String termo) {
        return service.pesquisar(termo);
    }

    @PutMapping("/{id}")
    public Destino atualizar(
            @PathVariable Long id,
            @RequestBody Destino destino) {

        return service.atualizar(id, destino);
    }

    @PatchMapping("/{id}/avaliacao")
    public Destino avaliar(
            @PathVariable Long id,
            @RequestParam Integer nota) {

        return service.avaliar(id, nota);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}