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

public class OrdersBusinessService implements OrdersBusinessInterface {
	
	List<Order> orders = new ArrayList<Order>();

	@Override
	public void test() {
		System.out.println("=== Hello from the OrdersBusinessService === ");
	}

	public OrdersBusinessService() {
	
		orders.add(new Order("001", "Product #1", (float) 5.00, 1));
		orders.add(new Order("002", "Product #2", (float) 6.00, 3));
		orders.add(new Order("003", "Product #3", (float) 7.00, 5));
		orders.add(new Order("004", "Product #4", (float) 8.00, 7));
		orders.add(new Order("005", "Product #5", (float) 9.00, 9));
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
