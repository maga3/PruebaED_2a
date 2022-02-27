package com.iescomercio.ed.bloque2.repaso.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private List<Persona> listaAlumnos;

	/**
	 * This method deletes an alumn based on their dni, if the dni is not correct it
	 * throws an exception
	 * 
	 * @author Martin Ruiz
	 * @param Dni an id for each people, string 8 numbers and a letter at the end.
	 * @throws Exception, when dni length is not 9.
	 * @version 1.0
	 */
	public void eliminarAlumno(String dni) throws Exception {
		if (dni.length() == 9) {// comprobar la longitud del dni
			listaAlumnos.remove(new Persona(dni, "", "")); // solo hace falta el dni
		} else {
			throw new Exception("El dni no tiene la longitud adecuada");
		}
	}

	/**
	 * This method adds an alumn.
	 * 
	 * @author Martin Ruiz
	 * @param Persona p, from class Persona.
	 * @see Persona
	 * @version 1.0
	 */
	public void aniadirAlumno(Persona p) {
		listaAlumnos.add(p);
	}

	/**
	 * This method checks if an alumn is already registered in the list of alumns.
	 * 
	 * @author Martin Ruiz
	 * @param dni
	 * @return True if exists in the alumn list, false otherwise.
	 */
	public Boolean estaRegistrado(String dni) {
		int i = 0;
		Boolean encontrado = false;
		while (!encontrado && i < listaAlumnos.size()) {
			if (listaAlumnos.get(i).getDni().equals(dni)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	/**
	 * Constructor for class Curso, it initializes listaAlumnos list of class Persona.
	 * @see Persona
	 */
	public Curso() {
		listaAlumnos = new ArrayList<Persona>();
	}

	/**
	 * This method counts as Integer type for the number of alumns in the list.
	 * @return Integer, total number of alumns in the list.
	 */
	public Integer numeroAlumnos() {
		return listaAlumnos.size();
	}

	public void mostrarTodos() {
		for (Persona persona : listaAlumnos) {
			System.out.println(persona);
		}
	}
}
