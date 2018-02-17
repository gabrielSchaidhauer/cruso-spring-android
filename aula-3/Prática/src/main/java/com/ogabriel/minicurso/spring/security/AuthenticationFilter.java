package com.ogabriel.minicurso.spring.security;

import com.ogabriel.minicurso.spring.model.entity.Usuario;
import com.ogabriel.minicurso.spring.model.repository.UsuarioRepository;
import com.ogabriel.minicurso.spring.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

@Component
public class AuthenticationFilter extends GenericFilterBean {

    @Autowired
    private UsuarioService service;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Basic")) {

            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();

            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));

            // credentials = username:password
            final String[] values = credentials.split(":", 2);

            Usuario usuario = service.findUserByNomeAndSenha(values[0], values[1]);

            if(Objects.nonNull(usuario)) {
                SecurityContextHolder.getContext().setAuthentication(new AuthenticatedUser(usuario));
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
