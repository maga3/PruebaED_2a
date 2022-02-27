package com.iescomercio.ed.bloque2.repaso.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {


	private Curso c;
	
	@BeforeEach
	void BeforeEach() {
		c=new Curso();
		c.aniadirAlumno(new Persona("71349725E", "martin", "Ruiz"));
		c.aniadirAlumno(new Persona("71349725A", "asa", "rocky"));
		c.aniadirAlumno(new Persona("71349725A", "asap", "roty"));
	}

	
	@Test
	void testEliminarAlumno() {
		
		try {
			int numBefore = c.numeroAlumnos();
			c.eliminarAlumno("71349725E");
			int numAfter = c.numeroAlumnos();
			
			assertEquals(numBefore -1, numAfter);			
		} catch (Exception e) {
			assertThrows(Exception.class, () -> c.eliminarAlumno("71349725E"), e.getMessage());		}
	}
	
	@Test
	void testAniadirAlumno() throws Exception {
		int antesDeCambiar = c.numeroAlumnos();
		c.aniadirAlumno(new Persona("71349725E", "martin", "Ruiz"));
		assertEquals(antesDeCambiar+1, c.numeroAlumnos());
		c.aniadirAlumno(new Persona("71349745E", "m1artin", "Ruiz"));
		assertEquals(antesDeCambiar+2, c.numeroAlumnos());
	}
	
	@Test
	void testEstaRegistrado() {
		assertTrue(c.estaRegistrado("71349725E"));
		assertTrue(c.estaRegistrado("71349725A"));
		assertFalse(c.estaRegistrado("71349752S"));
		assertFalse(c.estaRegistrado("71349752M"));
	}
	@Test
	void testCurso() {
		Curso c1 = new Curso();
		assertEquals(0, c1.numeroAlumnos());
	}
}
