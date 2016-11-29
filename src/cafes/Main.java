package cafes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Scanner sn = new Scanner(System.in);
		
		CafesDB cf = new CafesDB();
		
		int opcion = 0;
		
		do{
		
		System.out.println("------------------------------");
		System.out.println("1- Anadir nuevo cafe");
		System.out.println("2- Borrar cafe");
		System.out.println("3- Mostrar cafe");
		System.out.println("4- Buscar cafe");
		System.out.println("5- Actualizar cafe");
		System.out.println("6- Salir");
		System.out.println("------------------------------");
		
		System.out.println("Introduzca una opcion:");
		opcion = sn.nextInt();
		
		switch(opcion){
		
		case 1: // añade nuevo cafe
			
			String nombrecafe;
			int id , ventas , total;
			float precio;
			Scanner nr = new Scanner(System.in);
			System.out.println("nombre del cafe");
			nombrecafe = nr.nextLine();
			System.out.println("id del cafe");
			id = nr.nextInt();
			System.out.println("precio del cafe");
			precio = nr.nextFloat();
			System.out.println("ventas del cafe");
			ventas = nr.nextInt();
			System.out.println("total del cafe");
			total = nr.nextInt();
			Cafes cafe = new Cafes(nombrecafe,id,precio,ventas,total);
			String salidacafe = cf.NuevoCafe(cafe);
			System.out.println(salidacafe); 
			break;
			
		case 2: // borrar cafe
			
			String dlcafe;
			Scanner sbc = new Scanner(System.in);
			System.out.println("Introduce el nombre del cafe:");
			dlcafe = sbc.nextLine();
			String salidaborrar = cf.BorrarCafe(dlcafe);
			System.out.println(salidaborrar);
			break;
			
		case 3: // mostrar lista de cafes
			
			ArrayList<Cafes> ca = new ArrayList<Cafes>();
			try {
				ca = cf.MostrarTodos();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for(Cafes item:ca){
				System.out.println(item.getCafe_nombre());
				System.out.println(item.getProv_id());
				System.out.println(item.getPrecio());
				System.out.println(item.getTotal());
				System.out.println(item.getVentas());
			}
			break;
			
		case 4: // buscar cafe
			
			Scanner bc = new Scanner(System.in);
			String nomcafe;
			System.out.println("Introduce el nombre del cafe:");
			nomcafe = bc.nextLine();
			Cafes buscarcafe = new Cafes();
			try {
				buscarcafe = cf.MostrarCafe(nomcafe);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(buscarcafe);
			break;
			
		case 5: // actualizar cafe
			
			Scanner ac = new Scanner(System.in);
			String nombre;
			Double acventas;
			System.out.println("Introduce el nombre del cafe:");
			nombre = ac.nextLine();
			System.out.println("Introduce las ventas a actualizar:");
			acventas = ac.nextDouble();
			String salida = cf.ActualizarCafe(nombre, acventas);
			System.out.println(salida);
			break;
		}// Fin switch
		}while(opcion != 6);
	}
}