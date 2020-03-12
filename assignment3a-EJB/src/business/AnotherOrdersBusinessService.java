package business;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative

public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	
	List<Order> orders = new ArrayList<Order>();


	@Override
	public void test() {
		System.out.println("=== Hello from the AnotherOrdersBusinessService === ");
	}
	
	public AnotherOrdersBusinessService() {
		
		orders.add(new Order("00a", "Product #1 from another bs", (float) 5.00, 1));
		orders.add(new Order("00b", "Product #2 from another bs", (float) 6.00, 3));
		orders.add(new Order("00c", "Product #3 from another bs", (float) 7.00, 5));
		orders.add(new Order("00d", "Product #4 from another bs", (float) 8.00, 7));
		orders.add(new Order("00e", "Product #5 from another bs", (float) 9.00, 9));
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
