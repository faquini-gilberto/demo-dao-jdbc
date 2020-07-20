package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.print("Informe o Departamento a ser pesquisado: ");
		int id = sc.nextInt();
		Department dep = departmentDao.findById(id);
		System.out.println("Teste 1 --- findById");
		System.out.println(dep);
		
		System.out.println("Teste 2 --- listAll");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
			
		System.out.println("Teste 3 --- Insert");
		System.out.print("Nome do novo Departamento: ");
		String name = sc.next();
		Department newDepartment = new Department(null, name);
		departmentDao.insert(newDepartment);
		int id1 = newDepartment.getId();
		System.out.println("Registro adicionado com Id " + id1);
		
		System.out.println("Teste 4 --- Update");
		System.out.print("Informe o Departamento a ser alterado: ");
		id = sc.nextInt();
		dep = departmentDao.findById(id);
		System.out.print("Novo Nome do Departamento: ");
		dep.setName(sc.next());
		departmentDao.update(dep);
		System.out.println("Registro alterado.");
		
		System.out.println("Teste 5 --- Delete");
		System.out.print("Informe o Departamento a ser eliminado: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Registro eliminado.");
		
		
		sc.close();

	}

}
