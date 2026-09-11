/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author uriel
 */
public class ComprobarPalindromo {

    public static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "ama";
        boolean esPalindromo = esPalindromo(cadena);
        System.out.println("Cadena: " + cadena);
        System.out.println("¿Es palindromo? " + esPalindromo);
    }

    private static boolean esPalindromo(String cadena) {
        Deque<Character> pila = new ArrayDeque<>();
        for (char c : cadena.toCharArray()) {
            pila.add(c);
        }
        char[] cadenaInvertida = new char[cadena.length()];
        while (!pila.isEmpty()) {
            cadenaInvertida[cadena.length() - pila.size()] = pila.pop();
        }

        String cadenaInvertidaStr = new String(cadenaInvertida);
        System.out.println("Cadena invertida " + cadenaInvertidaStr);

        return (cadena.equals(cadenaInvertidaStr));
    }
}

