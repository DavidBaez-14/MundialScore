package com.example.mundialscore.config;

import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Usuario;
import com.example.mundialscore.repository.PartidoRepository;
import com.example.mundialscore.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InicializadorDatos {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, PartidoRepository partidoRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // Init Users
            if (usuarioRepository.count() == 0) {
                Usuario admin = new Usuario("Admin", "admin@mundial.com", passwordEncoder.encode("admin123"),
                        "ROLE_ADMIN");
                Usuario user1 = new Usuario("User1", "user1@mundial.com", passwordEncoder.encode("user123"),
                        "ROLE_USER");
                usuarioRepository.save(admin);
                usuarioRepository.save(user1);
            }

            // Init Matches
            if (partidoRepository.count() == 0) {
                partidoRepository.save(new Partido("Argentina", "Saudi Arabia"));
                partidoRepository.save(new Partido("Mexico", "Poland"));
                partidoRepository.save(new Partido("France", "Australia"));
            }
        };
    }
}
