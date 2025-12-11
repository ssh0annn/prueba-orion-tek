package com.orionteck.userviews.service;

import com.orionteck.userviews.domain.Cliente;
import com.orionteck.userviews.query.ClienteDetalleQuery;
import com.orionteck.userviews.query.ClienteQuery;
import com.orionteck.userviews.query.DireccionQuery;
import com.orionteck.userviews.respository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClienteQueryImpl implements ClienteQueryService{
    private final ClienteRepository clienteRepository;

    public ClienteQueryImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public List<ClienteQuery> listarCliente() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(
                        cliente -> new ClienteQuery(
                               cliente.getId(),
                               cliente.getNombre(),
                               cliente.getEmail()
                        )
                ).collect(Collectors.toList());
    }

    @Override
    public ClienteDetalleQuery obtenerClienteDetalle(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow();

        List<DireccionQuery> direccionQueries = cliente.getDirecciones().stream()
                .map(direccion -> new DireccionQuery(
                        direccion.getId(),
                        direccion.getCalle(),
                        direccion.getCiudad(),
                        direccion.getPais()
                        )

                ).collect(Collectors.toList());

        return new ClienteDetalleQuery(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                direccionQueries
        );
    }
}
