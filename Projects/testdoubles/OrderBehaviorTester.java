package testdoubles;

import order.Order;
import order.MailServiceInterface;
import order.OrderInterface;
import order.WarehouseInterface;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
public class OrderBehaviorTester
{
    private String product = "HairProduct";

    @Test
    public void testOrderOKIfProductQuantityIs50()
    {
        OrderInterface order = new Order(product, 50);
        
        MailServiceInterface mailMock = mock(MailServiceInterface.class);
        WarehouseInterface warehouseMock = mock(WarehouseInterface.class);

        when(warehouseMock.has50ProductsInStock(product, 50)).thenReturn(true);
        
        order.setMailService(mailMock);
        order.requestOrder(warehouseMock);

        verify(warehouseMock).has50ProductsInStock(product, 50);
        verify(warehouseMock).placeOrder(product, 50);
    }
    
    @Test
    public void testOrderNotOKIfProductQuantityIsMoreThan50()
    {
        OrderInterface order = new Order(product, 51);
        
        MailServiceInterface mailMock = mock(MailServiceInterface.class);
        WarehouseInterface warehouseMock = mock(WarehouseInterface.class);
        
        when(warehouseMock.has50ProductsInStock(product, 51)).thenReturn(false);

        order.setMailService(mailMock);
        order.requestOrder(warehouseMock);

        verify(warehouseMock).has50ProductsInStock(product, 51);
        verify(mailMock).send("Request more products...");
    }
}