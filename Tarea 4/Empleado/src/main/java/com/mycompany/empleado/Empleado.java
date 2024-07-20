// Elabarado por: Wilson Ricardo Flores Juarez
// cuenta: 202230120066
package com.mycompany.empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleado {

    // Atributos privados para aplicar el encapsulamiento
    private String nombre;
    private int edad;
    private double salario;

    // Constructor para inicializar los atributos de un empleado
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Metodos publicos para obtener y establecer los atributos, garantizando el acceso controlado
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Metodo para imprimir la informacion del empleado
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario: " + salario);
    }

    // Clase GestorEmpleados
    public static class GestorEmpleados {

        private final List<Empleado> empleados;

        // Constructor para inicializar la lista de empleados
        public GestorEmpleados() {
            this.empleados = new ArrayList<>();
            // Agregar 5 empleados por defecto
            empleados.add(new Empleado("Juan Perez", 30, 1500.00));
            empleados.add(new Empleado("Ana Lopez", 25, 1200.00));
            empleados.add(new Empleado("Carlos Martinez", 40, 2000.00));
            empleados.add(new Empleado("Lucia Gomez", 35, 1800.00));
            empleados.add(new Empleado("Miguel Torres", 28, 1600.00));
        }

        // Metodo para agregar un empleado a la lista
        public void agregarEmpleado(Empleado empleado) {
            empleados.add(empleado);
        }

        // Metodo para mostrar los detalles de todos los empleados
        public void mostrarEmpleados() {
            if (empleados.isEmpty()) {
                System.out.println("No hay empleados registrados.");
                return;
            }

            System.out.println("Lista de empleados:");
            for (Empleado empleado : empleados) {
                empleado.imprimirInformacion();
                System.out.println("------------------");
            }
        }
    }

    // Clase Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestorEmpleados = new GestorEmpleados();

        while (true) {
            System.out.println("Seleccione La Opccion Deseada:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad del empleado: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 

                    Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                    gestorEmpleados.agregarEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado exitosamente.");
                    break;
                case 2:
                    gestorEmpleados.mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        }
    }
}