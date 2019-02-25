package testdoubles;

import order.MailServiceInterface;
import order.OrderInterface;
import order.Order;
import order.WarehouseStub;
import order.MailServiceStub;
import order.WarehouseInterface;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitPlatform.class)
public class OrderStateTester
{
    private String product = "HairProduct";

    @Test
    public void testOrderOKIfProductQuantityIs50()
    {
        OrderInterface order = new Order(product, 50);
        
        MailServiceInterface mailService = new MailServiceStub();
        WarehouseInterface warehouse = new WarehouseStub();
        
        order.setMailService(mailService);
        boolean orderOK = order.requestOrder(warehouse);
        
        assertThat(orderOK, is(true));
        assertThat(mailService.numberOfMailsSent(), is(0));
    }
    
    @Test
    public void testOrderNotOKIfProductQuantityIsMoreThan50()
    {
        OrderInterface order = new Order(product, 51);
        
        MailServiceInterface mailService = new MailServiceStub();
        WarehouseInterface warehouse = new WarehouseStub();
        
        order.setMailService(mailService);
        boolean orderOK = order.requestOrder(warehouse);
        
        assertThat(orderOK, is(false));
        assertThat(mailService.numberOfMailsSent(), is(1));
    }
}