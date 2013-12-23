package com.codepath.example.myfirstapp;


import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tip extends Activity {

	public EditText et_txt_billAmount;
	public EditText et_tipPercent;
	public TextView tv_tipAmountLabel;
	public TextView tv_tenPercentTipAmountLabel;
	public TextView tv_tenPercentTipTotalLabel;
	public TextView tv_fifteenPercentTipAmountLabel;
	public TextView tv_fifteenPercentTipTotalLabel;
	public TextView tv_twentyPercentTipAmountLabel;
	public TextView tv_twentyPercentTipTotalLabel;
	public TextView tv_customTipTotalLabel;
	public TextView tv_customTipPercentLabel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip);
        et_txt_billAmount = (EditText) findViewById(R.id.et_txt_billAmount);
        et_tipPercent = (EditText) findViewById(R.id.et_tipPercent);
        tv_tipAmountLabel = (TextView) findViewById(R.id.tv_tipAmountLabel);
        tv_tenPercentTipAmountLabel = (TextView) findViewById(R.id.tv_tenPercentTipAmountLabel);
        tv_tenPercentTipTotalLabel = (TextView) findViewById(R.id.tv_tenPercentTipTotalLabel);
        tv_fifteenPercentTipAmountLabel = (TextView) findViewById(R.id.tv_fifteenPercentTipAmountLabel);
        tv_fifteenPercentTipTotalLabel = (TextView) findViewById(R.id.tv_fifteenPercentTipTotalLabel);
        tv_twentyPercentTipAmountLabel = (TextView) findViewById(R.id.tv_twentyPercentTipAmountLabel);
        tv_twentyPercentTipTotalLabel = (TextView) findViewById(R.id.tv_twentyPercentTipTotalLabel);
        tv_customTipTotalLabel = (TextView) findViewById(R.id.tv_customTipTotalLabel);
        tv_customTipPercentLabel = (TextView) findViewById(R.id.tv_customTipPercentLabel);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip, menu);
        return true;
    }
   
    
    
    public void onSubmit(View v) {
    
    	float billAmount;
    	
    	//Check if the bill amount is empty or not and print a toast
    	
    	if (et_txt_billAmount.getText().toString().trim().equals(""))
    	{
    	
    		//Set all the text views to empty string 
    		
    		tv_tipAmountLabel.setText("");
	    	tv_customTipTotalLabel.setText("");
	    	tv_customTipPercentLabel.setText("");
	    	tv_tenPercentTipAmountLabel.setText("");
        	tv_tenPercentTipTotalLabel.setText("");
        	tv_fifteenPercentTipAmountLabel.setText("");
        	tv_fifteenPercentTipTotalLabel.setText("");
        	tv_twentyPercentTipAmountLabel.setText("");
        	tv_twentyPercentTipTotalLabel.setText("");
    		Toast.makeText(Tip.this, "Please enter bill amount", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	else {
    	    	billAmount = Float.parseFloat(et_txt_billAmount.getText().toString());
    	}
    	
    	float tenPercentTipAmount = billAmount*10/100;
    	float fifteenPercentTipAmount = billAmount*15/100;
    	float twentyPercentTipAmount = billAmount*20/100;
    	float tipPercent;
    	String percent = "% Tip";
    	DecimalFormat df = new DecimalFormat("0.00");
    	
    	
    	//Check if the custom tip percent is empty or not
    	
    	if (et_tipPercent.getText().toString().trim().equals("")){
    		
    		// Show 10% tip amount and total
        	tv_tenPercentTipAmountLabel.setText(String.valueOf(df.format(tenPercentTipAmount)));
        	tv_tenPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.10))));
        	
        	//Show 15% percent tip amount and total
        	tv_fifteenPercentTipAmountLabel.setText(String.valueOf(df.format(fifteenPercentTipAmount)));
        	tv_fifteenPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.15))));
        	
        	//Show 20% percent tip amount and total
        	tv_twentyPercentTipAmountLabel.setText(String.valueOf(df.format(twentyPercentTipAmount)));
        	tv_twentyPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.20))));
        	
        	tv_tipAmountLabel.setText("");
        	tv_customTipTotalLabel.setText("");
	    	tv_customTipPercentLabel.setText("");
    	}
    	else {
    			tipPercent = Float.parseFloat(et_tipPercent.getText().toString());
    			//Calculate the tip amount
    	    	float tipAmount = billAmount*tipPercent/100;
    	    	//Show the tip amount
    	    	tv_tipAmountLabel.setText(String.valueOf(df.format(tipAmount)));
    	    	tv_customTipTotalLabel.setText(String.valueOf(df.format(billAmount+tipAmount)));
    	    	tv_customTipPercentLabel.setText(et_tipPercent.getText().toString() + percent);
    	    	
    	    	//Show ten percent tip amount and total
    	    	tv_tenPercentTipAmountLabel.setText(String.valueOf(df.format(tenPercentTipAmount)));
            	tv_tenPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.10))));
            	
            	//Show fifteen percent tip amount and total
            	tv_fifteenPercentTipAmountLabel.setText(String.valueOf(df.format(fifteenPercentTipAmount)));
            	tv_fifteenPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.15))));
            	
            	//Show twenty percent tip amount and total
            	tv_twentyPercentTipAmountLabel.setText(String.valueOf(df.format(twentyPercentTipAmount)));
            	tv_twentyPercentTipTotalLabel.setText(String.valueOf(df.format(billAmount*(1.20))));
    	}
    	
    	
    	
    }
    
  
    
}
