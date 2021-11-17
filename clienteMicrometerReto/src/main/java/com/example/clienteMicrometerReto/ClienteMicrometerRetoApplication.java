package com.example.clienteMicrometerReto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.clienteMicrometerReto.models.Cliente;
import com.example.clienteMicrometerReto.service.ClienteService;

@SpringBootApplication
public class ClienteMicrometerRetoApplication implements CommandLineRunner{
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ClienteMicrometerRetoApplication.class, args);
	}


	ClienteService clienteService = new ClienteService();
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String state = "close";
		Cliente cliente1 = new Cliente("Baldomero", state);
		try {
			/*PATRON :CIRCUIT-BREAKER*/
			for (int i = 0; i < 5; i++) {
				cliente1.setStatus("open");
				clienteService.setToOpen();
				Thread.sleep(1000);
				if (cliente1.getStatus().equals("half-open")) {
					cliente1.setStatus("close");
					clienteService.setToClose();
				}else {
					cliente1.setStatus("half-open");
					clienteService.setToHalfOpen();
				}
			}
		} catch (Exception e) {
			System.out.println("Error en la ejecución del hilo");
		}
	}

}
