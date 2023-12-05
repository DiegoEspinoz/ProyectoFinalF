package Model;

import java.util.Date;

public class Usuario {

    private String nombre;

   
    private String apellido;
    private int edad;
    private double talla;
    private double peso;
    private int tipoPlan;
    private int frecuenciaEjercicio;
    private Date fechaIngreso;
    private Date fechaExpiracion;

    // Constructores

    public Usuario() {
        // Constructor por defecto
    }

    //Constructor completo
    public Usuario(String nombre, int edad, double talla, double peso, int tipoPlan, int frecuenciaEjercicio,
                   Date fechaIngreso, Date fechaExpiracion) {
        this.nombre = nombre;
        this.edad = edad;
        this.talla = talla;
        this.peso = peso;
        this.tipoPlan = tipoPlan;
        this.frecuenciaEjercicio = frecuenciaEjercicio;
        this.fechaIngreso = fechaIngreso;
        this.fechaExpiracion = fechaExpiracion;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public double getTalla() {
        return talla;
    }

    public double getPeso() {
        return peso;
    }

    public int getTipoPlan() {
        return tipoPlan;
    }

    public int getFrecuenciaEjercicio() {
        return frecuenciaEjercicio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTipoPlan(int tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public void setFrecuenciaEjercicio(int frecuenciaEjercicio) {
        this.frecuenciaEjercicio = frecuenciaEjercicio;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    // Otro código relacionado con la clase Usuario

    @Override
    public String toString() {
        // Implementación del método toString si es necesario
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", talla=" + talla +
                ", peso=" + peso +
                ", tipoPlan=" + tipoPlan +
                ", frecuenciaEjercicio=" + frecuenciaEjercicio +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaExpiracion=" + fechaExpiracion +
                '}';
    }

    // Otros métodos relacionados con la clase Usuario

}
