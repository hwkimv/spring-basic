package spring.spring_basic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice); // 주문 생성
}
