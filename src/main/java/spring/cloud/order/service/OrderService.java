package spring.cloud.order.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.cloud.order.dto.request.RequestOrderProduct;
import spring.cloud.order.dto.response.DefaultResponse;
import spring.cloud.order.dto.response.ResponseLastOrder;
import spring.cloud.order.dto.response.ResponseOrderList;
import spring.cloud.order.entity.Order;
import spring.cloud.order.entity.Pagination;
import spring.cloud.order.exception.OrderException;
import spring.cloud.order.exception.OrderExceptionType;
import spring.cloud.order.mapper.OrderMapper;
import spring.cloud.order.util.PaginationUtil;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderMapper orderMapper;
	private final PaginationUtil pageUtil;
	
	public DefaultResponse<List<ResponseLastOrder>> getLastOrder(List<Long> userNumber) {
		List<Order> order = orderMapper.getLastOrderByUser(userNumber);
		List<ResponseLastOrder> responseOrder = new ArrayList<>();

		for (Order orderList : order) {
			responseOrder.add(new ResponseLastOrder().toDto(orderList));
		}
		return new DefaultResponse<>(responseOrder);
	}

	public DefaultResponse<List<ResponseOrderList>> getOrderListByUser(Long userNumber,int pageNum) {
		Long orderCount = orderMapper.getOrderCountByUser(userNumber);
		Pagination pagination = pageUtil.Paging(20, pageNum, orderCount);
		List<Order> order = orderMapper.getOrderListByUser(userNumber,pagination);
		List<ResponseOrderList> responseOrder = new ArrayList<>();
		
		for (Order orderList : order) {
			responseOrder.add(new ResponseOrderList().toDto(orderList));
		}
		
		return new DefaultResponse<>(responseOrder);
	}
	
	public DefaultResponse<String> orderProduct(Long userNumber, RequestOrderProduct requestProduct){
		Order order = Order.builder()
						.number(createOrderNumber())
						.productName(requestProduct.getProductName())
						.orderDate(new Date())
						.userNumber(userNumber)
						.build();
		
		int result = orderMapper.orderProductByUser(order);
		
		if(result != 1) {
			throw new OrderException(OrderExceptionType.FAIL_ORDER_PRODUCT);
		}
		
		return new DefaultResponse<>("OK");
	}
	
	
	@SuppressWarnings("static-access")
	private String createOrderNumber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmm");
        Calendar dateTime = Calendar.getInstance();
        String uniqueId = new StringBuilder()
        					.append(RandomStringUtils.randomAlphanumeric(4).toUpperCase())			
        					.append(simpleDateFormat.format(dateTime.getTime()))
        					.toString();
        
		return uniqueId;
	}

}
