package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;
import org.json.JSONObject;

import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface Printer {
    Future<String> print(Payment payment);
}
