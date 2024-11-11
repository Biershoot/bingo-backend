package com.example.backend.models;

import java.util.ArrayList;
import java.util.List;

public class Tarjeton {
    private List<Integer> columnaB;
    private List<Integer> columnaI;
    private List<Integer> columnaN;
    private List<Integer> columnaG;
    private List<Integer> columnaO;
    private List<Boolean> marcados;  // Lista para saber si las casillas están marcadas

    public Tarjeton() {
        this.columnaB = new ArrayList<>();
        this.columnaI = new ArrayList<>();
        this.columnaN = new ArrayList<>();
        this.columnaG = new ArrayList<>();
        this.columnaO = new ArrayList<>();
        this.marcados = new ArrayList<>(25); // 25 casillas, inicializadas en 'false'
        for (int i = 0; i < 25; i++) {
            marcados.add(false); // Inicialmente, todas las casillas están sin marcar
        }
    }

    // Métodos para obtener las columnas
    public List<Integer> getColumnaB() { return columnaB; }
    public void setColumnaB(List<Integer> columnaB) { this.columnaB = columnaB; }

    public List<Integer> getColumnaI() { return columnaI; }
    public void setColumnaI(List<Integer> columnaI) { this.columnaI = columnaI; }

    public List<Integer> getColumnaN() { return columnaN; }
    public void setColumnaN(List<Integer> columnaN) { this.columnaN = columnaN; }

    public List<Integer> getColumnaG() { return columnaG; }
    public void setColumnaG(List<Integer> columnaG) { this.columnaG = columnaG; }

    public List<Integer> getColumnaO() { return columnaO; }
    public void setColumnaO(List<Integer> columnaO) { this.columnaO = columnaO; }

    public List<Boolean> getMarcados() { return marcados; }

    // Marcar un número en el tarjetón
    public void marcarNumero(int numero) {
        // Buscar el número en el tarjetón y marcarlo
        List<List<Integer>> columnas = List.of(columnaB, columnaI, columnaN, columnaG, columnaO);
        for (int i = 0; i < columnas.size(); i++) {
            List<Integer> columna = columnas.get(i);
            for (int j = 0; j < columna.size(); j++) {
                if (columna.get(j) == numero) {
                    marcados.set(i * 5 + j, true);  // Marcamos la casilla
                    return;
                }
            }
        }
    }

    // Verificar si el jugador ha ganado
    public boolean verificarGanador() {
        // Verificar filas
        for (int i = 0; i < 5; i++) {
            if (verificarLinea(i * 5)) return true;  // Verificar fila i
        }

        // Verificar columnas
        for (int i = 0; i < 5; i++) {
            if (verificarColumna(i)) return true;  // Verificar columna i
        }

        // Verificar diagonales
        if (verificarDiagonalPrincipal() || verificarDiagonalSecundaria()) {
            return true;
        }

        return false;
    }

    // Verificar si todas las casillas de una fila están marcadas
    private boolean verificarLinea(int inicio) {
        for (int i = 0; i < 5; i++) {
            if (!marcados.get(inicio + i)) {
                return false;
            }
        }
        return true;
    }

    // Verificar si todas las casillas de una columna están marcadas
    private boolean verificarColumna(int columna) {
        for (int i = 0; i < 5; i++) {
            if (!marcados.get(i * 5 + columna)) {
                return false;
            }
        }
        return true;
    }

    // Verificar la diagonal principal
    private boolean verificarDiagonalPrincipal() {
        for (int i = 0; i < 5; i++) {
            if (!marcados.get(i * 5 + i)) {
                return false;
            }
        }
        return true;
    }

    // Verificar la diagonal secundaria
    private boolean verificarDiagonalSecundaria() {
        for (int i = 0; i < 5; i++) {
            if (!marcados.get(i * 5 + (4 - i))) {
                return false;
            }
        }
        return true;
    }
}

