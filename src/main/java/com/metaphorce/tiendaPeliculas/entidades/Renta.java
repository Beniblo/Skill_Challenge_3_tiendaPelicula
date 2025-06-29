package com.metaphorce.tiendaPeliculas.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Renta")
public class Renta {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum Estado {
        rentada,
        devuelta
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Renta;

    @ManyToOne
    @JoinColumn(name = "id_Cliente1", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_Pelicula2", nullable = false)
    private Pelicula pelicula;

    private LocalDate fechaRenta;
    private LocalDate fechaDevolucion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Renta() {}

    public Renta(Integer id_Renta, Cliente cliente, Pelicula pelicula, LocalDate fechaRenta, LocalDate fechaDevolucion, Estado estado) {
        this.id_Renta = id_Renta;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaRenta = fechaRenta;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Integer getId_Renta() {
        return id_Renta;
    }

    public void setId_Renta(Integer id_Renta) {
        this.id_Renta = id_Renta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDate getFechaRenta() {
        return fechaRenta;
    }

    public void setFechaRenta(LocalDate fechaRenta) {
        this.fechaRenta = fechaRenta;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

