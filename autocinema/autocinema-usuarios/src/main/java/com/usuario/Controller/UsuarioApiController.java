package com.usuario.Controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.entity.Usuario;
import com.usuario.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApiController {
	@Autowired
    private UsuarioRepository usuarioRepo;

	// GET: Listar todos los usuarios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
 // POST: Crear nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepo.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioRepo.findById(id)
                .map(usuarioExistente -> {
                    usuario.setId(id);
                    Usuario actualizado = usuarioRepo.save(usuario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> actualizarParcial(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return usuarioRepo.findById(id)
                .map(usuario -> {
                    campos.forEach((key, value) -> {
                        Field field = ReflectionUtils.findField(Usuario.class, key);
                        if (field != null) {
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, usuario, value);
                        }
                    });
                    Usuario actualizado = usuarioRepo.save(usuario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
 // DELETE: Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return usuarioRepo.findById(id)
                .map(usuario -> {
                    usuarioRepo.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
