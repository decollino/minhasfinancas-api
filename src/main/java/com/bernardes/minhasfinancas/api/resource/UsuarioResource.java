package com.bernardes.minhasfinancas.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardes.minhasfinancas.api.dto.UsuarioDTO;
import com.bernardes.minhasfinancas.exception.ErroAutenticacao;
import com.bernardes.minhasfinancas.exception.RegraNegocioException;
import com.bernardes.minhasfinancas.model.entity.Usuario;
import com.bernardes.minhasfinancas.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

//	private UsuarioService service;
	private final UsuarioService service;
//	private final LancamentoService lancamentoService;
	
	public UsuarioResource( UsuarioService service ) {
		this.service = service;
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar( @RequestBody UsuarioDTO dto ) {
		try {
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		}catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody UsuarioDTO dto ) {
		
		Usuario usuario = Usuario.builder()
					.nome(dto.getNome())
					.email(dto.getEmail())
					.senha(dto.getSenha()).build();
		
		try {
			Usuario usuarioSalvo = service.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
