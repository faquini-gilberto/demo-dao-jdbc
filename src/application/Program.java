package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Teste");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = new Seller(23, "Gilberto", "giba@gmail", new Date(), 3000.0, obj);
		System.out.println(seller);

	}

}
