package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONObject;

import dto.Cart;
import dto.Porder;
import dto.Porderdetail;

public class PorderDao extends DB{

	public PorderDao() {
		super();
	}
	public static PorderDao porderDao = new PorderDao();
	public static PorderDao getPorderDao() {return porderDao;}
	
	// 1. 주문등록 [1.주문등록 2.세부주문 등록 3. 재고 업데이트] 
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
					
					// 3. 재고 업데이트처리
					sql ="update product set p_stock = p_stock - ? where p_num=?";
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, cart.getP_count());
					preparedStatement.setInt(2, cart.getP_num());
					preparedStatement.executeUpdate();
				}
			}
			return true;
		} catch (Exception e) {	} return false;
	}
	// 2. 주문목록 빼오기
	public ArrayList<Porder> getporderlist(int m_num){
		ArrayList<Porder> porders = new ArrayList<Porder>();
		String slq ="select * from porder where m_num=? order by order_num desc";
		try {
			preparedStatement = connection.prepareStatement(slq);
			preparedStatement.setInt(1, m_num);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Porder porder = new Porder(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getString(8),
						resultSet.getInt(9),
						resultSet.getInt(10),
						resultSet.getString(11));
						porders.add(porder);
			} return porders;
		} catch (Exception e) {	} return null;
	}
	// 상세보기
	public ArrayList<Porderdetail> getporderdetaillist(int order_num){
		ArrayList<Porderdetail> porderdetails = new ArrayList<>();
		String sql ="select * from porderdetail where order_num=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, order_num);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Porderdetail porderdetail = new Porderdetail(
							resultSet.getInt(1),
							resultSet.getInt(2),
							resultSet.getInt(3),
							resultSet.getInt(4),
							resultSet.getInt(5));
				porderdetails.add(porderdetail);
			} return porderdetails;
		} catch (Exception e) {	} return null;
	}
	// 날짜별 주문수
	public JSONObject getorderdatecount(){
		JSONObject jsonObject = new JSONObject();
		String sql = "select substring_index(order_date,' ',1) ,count(*) from porder group by substring_index(order_date,' ',1)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				jsonObject.put(resultSet.getString(1), resultSet.getInt(2));
			}
			return jsonObject;
		} catch (Exception e) {	} return null;
	}
	// 제품별 주문수
	public JSONObject getcount() {
		JSONObject jsonObject = new JSONObject();
		String sql = "select p_num,sum(p_count) from porderdetail group by p_num";
		try {
			preparedStatement =connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				sql = "select p_name from product where p_num="+resultSet.getInt(1);
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				if(resultSet2.next()) {
					jsonObject.put(resultSet2.getString(1),resultSet.getInt(2));
				}
			}
			return jsonObject;
		} catch (Exception e) {	} return null; 
	}
	// 제품 별 날짜 주문수
	public JSONObject datecount(int p_num) {
		JSONObject jsonObject = new JSONObject();
		String sql = "select order_num,p_count from porderdetail where p_num="+p_num;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				sql="select substring_index(order_date,' ',1) from porder where order_num="+resultSet.getInt(1);
				PreparedStatement preparedStatement3 = connection.prepareStatement(sql);
				ResultSet resultSet3 = preparedStatement3.executeQuery();
				if(resultSet3.next()) {
					jsonObject.put(resultSet3.getString(1),resultSet.getInt(2));
				}
			} return jsonObject;
		} catch (Exception e) {	} return null;
		
	}
	
}
