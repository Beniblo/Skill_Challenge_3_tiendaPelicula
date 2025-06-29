package com.metaphorce.tiendaPeliculas.entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "Pelicula")
public class Pelicula   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Pelicula;
    private String tituloPelicula;
    private String generoPelicula;
    private int anioEstreno;
    private int duracionPelicula;
    private String clasificacionPelicula;

    public Pelicula(Integer id_Pelicula, String tituloPelicula, String generoPelicula, int anioEstreno, int duracionPelicula, String clasificacionPelicula) {
        this.id_Pelicula = id_Pelicula;
        this.tituloPelicula = tituloPelicula;
        this.generoPelicula = generoPelicula;
        this.anioEstreno = anioEstreno;
        this.duracionPelicula = duracionPelicula;
        this.clasificacionPelicula = clasificacionPelicula;
    }

    public Pelicula() {
    }

    public Integer getId_Pelicula() {
        return id_Pelicula;
    }

    public void setId_Pelicula(Integer id_Pelicula) {
        this.id_Pelicula = id_Pelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public String getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public String getClasificacionPelicula() {
        return clasificacionPelicula;
    }

    public void setClasificacionPelicula(String clasificacionPelicula) {
        this.clasificacionPelicula = clasificacionPelicula;
    }
}
