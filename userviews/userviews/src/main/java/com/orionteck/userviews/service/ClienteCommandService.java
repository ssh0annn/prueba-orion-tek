package com.orionteck.userviews.service;

import com.orionteck.userviews.command.CrearClienteCommand;
import com.orionteck.userviews.command.CrearDireccionesCommnad;


//Interfaz para logica de escritura
public interface ClienteCommandService {

    //Crear Un cliente
    Long CrearCliente(CrearClienteCommand commnad);

    //Agregar una direccion a un clietne
    Long AgregarDIreccionACLiente(Long clienteId, CrearDireccionesCommnad commnad);


    void eliminarCliente(Long clienteId);

    //Otro mas pueden ser ActualizarCliente(), actualizarDireccio().

}
