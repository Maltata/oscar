package com.apioscar.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apioscar.dto.FiltroBuscaDto;
import com.apioscar.model.Calcado;
import com.apioscar.repository.CalcadoRepository;
import com.apioscar.service.CalcadoService;

@RestController
@RequestMapping("/calcado")
public class CalcadoController {

	@Autowired
	private CalcadoRepository calcadoRepository;
	
	@Autowired
	private CalcadoService calcadoService;
	
	@GetMapping
	public List<Calcado> listar() 
	{
		return calcadoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Calcado> cadastrar(@RequestBody Calcado calcado, HttpServletResponse response)
	{
		calcado.setDataCadCalcado(calcadoService.getDataAtual());
		
		Calcado calcadoSalvo = calcadoRepository.save(calcado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idCalcado}").buildAndExpand(calcadoSalvo.getIdCalcado()).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(calcadoSalvo);
	}
	
	@GetMapping("/{idCalcado}")
	public Calcado buscaPorId(@PathVariable Long idCalcado)
	{
		return calcadoRepository.findById(idCalcado).orElse(null);
	}
	
	@DeleteMapping("/{idCalcado}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long idCalcado)
	{
		this.calcadoRepository.deleteById(idCalcado);
	}
	
	@PostMapping("/busca-composta")
	public ResponseEntity<ArrayList<Calcado>> buscaMetodoPagCartao(@RequestBody FiltroBuscaDto filtroBusca)
	{
		return ResponseEntity.ok(calcadoRepository.findAllCalcados(
				filtroBusca.getTamanhoCalcado(), filtroBusca.getCategoriaCalcado(),
				filtroBusca.getCorCalcado(), filtroBusca.getPrecoCalcado(), filtroBusca.getMarcaCalcado(),
				filtroBusca.getDataCadastroCalcado(), filtroBusca.getDescricaoCalcado()));
	}
	
	@PutMapping("/{idCalcado}")
	public ResponseEntity<Calcado> atualizar(@PathVariable Long idCalcado, @RequestBody Calcado calcado)
	{
		Calcado calcadoSalvo = calcadoService.atualizar(idCalcado, calcado);
		
		return ResponseEntity.ok(calcadoSalvo);
	}
	
	
	
	
}
