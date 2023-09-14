package com.tpJpa.agus;



import com.tpJpa.agus.entidades.*;
import com.tpJpa.agus.enumeraciones.EstadoPedido;
import com.tpJpa.agus.enumeraciones.FormaPago;
import com.tpJpa.agus.enumeraciones.TipoEnvio;
import com.tpJpa.agus.enumeraciones.TipoProducto;
import com.tpJpa.agus.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class AgusApplication {

	@Autowired
	ClienteRepositroy clienteRepositroy;
	@Autowired
	RubroRepository rubroRepository;



	public static void main(String[] args) {
		SpringApplication.run(AgusApplication.class, args);
		System.out.println("Estoy funcionando hoy");

	}

	@Bean
	CommandLineRunner init(ClienteRepositroy clienteRepositroy, RubroRepository rubroRepository){

		return args -> {
			// Crear instancia de Rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Pizzas")
					.build();

			// Crear instancias de Producto
			Producto prod1 = Producto.builder()
					.denominacion("Pizza tropical")
					.tipo(TipoProducto.MANUFACTURDO)
					.precioCompra(1000)
					.precioVenta(1500)
					.receta("rece1")
					.stockActual(20)
					.stockMinimo(8)
					.tiempoEstimadoCocina(30)
					.unidadMedida("uni1")
					.build();

			Producto prod2 = Producto.builder()
					.denominacion("Pizza fugazza")
					.tipo(TipoProducto.MANUFACTURDO)
					.precioCompra(800)
					.precioVenta(1200)
					.stockActual(25)
					.stockMinimo(15)
					.tiempoEstimadoCocina(30)
					.receta("rece2")
					.unidadMedida("uni2")
					.build();

			// agrego los productos al rubro
			rubro1.agregarProductos(prod1);
			rubro1.agregarProductos(prod2);

			//guardo el rubro creado en la base de datos
			rubroRepository.save(rubro1);

			// Creo instancia de Cliente
			Cliente cli1 = Cliente.builder()
					.nombre("Agustina")
					.apellido("Linares")
					.email("agustina.linares0@gmail.com")
					.telefono("283438734")
					.build();

			// Creo instancias de Domicilio
			Domicilio domi1 = Domicilio.builder()
					.calle("Bahía Blanca")
					.numero("469")
					.localidad("Guaymallén")
					.build();

			Domicilio domi2 = Domicilio.builder()
					.calle("Maipú")
					.numero("328")
					.localidad("Godoy Cruz")
					.build();

			// agrego los domicilios creados a la instancia que cree de cliente
			cli1.agregarDomicilio(domi1);
			cli1.agregarDomicilio(domi2);

			// creo fechas para guardarlas en los pedidos
			LocalDate fh1 = LocalDate.of(2023, 5, 28);
			LocalDate fh2 = LocalDate.of(2023, 8, 10);

			// creo instancias de DetallePedido
			DetallePedido det1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1200)
					.build();

			DetallePedido det2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1500)
					.build();

			DetallePedido det3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1500)
					.build();

			//guardo los productos del detalle prodcuto creado
			det1.setProducto(prod2);
			det2.setProducto(prod1);
			det3.setProducto(prod1);

			// creo instancias de Pedido que realiza el cliente
			Pedido pedi1 = Pedido.builder()
					.total(2700)
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();

			Pedido pedi2 = Pedido.builder()
					.total(1500)
					.estado(EstadoPedido.ENTREGADO)
					.tipoEnvio(TipoEnvio.RETIRA)
					.build();

			// agrego los pedidos que realiza el cliente
			cli1.agregarPedidos(pedi1);
			cli1.agregarPedidos(pedi2);



			// guardo las intancias de DetallePedido en la instancia de Pedido
			pedi1.agregarDetPedidos(det1);
			pedi1.agregarDetPedidos(det2);
			pedi2.agregarDetPedidos(det3);


			// creo las intancias de factura correspondientes a los pedidos creados
			Factura fac1 = Factura.builder()
					.total(2700)
					.numero(4374)
					.descuento(5)
					.formaPago(FormaPago.ETC)
					.build();

			Factura fac2 = Factura.builder()
					.total(1500)
					.numero(4232)
					.descuento(10)
					.formaPago(FormaPago.EFECTIVO)
					.build();


			// guardo la fecha en el pedido creado
			pedi1.setFecha(fh1);
			pedi2.setFecha(fh2);

			// guardo las facturas en los pedidos creados
			pedi1.setFactura(fac1);
			pedi2.setFactura(fac2);


			// guardo el cliente creado y el rubro creado en la base de datos
			clienteRepositroy.save(cli1);



			Cliente clienteRecuperado = clienteRepositroy.findById(cli1.getId()).orElse(null);
				if (clienteRecuperado != null){
					System.out.println("Nombre: "+clienteRecuperado.getNombre()+", Apellido: "+clienteRecuperado.getApellido()+
							", Mail: "+clienteRecuperado.getEmail()+", Teléfono: "+clienteRecuperado.getTelefono()+" ");
					clienteRecuperado.mostrarDomicilios();
				}






















		};











	}
}
