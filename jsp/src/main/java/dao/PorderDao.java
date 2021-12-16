package dao;

import java.util.ArrayList;

import dto.Cart;
import dto.Porder;

public class PorderDao extends DB{

	public PorderDao() {
		super();
	}
	public static PorderDao porderDao = new PorderDao();
	public static PorderDao getPorderDao() {return porderDao;}
	
	// 1. 주문등록
	public boolean orderwrite(Porder porder,ArrayList<Cart> carts) {
		String sql ="insert into porder (m_num,order_name,order_phone,order_address,order_pay,order_payment,delivery_pay,order_contents)values(?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, porder.getM_num());
			preparedStatement.setString(2, porder.getOrder_name());
			preparedStatement.setString(3, porder.getOrder_phone());
			preparedStatement.setString(4, porder.getOrder_address());
			preparedStatement.setInt(5, porder.getOrder_pay());
			preparedStatement.setString(6, porder.getOrder_payment());
			preparedStatement.setInt(7, porder.getDelivery_pay());
			preparedStatement.setString(8, porder.getOrder_contents());
			preparedStatement.executeUpdate();
			
			sql="select * from porder where m_num="+porder.getM_num()+" order by order_num desc";
			preparedStatement=connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				// 1.주문번호
				int order_num = resultSet.getInt(1);
				for(Cart cart : carts) {
					// 2.주문상세등록
					sql="insert into porderdetail (order_num,p_num,p_count,delivery_state) values(?,?,?,?)";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, order_num);
					preparedStatement.setInt(2, cart.getP_num());
					preparedStatement.setInt(3, cart.getP_count());
					preparedStatement.setInt(4, 1);
					preparedStatement.executeUpdate();
				}
			}
			return true;
						
		} catch (Exception e) {	} return false;
	}
	// 2. 주문상세등록
	
	
}
