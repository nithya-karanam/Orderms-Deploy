package com.infy.OrderMS;


import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infosys.project.order.dto.OrderDTO;
import com.infosys.project.order.entity.OrderDetails;
import com.infosys.project.order.repository.OrderRepository;
import com.infosys.project.order.service.OrderService;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderMsApplicationTests {

	@InjectMocks
	OrderService orderservicemock=new OrderService();
	@Autowired
	OrderService orderservice;
	@Mock
	 OrderRepository orderRepo;
	@Test
	public void asdf() {
	   
	}
@Test
      public void getAllOrderDetails() throws Exception{
 OrderDetails order1=new OrderDetails(1,11,1245.0,LocalDate.parse("2020-01-28"),"HYD","ORDER PLACED");
   OrderDetails order2=new OrderDetails(2,11,9991.00,LocalDate.parse("2020-02-28"),"Delhi","ORDER PLACED");
   List<OrderDetails> orders= new ArrayList();
  orders.add(order1);
  orders.add(order2);
  Mockito.when(orderRepo.findAll()).thenReturn(orders);
  List<OrderDTO> orlist=orderservicemock.getOrderDetails();
   Assertions.assertEquals(orders.isEmpty(), orlist.isEmpty());
	
}

   @Test
   public void getOrderbyOrderIdValid() throws Exception{
	   int orderid=1;
	   orderRepo.findById(orderid);
	   verify(orderRepo, times(1)).findById(1);
   }
   
}
