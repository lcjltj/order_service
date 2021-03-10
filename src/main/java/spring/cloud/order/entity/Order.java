package spring.cloud.order.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "idus_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1820601397087685614L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String number;
	private String productName;
	private Date orderDate;
	private Long userNumber;

}
