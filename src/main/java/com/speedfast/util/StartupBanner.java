package com.speedfast.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Clase que muestra el banner de inicio de SpeedFast.
 */
public class StartupBanner {
    public static void show() {
        InputStream banner = StartupBanner.class.getResourceAsStream("/banner.txt");
        if (banner != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(banner))) {
                String line;
                while ((line = reader.readLine()) != null)
                    System.out.println(line);
            } catch (IOException e) {
                System.err.println("Error al mostrar el banner: " + e.getMessage());
            }
        }
        System.out.println("==================== Bienvenido a SpeedFast! ====================");
        System.out.println("Realizamos envíos de comida, encomiendas y pedidos express.");
    }
}
