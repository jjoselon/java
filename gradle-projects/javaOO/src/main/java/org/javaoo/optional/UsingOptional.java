package org.javaoo.optional;

import java.util.List;
import java.util.Optional;

public class UsingOptional {

    class Empresa {
        public int id;
        public String nombre;
        public List<Cliente> clientes = null;

        public void setClientes(List<Cliente> clientes) {
            this.clientes = clientes;
        }

        public Optional<List<Cliente>> getClientes() {

            return Optional.ofNullable(clientes);
        }
    }

    class Cliente {
        public String nombre;
        public Cliente(String nombre) {
            this.nombre = nombre;
        }
    }


    public void print() {
        Empresa empresa1 = new Empresa();
        empresa1.setClientes(List.of(new Cliente("Microsoft"), new Cliente("Software Engineering")));
        Optional<List<Cliente>> clients = empresa1.getClientes()
                .map(clientes -> clientes.stream()
                        .filter(cliente -> cliente.nombre.equals("Microsoft"))
                        .toList()
                );
        System.out.println(clients.get());
    }
}
