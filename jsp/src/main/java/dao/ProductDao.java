package dao;

import java.util.ArrayList;

import dto.Product;

public class ProductDao extends DB{

	/* 
	  this : 현재클래스 메모리
	  		this.필드명=현재클래스내 필드
	  		외부변수[인수]와 필드명 겹칠경우
	  		this.메소드명= 현재클래스내 메소드
	  super : 상속클래스 메모리
	  		super.필드명 : 부모클래스내 필드
	 		super() : 부모클래스내 생성자
	  		super.메소드명 : 부모클래스 내 메소드에 접근
	*/
	public ProductDao() {
		super(); // DB클래스로부터 상속
	}
	public static ProductDao productDao = new ProductDao();	// dao 객체 생성
	public static ProductDao getproductDao() {return productDao;}
	
	// 제품 등록 메소드
	public boolean productwrite(Product product) {
		String sql="insert into product (p_name,p_price,p_cc,p_fueltype,p_img,p_stock,p_category,p_active,p_contents) values (?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getP_name());
			preparedStatement.setInt(2, product.getP_price());
			preparedStatement.setInt(3, product.getP_cc());
			preparedStatement.setString(4, product.getP_fueltype());
			preparedStatement.setString(5, product.getP_img());
			preparedStatement.setInt(6, product.getP_stock());
			preparedStatement.setString(7, product.getP_category());
			preparedStatement.setInt(8, product.getP_active());
			preparedStatement.setString(9, product.getP_contents());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	}return false;
	}
	// 제품 출력 메소드
	public ArrayList<Product> productlist(String key, String keyword) {
		ArrayList<Product> products = new ArrayList<>();
		String sql = null;
		if(key ==null && keyword ==null) {
			sql ="select * from product";
		}else {
			if(key.equals("p_num")) {
				sql="select * from product where p_num = "+keyword;
			}else {
				sql="select * from product where "+key+" like '%"+keyword+"%'";
			}
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getInt(4),
						resultSet.getString(5),
						resultSet.getString(6), 
						resultSet.getInt(7),
						resultSet.getString(8),
						resultSet.getInt(9),
						resultSet.getString(10),
						resultSet.getString(11));
				products.add(product);
			}
			return products;
		} catch (Exception e) {	} return null;
	}
	// 제품 수정 메소드
	public boolean update(Product product) {
		String sql = "update product set p_name=?, p_price=?, p_cc=? , p_fueltype=?, p_img=? , p_stock=? , p_category=? , p_contents=? where p_num=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getP_name());
			preparedStatement.setInt(2, product.getP_price());
			preparedStatement.setInt(3, product.getP_cc());
			preparedStatement.setString(4, product.getP_fueltype());
			preparedStatement.setString(5, product.getP_img());
			preparedStatement.setInt(6, product.getP_stock());
			preparedStatement.setString(7, product.getP_category());
			preparedStatement.setString(8, product.getP_contents());
			preparedStatement.setInt(9, product.getP_num());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 해당 제품 가져오기
	public Product getproduct(int p_num) {
		String sql = "select * from product where p_num=?";
		try {
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, p_num);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Product product = new Product(resultSet.getInt(1),
											resultSet.getString(2),
											resultSet.getInt(3),
											resultSet.getInt(4),
											resultSet.getString(5),
											resultSet.getString(6),
											resultSet.getInt(7),
											resultSet.getString(8),
											resultSet.getInt(9),
											resultSet.getString(10),
											resultSet.getString(11));
											return product;
			}
		} catch (Exception e) {	} return null;
	}
	// 제품 삭제 메소드
	public boolean delete(int p_num) {
		String sql ="delete from product where p_num=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, p_num);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {	} return false;
	}
	// 제품 상태 변경 메소드
	public boolean activeupdate(int p_num) {
		String sql="select p_active from product where p_num="+p_num;
		try {
			preparedStatement= connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				int p_active = resultSet.getInt(1)+1;
				if( p_active == 4) {p_active =1;}
				sql = "update product set p_active ="+p_active+" where p_num="+p_num;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
				return true;
			}
		} catch (Exception e) {	} return false;
	}
}
