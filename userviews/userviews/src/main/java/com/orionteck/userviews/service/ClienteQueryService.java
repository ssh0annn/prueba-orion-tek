package com.orionteck.userviews.service;

import com.orionteck.userviews.query.ClienteDetalleQuery;
import com.orionteck.userviews.query.ClienteQuery;

import java.util.List;


//Servicios para La logica de lectura
public interface ClienteQueryService {

    //Consulta par obtener un listado mas o menos simple de los clientes
    List<ClienteQuery> listarCliente();
    //Consulta para todos los detalles
    ClienteDetalleQuery obtenerClienteDetalle(Long clienteId);

    //mas metodos de busquedas si fueran ser necesrio por ejemplo cual es la direccion principal, confirmar direciones o cliente

}



