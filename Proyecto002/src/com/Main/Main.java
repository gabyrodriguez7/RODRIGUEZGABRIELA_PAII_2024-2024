package com.Main;

import javax.swing.SwingUtilities;

/**
 * @author: Gabriela Lissette Rodriguez Contreras
 * Tema: Galaga con ID
 */
public class Main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }

}
