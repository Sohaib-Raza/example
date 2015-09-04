package com.example.calculater;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected EditText text1;
	private Button one, two, three, four, five, six, seven, eight, nine, zero,
			plus, subtract, multiply, division, equal, decimal, clearText,
			backValue, quitTheCalculater;
	public int globleCount = 0, totalDigit = 0;
	public long val, backSpaceValue;
	String oprater = null;
	private Boolean calculation = false, setValue = true, decimalAnswer=false;

	calculation calculation1 = new calculation();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView opraterSign = (TextView) findViewById(R.id.textView);
		text1 = (EditText) findViewById(R.id.editText1);
		one = (Button) findViewById(R.id.button1);
		two = (Button) findViewById(R.id.button2);
		three = (Button) findViewById(R.id.button3);
		four = (Button) findViewById(R.id.button4);
		five = (Button) findViewById(R.id.button5);
		six = (Button) findViewById(R.id.button6);
		seven = (Button) findViewById(R.id.button7);
		eight = (Button) findViewById(R.id.button8);
		nine = (Button) findViewById(R.id.button9);
		zero = (Button) findViewById(R.id.button11);
		plus = (Button) findViewById(R.id.button13);
		subtract = (Button) findViewById(R.id.button14);
		multiply = (Button) findViewById(R.id.button15);
		division = (Button) findViewById(R.id.button16);
		equal = (Button) findViewById(R.id.button12);
		decimal = (Button) findViewById(R.id.button10);
		clearText = (Button) findViewById(R.id.button17);
		backValue = (Button) findViewById(R.id.button18);
		quitTheCalculater = (Button) findViewById(R.id.button19);

		quitTheCalculater.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}

		});

		backValue.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!(text1.getText().toString().equals(""))) {
					backSpaceValue = Long.parseLong(text1.getText().toString()) / 10;

					text1.setText(toString().valueOf(backSpaceValue));
					if (setValue) {
						calculation1.setValue1(backSpaceValue);
					} else {
						calculation1.setValue2(backSpaceValue);
						calculation = true;
					}
				}
				if (backSpaceValue == 0) {
					text1.setText("");

				}

			}

		});

		clearText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				text1.setText("");
				calculation = false;
				opraterSign.setText("");
				globleCount = 0;
				oprater = null;
				setValue = true;
				decimalAnswer=false;
				calculation1.setAnswer(0);
				calculation1.setValue1(0);
				calculation1.setValue2(0);

			}

		});

		decimal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			}

		});

		plus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				setValue = false;
				globleCount = 0;
				if (calculation) {
					calculation(); // method

				}

				oprater = "+";
				opraterSign.setText("+");

			}
		});

		subtract.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				setValue = false;
				globleCount = 0;
				if (calculation) {
					calculation();
					// method
				}

				oprater = "-";
				opraterSign.setText("-");

			}
		});
		multiply.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				setValue = false;
				globleCount = 0;
				if (calculation) {
					calculation(); // method
				}

				oprater = "*";
				opraterSign.setText("*");
			}

		});
		division.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				decimalAnswer = true;
				setValue = false;
				globleCount = 0;
				if (calculation) {
					calculation(); // method
				}
				oprater = "/";
				opraterSign.setText("/");
			}

		});

		equal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (calculation) {
					calculation(); // method
				}
				opraterSign.setText("=");
				setValue = true;
				decimalAnswer=false;
			}

		});

		one.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				number(1);
			}

		});
		two.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(2);

			}
		});
		three.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(3);

			}
		});

		four.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(4);
			}
		});

		five.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(5);
			}
		});

		six.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(6);

			}
		});

		seven.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(7);
			}
		});

		eight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(8);
			}
		});

		nine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(9);
			}
		});

		zero.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				number(0);

			}
		});

	}

	protected void calculation() {
		// TODO Auto-generated method stub
		calculation = false;
		if (oprater == "+") {
			calculation1.add();
		} else if (oprater == "-") {
			calculation1.sub();
		} else if (oprater == "*") {
			calculation1.multiply();
		} else if (oprater == "/") {
			calculation1.divison();
		}

		if(decimalAnswer)  //if answer in decimal then decimalAnswer is true.
		{
			text1.setText(toString().valueOf((calculation1.getAnswer())));
		}else{
	        val=(long) calculation1.getAnswer();
	        text1.setText(toString().valueOf((val)));
		}
		oprater = null;
		globleCount = 0;

		calculation1.setValue1(calculation1.getAnswer());

	}

	// for number generate
	protected void number(long num) {
		// TODO Auto-generated method stub
		val = num;
		for (int i = 0; i < globleCount; i++) {
			val = Long.parseLong(text1.getText().toString());
			val = (val * 10 + num);

		}

		text1.setText(toString().valueOf(val));
		globleCount = globleCount + 1;
		if (setValue) {

			calculation1.setValue1(val);

		} else {

			calculation1.setValue2(val);
			calculation = true;

		}
	}

}