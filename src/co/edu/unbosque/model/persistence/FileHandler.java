package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	public static File archivo;

	// texto
	public static PrintWriter escritor;
	public static Scanner lector;

	// Serializado
	public static FileInputStream fis;
	public static ObjectInputStream ois;

	public static FileOutputStream fos;
	public static ObjectOutputStream oos;

	public static void escribirEnArchivoDeTexto(String url, String contenido) {

		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al crear y escribir el archivo de texto");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

	}

	public static String leerDesdeArchivoDeTexto(String url) {

		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);
			String contenido = "";
			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al leer el archivo de texto");
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return null;

	}

	// Serializado
	public static void escribirEnArchivoSerializado(String url, Object contenido) {

		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
