package net.tecgurus.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;



import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CatalogoTest {
	
	@Autowired
	private CatalogoDAO dao;

	@Test
	public void loadTest(){
		dao.queryTest();
	}
	
	@Test
	public void testFindAll(){
		List<CatalogoGeneral> list = dao.findAll();
		assertNotNull(list);
	}
	
	@Test
	public void testDscCorta(){
		System.out.println("##################################");
		List<CatalogoGeneral> list = dao.findByDscCrt("DESCRIPCION_BUENO");
		for(CatalogoGeneral c : list){
			System.out.println(c);
		}
		assertNotNull(list);
	}
	
	@Test
	public void testDscCortaComp(){
		System.out.println("##################################");
		List<CatalogoGeneral> list = dao.findByDscCrtAndDscCmp("DESCRIPCION_BUENO","XXX");
		for(CatalogoGeneral c : list){
			System.out.println(c);
		}
		assertNotNull(list);
	}
	
	
}
