package com.example.veiculos_api_restful.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.veiculos_api_restful.dto.ClienteDTO;
import com.example.veiculos_api_restful.model.Cliente;
import com.example.veiculos_api_restful.service.ClienteService;
import com.example.veiculos_api_restful.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    public ClienteService clienteService;

    @Autowired
    public VeiculoService veiculoService;

    // CREATE

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClienteDTO newCliente, HttpServletRequest request,
            UriComponentsBuilder builder) {

        Cliente cliente = clienteService.save(clienteService.fromDTO(newCliente));
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getIdCliente()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    // READ

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Cliente cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    // UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int id, @RequestBody ClienteDTO clienteDTO) {

        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setIdCliente(id);
        cliente = clienteService.update(cliente);
        return ResponseEntity.ok(cliente);

    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }

    // RESERVAS

    // @GetMapping("/{id}/veiculos")
    // public List<VeiculoDTO> getVeiculosCliente(@PathVariable int id) {
    // Cliente cliente = clienteService.getClienteById(id);
    // return reservaService.ge
    // }

    // @PostMapping("/{idCliente}/veiculos/{idVeiculo}")
    // public ResponseEntity<Void> salvar(@PathVariable int id, @RequestBody Pedido
    // pedido, HttpServletRequest request,
    // UriComponentsBuilder builder) {

    // pedido = pedidoServico.salvar(id, pedido);
    // UriComponents uriComponents = builder.path(request.getRequestURI() + "/" +
    // pedido.getNumero()).build();
    // return ResponseEntity.created(uriComponents.toUri()).build();
    // }

}
