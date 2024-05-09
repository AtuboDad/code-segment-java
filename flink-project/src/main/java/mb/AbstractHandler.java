package mb;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractHandler {

    protected void getNumber() {
        System.out.println("开始取号");
    }

    protected void vipBusiness(String name, Consumer<BigDecimal> me) {
        System.out.println("VIP客户, 不需要取号");
        me.accept(null);

        judge(name);
    }

    protected void normalBusiness(String name, Consumer<BigDecimal> me) {
        getNumber();

        me.accept(null);

        judge(name);
    }

    protected void execute(Supplier<String> supplier, Consumer<BigDecimal> me) {

        String customer = supplier.get();
        if (customer.toLowerCase().startsWith("vip")) {
            vipBusiness(customer, me);
        } else {
            normalBusiness(customer, me);
        }
    }

    protected void judge(String name) {
        System.out.println(name + "评价");
    }

}
