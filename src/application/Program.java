package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("-- Find ById      --");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("--FindByDepartment--");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("--    FindAll    --");

		List<Seller> list1 = sellerDao.findAll();
		list1.forEach(System.out::println);
		

		System.out.println("--    Insert    --");
		
		Seller newSeller = new Seller(null, "Shark4", "shark@gmail.com", new Date(), 2500.90, department);
		sellerDao.insert(newSeller);
		System.out.println("Registro adicionado. " + newSeller.getId());;
		
		System.out.println("--    Update    --");
		seller = sellerDao.findById(1);
		seller.setName("Babi");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("--    Delete    --");
		
		System.out.print("Informe o Id a ser excluido: ");
		int id = sc.nextInt(); 
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
