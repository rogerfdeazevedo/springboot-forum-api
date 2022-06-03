package br.com.rogerfdeazevedo.springbootforumapi.controller;

import br.com.rogerfdeazevedo.springbootforumapi.domain.Curso;
import br.com.rogerfdeazevedo.springbootforumapi.domain.Topico;
import br.com.rogerfdeazevedo.springbootforumapi.dto.InTopicoDTO;
import br.com.rogerfdeazevedo.springbootforumapi.dto.InUpdateTopicoDTO;
import br.com.rogerfdeazevedo.springbootforumapi.dto.OutDetalheTopicoDTO;
import br.com.rogerfdeazevedo.springbootforumapi.dto.OutTopicoDTO;
import br.com.rogerfdeazevedo.springbootforumapi.repository.CursoRepository;
import br.com.rogerfdeazevedo.springbootforumapi.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping("/v1/topicos")
    public List<OutTopicoDTO> listar(String nomeCurso){
        List<OutTopicoDTO> outTopicoDTOList = new ArrayList<>();
        if(nomeCurso == null ) {
            topicoRepository.findAll().forEach((Topico topico) -> {outTopicoDTOList.add(new OutTopicoDTO(topico));});
        } else {
            topicoRepository.findByCurso_Nome(nomeCurso).forEach((Topico topico) -> {outTopicoDTOList.add(new OutTopicoDTO(topico));});
        }
        return outTopicoDTOList;
    }

    @PostMapping("/v1/topicos")
    @Transactional
    public ResponseEntity<OutTopicoDTO> cadastrar(@RequestBody @Valid InTopicoDTO inTopicoDTO, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.findByNome(inTopicoDTO.getNomeCurso());
        Topico topico = inTopicoDTO.converterParaTopico(curso);
        topicoRepository.save(topico);
        URI uri = uriComponentsBuilder.path("/v1/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new OutTopicoDTO(topico));
    }

    @GetMapping("/v1/topicos/{id}")
    public ResponseEntity<OutDetalheTopicoDTO> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            return ResponseEntity.ok(new OutDetalheTopicoDTO(topico.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/v1/topicos/{id}")
    @Transactional
    public ResponseEntity<OutTopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid InUpdateTopicoDTO inUpdateTopicoDTO){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topico.get().setTitulo(inUpdateTopicoDTO.getTitulo());
            topico.get().setMensagem(inUpdateTopicoDTO.getMensagem());
            return ResponseEntity.ok(new OutTopicoDTO(topico.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/v1/topicos/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
