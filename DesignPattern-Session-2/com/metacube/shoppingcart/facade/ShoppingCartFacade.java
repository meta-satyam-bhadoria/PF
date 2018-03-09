package com.metacube.shoppingcart.facade;

import java.util.Map;

import com.metacube.shoppingcart.dao.BaseDao;
import com.metacube.shoppingcart.dao.InMemoryShoppingCartDao;
import com.metacube.shoppingcart.dao.ShoppingCartDao;
import com.metacube.shoppingcart.dao.ShoppingCartDaoFactory;
import com.metacube.shoppingcart.entity.Product;
import com.metacube.shoppingcart.entity.ShoppingCart;
import com.metacube.shoppingcart.enumm.DatabaseEnum;

/**
 * This class gets the data from controller and perform some operation and pass to the dao layer.
 * @author Satyam Bhadoria
 *
 */
public class ShoppingCartFacade {
	private static ShoppingCartFacade shoppingCartFacade;
	private BaseDao<ShoppingCart> shoppingCartDao = (InMemoryShoppingCartDao) ShoppingCartDaoFactory.getInstance(DatabaseEnum.in_memory);
	
	/**
	 * private constructor to restrict creating new objects.
	 */
	private ShoppingCartFacade() {}
	
	/**
	 * Method which returns already created object of this class
	 * @return - object of this class
	 */
	public static ShoppingCartFacade getInstance() {
		
		if(shoppingCartFacade == null){
			shoppingCartFacade = new ShoppingCartFacade();
		}
		return shoppingCartFacade;
	}
	
	/**
	 * Method which send command to dao to add product item after calculating required entities.
	 * @param userId - id of user
	 * @param productId - id of product
	 * @param quantity - quantity of product
	 */
	public void addItem(String userId, String productId, int quantity ) {
		
		/*check for product id is valid or not*/
		if (ProductFacade.getInstance().searchProduct(productId)){

			/*check for quantity ordered is sufficient to provide or not*/
			if (ProductFacade.getInstance().getProduct(productId).getStock() >= quantity){
				ShoppingCart cart = ((InMemoryShoppingCartDao) shoppingCartDao).returnCart(userId);
				ProductFacade.getInstance().getProduct(productId).setStock(quantity);
				
				/*update quantity of product in cart if product already exist*/
				if(searchInShoppingCart(productId, userId)){
					quantity = cart.getQuantity(ProductFacade.getInstance().getProduct(productId)) + quantity;
				}
				
				float subTotal = ProductFacade.getInstance().getProduct(productId).getPrice() * quantity;
				((InMemoryShoppingCartDao) shoppingCartDao).addItem(userId, ProductFacade.getInstance().getProduct(productId), quantity, subTotal);
				
				float total = 0;
				
				/*update total price of products available in cart*/
				for(Map.Entry<Product, Float> p: cart.getProductSubTotal().entrySet()){
					total += p.getValue();
				}
				
				((InMemoryShoppingCartDao) shoppingCartDao).updateTotal(total, userId);
				
			} else{
				System.out.println("not suffi quant");
			}
		} else{
			System.out.println("product not found in shop facade");
		}
	}
	
	/**
	 * Method which create cart for user
	 * @param userId - id of user
	 * @param cart - cart object
	 */
	public void createCart(String userId, ShoppingCart cart) {
		((ShoppingCartDao) shoppingCartDao).createCart(userId, cart);
	}
	
	/**
	 * Method which remove product from cart
	 * @param productId - id of product
	 * @param userId - id of user
	 */
	public void removeItem(String productId, String userId) {
		
		/*check for product id is valid or not*/
		if(searchInShoppingCart(productId, userId)){
			
			((ShoppingCartDao) shoppingCartDao).removeItem(ProductFacade.getInstance().getProduct(productId), userId);
			
			float total = 0;
			
			/*update total price of products available in cart*/
			for(Map.Entry<Product, Float> p: ((InMemoryShoppingCartDao) shoppingCartDao).returnCart(userId).getProductSubTotal().entrySet()){
				total += p.getValue();
			}
			((InMemoryShoppingCartDao) shoppingCartDao).updateTotal(total, userId);
		}
	}
	
	/**
	 * Method which search for existing product in cart
	 * @param productId - id of product
	 * @param userId - id of user
	 * @return true or false
	 */
	private boolean searchInShoppingCart(String productId, String userId){
		Product item = ProductFacade.getInstance().getProduct(productId);
		
		if(item != null) {
				return ((InMemoryShoppingCartDao) shoppingCartDao).returnCart(userId).getProductQuantity().containsKey(item);
		}
		return false;
	}
	
	/**
	 * Method which return the cart object of user 
	 * @param userId - id of user
	 * @return - cart object
	 */
	public ShoppingCart getCart(String userId){
		return ((InMemoryShoppingCartDao) shoppingCartDao).returnCart(userId);
	}

}
