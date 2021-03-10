package spring.cloud.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring.cloud.order.entity.Order;
import spring.cloud.order.entity.Pagination;

@Mapper
public interface OrderMapper {
	
	List<Order> getLastOrderByUser(List<Long> userNumber);
	
	List<Order> getOrderListByUser(@Param(value = "userNumber") Long userNumber,@Param(value = "pagination") Pagination pagination);
	
	Long getOrderCountByUser(Long userNumber);
	
	int orderProductByUser(Order order);
}
