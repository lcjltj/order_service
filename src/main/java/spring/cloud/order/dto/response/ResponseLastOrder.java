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
public class ResponseLastOrder {
	private String number;
	private String productName;
	private Date lastOrderData;
	private Long userNumber;
	
	public ResponseLastOrder toDto(Order order) {
		return ResponseLastOrder.builder()
				.number(order.getNumber())
				.productName(order.getProductName())
				.lastOrderData(order.getOrderDate())
				.userNumber(order.getUserNumber())
				.build();
	}
}
