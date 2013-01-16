package com.blackdoor.alcotax;

import com.blackdoor.alcotax.Calculator;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
//import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	private EditText editTextPrice, editTextVolume;
	private EditText editTextTotalPrice, editTextCurrPrice;
	private Calculator calc = new Calculator();
	private RadioButton radioButtonBeer, radioButtonWine, radioButtonHardA;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextPrice = (EditText) findViewById(R.id.editTextPrice);
		editTextVolume = (EditText) findViewById(R.id.editTextVolume);
		editTextTotalPrice = (EditText) findViewById(R.id.editTextTotalPrice);
		editTextCurrPrice = (EditText) findViewById(R.id.editTextCurrPrice);
		radioButtonBeer = (RadioButton) findViewById(R.id.radioBeer);
		radioButtonWine = (RadioButton) findViewById(R.id.radioWine);
		radioButtonHardA = (RadioButton) findViewById(R.id.radioHardA);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public boolean isEmptyText(EditText editText){
		return editText.getText().toString().equals("");
	}

	public void onCalculate(View view) {
		double price = 0;
		double vol = 0;
		if(!isEmptyText(editTextPrice))
			{price = Float.parseFloat(editTextPrice.getText().toString());}
		if(!isEmptyText(editTextVolume))
			{vol = Float.parseFloat(editTextVolume.getText().toString());}
		
		if (radioButtonHardA.isChecked()) 
			calc.CalculateCurrPrice(vol, price, "hardA");
		if (radioButtonBeer.isChecked()) 
			calc.CalculateCurrPrice(0, price, "beer");
		if (radioButtonWine.isChecked())
			calc.CalculateCurrPrice(vol, price, "wine");

		editTextCurrPrice.setText("$" + String.valueOf(calc.GetCurrPrice()));
	}

	public void onTotal(View view) {
		calc.CalculateNewTotal();
		editTextTotalPrice.setText("$" + String.valueOf(calc.GetTotalPrice()));
	}
	
	public void DisableVolume(View view){
		editTextVolume.setEnabled(false);
	}
	
	public void EnableVolume(View view){
		editTextVolume.setEnabled(true);
	}
}
