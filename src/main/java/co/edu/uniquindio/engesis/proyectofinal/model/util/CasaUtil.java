package co.edu.uniquindio.engesis.proyectofinal.model.util;

import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.Casa;


import java.util.Optional;
import java.util.function.Predicate;

public class CasaUtil {

    public static Predicate<Casa> buscarPorMaterial(String material){
        return propiedad -> propiedad.getMaterialConstruccion().equals(material);
    }


    public static Predicate<Casa> buscarPorArea(String area){
        return propiedad -> propiedad.getArea().equals(area);
    }

    public static Predicate<Casa> buscarPorDireccion(String direccion){
        return propiedad -> propiedad.getDireccion().equals(direccion);
    }


    public static Predicate<Casa> buscarPorTodoCasas(String material, String area, String direccion) {
        Predicate<Casa> predicado = persona -> true;
        if( material != null && !material.isEmpty() ){
            predicado = predicado.and(buscarPorMaterial(material));
        }
        if( area != null && !area.isEmpty() ){
            predicado = predicado.and(buscarPorArea(area));
        }
        if( direccion != null && !direccion.isEmpty() ){
            predicado = predicado.and(buscarPorDireccion(direccion));
        }

        return predicado;
    }
}
