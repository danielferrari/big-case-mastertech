package br.com.mastertech.authserver.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = usuarioRepository.findByName(username);

        if(!optional.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Usuario usuario = optional.get();

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");

        return new User(usuario.getName(), usuario.getPassword(), Collections.singletonList(authority));
    }

    @PostConstruct
    public void populate() {
        Usuario usuario = new Usuario();
        usuario.setName("Daniel");
        usuario.setPassword(encoder.encode("daniel123"));
        usuarioRepository.save(usuario);
    }
}
