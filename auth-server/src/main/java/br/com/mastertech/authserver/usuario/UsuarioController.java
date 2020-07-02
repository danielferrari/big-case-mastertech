package br.com.mastertech.authserver.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/me")
    public Map<String, Object> validar(Principal principal) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByName(principal.getName());

        Map<String, Object> map = new HashMap<>();
        map.put("name", principal.getName());
        if (usuarioOptional.isPresent()) {
            map.put("id", usuarioOptional.get().getId());
            return map;
        }
        map.put("id", 0);
        return map;
    }
}
