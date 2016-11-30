//package com.practice.webapp.dao.impl;
//
//import com.pratice.webapp.entity.ShipProduct;
//
//public interface ShipProductDAOBean {
//	
//	ShipProduct temp = new ShipProduct();
//	
////	temp.setId(0);
////	temp.setDesc("iPad");
////	temp.setCategory(1);
////	temp.setInventory(20);
////	temp.setReorderPoint(5);
////	productList.add(temp);
////
//	temp = new Product();
//	temp.setId(1);
//	temp.setDesc("iWatch");
//	temp.setCategory(2);
//	temp.setInventory(4);
//	temp.setReorderPoint(6);
//	productList.add(temp);
//	
//	temp = new Product();
//	temp.setId(2);
//	temp.setDesc("iPhone");
//	temp.setCategory(1);
//	temp.setInventory(6);
//	temp.setReorderPoint(7);
//	productList.add(temp);
//	
//}
//
//public List<ShipProduct> getList(){
//	return ShipProductList;
//}
//public void insert(ShipProduct aProduct){
//	aProduct.setId(ShipProduct.size());
//	ShipProductist.add(aProduct);
//}
//
//public ShipProduct get(long id){
//	return ShipProduct.get((int)id); 
//}
//
//public void update(ShipProduct aProduct){
//	int id = (int)aProduct.getId();
//	ShipProduct.set(id, aProduct);
//}
//
//public void delete(long id){
//	ShipProduct.remove((int)id);
//	// loop through the productList to reset id
//	for (int i = 0; i< productList.size(); i++){
//		productList.get(i).setId(i);
//	}	
//}
//
//public int count(){
//	return productList.size();
//}
//
//
//}//ProductDAOBean
//
