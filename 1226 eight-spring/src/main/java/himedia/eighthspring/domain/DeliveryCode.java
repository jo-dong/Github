package himedia.eighthspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * -------------------------
 *  code	| displayName
 * -------------------------
 *  TODAY	| 당일 배송
 *  NORMAL	| 보통 배송
 *  SLOW	| 느린 배송
 * -------------------------
 *  System  | Customer
 * ------------------------- 
 */
@Data
@AllArgsConstructor
public class DeliveryCode {
	private String code;
	private String displayName;
}
