package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

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
		
		seller = new Seller(null, "Shark", "shark@gmail.com", new Date(), 2500.90, department);
		sellerDao.insert(seller);
		System.out.println("Registro adicionado. " + seller.getId());;
		
	}

}
