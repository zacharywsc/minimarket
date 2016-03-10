package com.minimarket.cashiers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zachary on 2016/3/2.
 */
public class Payment {
    public static class PayItem {
        public String name;
        public String measurement;
        public Integer amount;
        public double price;
        public double total;
        public double discount;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PayItem that = (PayItem) o;

            if (Double.compare(that.price, price) != 0) return false;
            if (Double.compare(that.total, total) != 0) return false;
            if (Double.compare(that.discount, discount) != 0) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            if (measurement != null ? !measurement.equals(that.measurement) : that.measurement != null) return false;
            return amount != null ? amount.equals(that.amount) : that.amount == null;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = name != null ? name.hashCode() : 0;
            result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
            result = 31 * result + (amount != null ? amount.hashCode() : 0);
            temp = Double.doubleToLongBits(price);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(total);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(discount);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public static class DiscountItem {
        public String strategy;
        public String name;
        public String measurement;
        public int amount;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DiscountItem that = (DiscountItem) o;

            if (amount != that.amount) return false;
            if (strategy != null ? !strategy.equals(that.strategy) : that.strategy != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            return measurement != null ? measurement.equals(that.measurement) : that.measurement == null;

        }

        @Override
        public int hashCode() {
            int result = strategy != null ? strategy.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
            result = 31 * result + amount;
            return result;
        }
    }

    public double total = 0;
    public double discount = 0;
    public String currency = "";
    public List<PayItem> payItems = new LinkedList<PayItem>();
    public List<DiscountItem> discountItems = new LinkedList<DiscountItem>();
    public int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (Double.compare(payment.total, total) != 0) return false;
        if (Double.compare(payment.discount, discount) != 0) return false;
        if (currency != null ? !currency.equals(payment.currency) : payment.currency != null) return false;
        if (payItems != null ? !payItems.equals(payment.payItems) : payment.payItems != null)
            return false;
        return discountItems != null ? discountItems.equals(payment.discountItems) : payment.discountItems == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(total);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (payItems != null ? payItems.hashCode() : 0);
        result = 31 * result + (discountItems != null ? discountItems.hashCode() : 0);
        return result;
    }
}
