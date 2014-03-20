package com.terasoft.myprayer.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.terasoft.myprayer.repository.PedidoRepository;

@ContextConfiguration(locations = {"classpath:test-application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPedidoRepository {
	
	private static Log logger = LogFactory.getLog("TestPedidoRepository");

	@Autowired
	public PedidoRepository pedidoRepository;
	
	@Test
	@Transactional
	public void test() {
		logger.info("Inicio de Test ======================");
		
		assertEquals(new Long(0), pedidoRepository.count());
		
		logger.info("Fin de Test    ======================");
	}
	
}
