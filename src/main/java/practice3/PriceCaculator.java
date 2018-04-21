package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    public BigDecimal calculateWithBigDecimal(List<BigDecimal> lists){
        BigDecimal total = new BigDecimal(0);
        for (BigDecimal l : lists) {
            total = total.add(l);
        }
        return total;
    }

    public BigDecimal calculateWithOrderLineItem(List<OrderLineItem> lists){
        BigDecimal total = new BigDecimal(0);
        for (OrderLineItem o : lists) {
            total = total.add(o.getPrice());
        }
        return  total;
    }

}
