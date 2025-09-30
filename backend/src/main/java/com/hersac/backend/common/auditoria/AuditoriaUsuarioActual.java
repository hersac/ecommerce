// package com.hersac.backend.common.auditoria;

// import com.hersac.backend.modules.users.usuarios.models.Usuario;
// import
// com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;
// // Asegúrate de que la importación sea correcta

// import org.springframework.data.domain.AuditorAware;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;

// import java.util.Optional;

// @Component
// public class AuditoriaUsuarioActual implements AuditorAware<Usuario> {

// private final UsuarioRepository usuarioRepository;

// public AuditoriaUsuarioActual(UsuarioRepository usuarioRepository) {
// this.usuarioRepository = usuarioRepository;
// }

// @Override
// public Optional<Usuario> getCurrentAuditor() {
// Authentication authentication =
// SecurityContextHolder.getContext().getAuthentication();

// if (authentication == null || !authentication.isAuthenticated()
// || "anonymousUser".equals(authentication.getPrincipal())) {
// return Optional.empty();
// }

// String principalIdentifier = authentication.getName();

// return usuarioRepository.findByEmail(principalIdentifier);
// }
// }