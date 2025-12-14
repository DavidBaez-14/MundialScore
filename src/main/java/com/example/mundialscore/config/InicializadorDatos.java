package com.example.mundialscore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InicializadorDatos {

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            System.out.println("==============================================");
            System.out.println("   MUNDIALSCORE - SISTEMA DE PRONÓSTICOS    ");
            System.out.println("==============================================");
            System.out.println();
            System.out.println("DATOS INICIALES:");
            System.out.println("   Los usuarios y partidos se cargan desde SQL:");
            System.out.println();
            System.out.println("   1️⃣  sql/usuarios_iniciales.sql");
            System.out.println("       → 2 Administradores");
            System.out.println("       → 3 Usuarios de prueba");
            System.out.println();
            System.out.println("   2️⃣  sql/partidos_mundial_2026.sql");
            System.out.println("       → 72 partidos (12 grupos × 6 partidos)");
            System.out.println("       → Fase de grupos completa");
            System.out.println();
            System.out.println(" CREDENCIALES DE ACCESO:");
            System.out.println("   Admin: carlos.angarita@mundial.com | admin123");
            System.out.println("   Admin: admin@mundial.com           | admin123");
            System.out.println("   User:  juan.perez@mundial.com      | user123");
            System.out.println("   User:  maria.garcia@mundial.com    | user123");
            System.out.println("   User:  pedro.rodriguez@mundial.com | user123");
            System.out.println();
            System.out.println(" API DOCUMENTACIÓN:");
            System.out.println("   Swagger UI: http://localhost:8080/swagger-ui.html");
            System.out.println("==============================================");
        };
    }
}