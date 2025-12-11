package com.orionteck.userviews.service;

import com.orionteck.userviews.command.CrearClienteCommand;
import com.orionteck.userviews.command.CrearDireccionesCommnad;
import com.orionteck.userviews.domain.Cliente;
import com.orionteck.userviews.domain.Direccion;
import com.orionteck.userviews.respository.ClienteRepository;
import com.orionteck.userviews.respository.DireccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteCommandServiceImpl implements ClienteCommandService {

    private final ClienteRepository clienteRepository;
    private final DireccionRepository direccionRepository; // <-- Nuevo campo


    public ClienteCommandServiceImpl(
            ClienteRepository clienteRepository,
            DireccionRepository direccionRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.direccionRepository = direccionRepository;
    }

    @Override
    public Long CrearCliente(CrearClienteCommand commnad) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(commnad.name());
        nuevoCliente.setEmail(commnad.email());

        if (commnad.direcciones() != null) {

            // Usamos Strings para mapear la lista de DTOs a la lista de Entidades
            commnad.direcciones().forEach(direccionCommand -> {
                Direccion nuevaDireccion = new Direccion();
                nuevaDireccion.setCalle(direccionCommand.calle());
                nuevaDireccion.setCiudad(direccionCommand.ciudad());
                nuevaDireccion.setPais(direccionCommand.pais());


                nuevaDireccion.setCliente(nuevoCliente);
                nuevoCliente.getDirecciones().add(nuevaDireccion);
            });
        }

        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        return clienteGuardado.getId();
    }

    @Override
    @Transactional
    public Long AgregarDIreccionACLiente(Long clienteId, CrearDireccionesCommnad commnad) {
        Cliente clienteExistente = clienteRepository.findById(clienteId)
                .orElseThrow();

        Direccion nuevaDIreaccion = new Direccion();
        nuevaDIreaccion.setCalle(commnad.calle());
        nuevaDIreaccion.setCiudad(commnad.ciudad());
        nuevaDIreaccion.setPais(commnad.pais());

        nuevaDIreaccion.setCliente(clienteExistente);
        clienteExistente.getDirecciones().add(nuevaDIreaccion);

        clienteRepository.save(clienteExistente);

        Direccion direccionGuardada = direccionRepository.save(nuevaDIreaccion);
        clienteRepository.save(clienteExistente); // Persistimos el cliente para asegurar la bidireccionalidad.

        return direccionGuardada.getId();


    }

    @Override
    public void eliminarCliente(Long clienteId) {
        // 1. Verificar si el cliente existe antes de eliminarlo (buena práctica)
        if (!clienteRepository.existsById(clienteId)) {
            // Lanza una excepción que será manejada por el Controller (Paso 6)
            throw new RuntimeException("Cliente con ID " + clienteId + " no encontrado.");
        }

        // 2. Eliminar. Gracias a CascadeType.ALL, las direcciones se eliminarán también.
        clienteRepository.deleteById(clienteId);

    }
}
