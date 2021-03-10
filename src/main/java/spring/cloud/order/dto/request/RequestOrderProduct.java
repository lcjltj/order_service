package spring.cloud.order.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel
public class RequestOrderProduct {
	
	@NotNull(message = "상품명을 입력하세요.")
	@Length(max = 100, message = "최대 100자리 까지만 입력 가능합니다.")
	@ApiModelProperty(notes = "상품 명", required = true, position = 1)
	private String productName;
}
