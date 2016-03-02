package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;
import org.json.JSONObject;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface Printer {
    String print(Payment payment);
}
