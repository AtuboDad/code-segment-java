package mb;

import java.math.BigDecimal;

public class MainExecute {

    public static void main(String[] args) {
        SaveMoneyHandler saveMoneyHandler = new SaveMoneyHandler();

        saveMoneyHandler.saveVip(new BigDecimal(1000));
        saveMoneyHandler.saveNormal(new BigDecimal(1000));
    }

}
