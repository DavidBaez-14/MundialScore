package com.example.mundialscore.sql;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorContraseñas {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // Contraseña para administradores
        String admin123 = encoder.encode("admin123");
        System.out.println("Contraseña: admin123");
        System.out.println("BCrypt: " + admin123);
        System.out.println();
        
        // Contraseña para usuarios
        String user123 = encoder.encode("user123");
        System.out.println("Contraseña: user123");
        System.out.println("BCrypt: " + user123);
        System.out.println();
        
        System.out.println("Copia estos valores en usuarios_iniciales.sql en dado caso no funcionen las contraseñas.");
    }
}
