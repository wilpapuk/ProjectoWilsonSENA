package com.terasoft.myprayer.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.terasoft.myprayer.repository.Pedido;
import com.terasoft.myprayer.service.PedidoService;

@ContextConfiguration(locations = {"classpath:test-application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPedidoService {
	
	private static Log logger = LogFactory.getLog("TestPedidoService");
	
	@Autowired
	private PedidoService pedidoService;
	
	@Test
	@Transactional
	public void testPedido() {
		logger.info("Inicio de Test ======================");
		
		//assertEquals(new Long(0), pedidoService.contar());
		
		Pedido pedido = new Pedido();
		pedido.setPedifech(new java.util.Date());
		pedido.setPedinomb("HOGLY RUBIO");
		pedido.setPeditext("oren por mi!");
		pedido.setPedisexo("M");
		pedidoService.agregar(pedido);
		logger.info("agregado: " + pedido);
		//assertEquals(new Long(1), pedidoService.contar());
		
		logger.info("Fin de Test    ======================");
	}
	
	@Test
	@Transactional
	public void testResumen() {
		logger.info("Inicio de Test ======================");
		
		List<Object[]> listSexo = pedidoService.contarPorSexo();
		for (Object[] reg : listSexo) {
			logger.info("Sexo: " + reg[0] + "=" + reg[1]);
		}
		
		List<Object[]> listMotivo = pedidoService.contarPorMotivo();
		for (Object[] reg : listMotivo) {
			logger.info("Motivo: " + reg[0] + "=" + reg[1]);
		}
		
		logger.info("Fin de Test    ======================");
	}

}
