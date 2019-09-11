package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity=0;
    public void submitOrder(View view) {
        int price= calculateprice(quantity);
        String priceMessage= OrderSummary(price);
        displayMessage(priceMessage);
    }

    private int calculateprice (int quantity)
    {
        return quantity*5;
    }
    public void increment(View View)
    {
        quantity++;
        displayquantity(quantity);

    }

    private  String OrderSummary(int price)
    {
        String summary= "";
        summary+="name=Kaptain Kunal\n";
        summary+="quantity: "+quantity;
        summary+="\nTotal: $ "+price;
        summary+="\nThankYOu!";

        return summary;
    }
    public void decrement(View View)
    {
        if(quantity!=0){

            quantity--;
    }

        displayquantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayquantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrdersummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        OrdersummaryTextView.setText(message);
        

    }
}
