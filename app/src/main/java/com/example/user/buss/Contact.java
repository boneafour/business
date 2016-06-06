package com.example.user.buss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;


public class Contact extends Activity implements View.OnClickListener {

	private TextView txtTitle;
	private ImageButton btnBack;

	EditText fullName, comment, phone,adress, organisation, role;
	String ResS, fullNameS, RoleS, PhoneS, CommentS, OrganS, AdressS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);


		fullName = (EditText) findViewById(R.id.fullname);
		organisation = (EditText) findViewById(R.id.organ);
		adress = (EditText) findViewById(R.id.mestorabota);
		role = (EditText) findViewById(R.id.role);
		phone = (EditText) findViewById(R.id.phone);
		comment = (EditText) findViewById(R.id.comment);

		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(getString(R.string.contactSt));

		Button send = (Button) findViewById(R.id.loginButton);
		send.setOnClickListener(this);
		Button view = (Button) findViewById(R.id.view);
		view.setOnClickListener(this);
		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnBack:
				NavUtils.navigateUpFromSameTask(this);
				break;

			case R.id.loginButton:
				fullNameS = "" + fullName.getText();
				fullName.setText("");
				RoleS = "" + role.getText();
				role.setText("");
				OrganS = "" + organisation.getText();
				organisation.setText("");
				AdressS = "" + adress.getText();
				adress.setText("");
				PhoneS = "" + phone.getText();
				phone.setText("");
				CommentS = "" + comment.getText();
				comment.setText("");



				DatabaseHandler db = new DatabaseHandler(this);
				db.addContact(new ContactData(fullNameS, RoleS, PhoneS, CommentS));
				List<ContactData> contacts = db.getAllContacts();
				for (ContactData cn : contacts) {
					String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Role: " + cn.getRole()+" ,Phone: " + cn.getPhone()+" ,Comment: " + cn.getComment();
					// Writing Contacts to log
					Log.d("Name: ", log);

				}
			/*	Log.d("sssssss: ", ""+db.getEmployeeName(1));
				String s = db.getEmployeeName(1);*/
				break;

			case R.id.view:
				startActivity(new Intent(Contact.this, ContactList.class));
				break;
				}
		}
	}

