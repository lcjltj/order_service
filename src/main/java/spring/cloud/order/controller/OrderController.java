package spring.cloud.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import spring.cloud.order.dto.request.RequestOrderProduct;
import spring.cloud.order.dto.response.DefaultResponse;
import spring.cloud.order.dto.response.ResponseLastOrder;
import spring.cloud.order.dto.response.ResponseOrderList;
import spring.cloud.order.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Api(tags = "주문 조회", description = "주문 서비스")
public class OrderController {

	private final OrderService orderService;
	@PostMapping("/inner/last_order")
	@ApiOperation(value = "사용자 별 마지막 주문 목록")
	public ResponseEntity<DefaultResponse<List<ResponseLastOrder>>> getLastOrder(@ApiParam(name = "사용자 마지막 주문 조회", value =  "사용자 고객번호 입력")
																				 @RequestBody List<Long> number){		
		DefaultResponse<List<ResponseLastOrder>> result = orderService.getLastOrder(number);

		return new ResponseEntity<DefaultResponse<List<ResponseLastOrder>>>(result,HttpStatus.OK);
	}
	
	@GetMapping("/auth/order_list/{pageNum}")
	@ApiOperation(value = "사용자 주문 목록", authorizations = { @Authorization("AUTHORIZATION") })
	public ResponseEntity<DefaultResponse<List<ResponseOrderList>>> getOrderListByUser(HttpServletRequest request, @PathVariable int pageNum){
		long userNumber = (Long) request.getAttribute("userNumber");
		DefaultResponse<List<ResponseOrderList>> result = orderService.getOrderListByUser(userNumber,pageNum);
		
		return new ResponseEntity<DefaultResponse<List<ResponseOrderList>>>(result,HttpStatus.OK);
	}
	
	@PostMapping("/auth/order_product")
	@ApiOperation(value = "상품 주문", authorizations = { @Authorization("AUTHORIZATION") })
	public ResponseEntity<DefaultResponse<String>> orderProduct(HttpServletRequest request,
																@ApiParam(name = "상품 명", value =  "구입 상품 명 입력")
																@RequestBody RequestOrderProduct product){
		long userNumber = (Long) request.getAttribute("userNumber");
		DefaultResponse<String> result = orderService.orderProduct(userNumber,product);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}