package mb;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.Random;

public class SaveMoneyHandler extends AbstractHandler {

    public void saveVip(BigDecimal number) {
        execute(() -> "VIP" + RandomUtils.nextInt(0, 1000), a -> System.out.println("存入：" + number));
    }

    public void saveNormal(BigDecimal number) {
        execute(() -> "Normal" + RandomUtils.nextInt(0, 1000), a -> System.out.println("存入：" + number));
    }
}
