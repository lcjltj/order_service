package spring.cloud.order.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import spring.cloud.order.entity.Order;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResponseOrderList {

	private String number;
	private String productName;
	private Date orderData;
	private Long userNumber;
	
	public ResponseOrderList toDto(Order order) {
		return ResponseOrderList.builder()
				.number(order.getNumber())
				.productName(order.getProductName())
				.orderData(order.getOrderDate())
				.userNumber(order.getUserNumber())
				.build();
	}
}
