package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    private PriceCaculator priceCaculator = new PriceCaculator();

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal calculate() {

        BigDecimal subTotal = priceCaculator.calculateWithOrderLineItem(orderLineItemList);
        BigDecimal discount = priceCaculator.calculateWithBigDecimal(discounts);
        subTotal = subTotal.subtract(discount);
        // calculate tax
        BigDecimal tax = subTotal.multiply(this.tax);

        // calculate GrandTotal
        BigDecimal grandTotal = subTotal.add(tax);

        return grandTotal;
    }
}
