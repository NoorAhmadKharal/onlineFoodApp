package com.example.onlinefoodapplicationproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class regis extends AppCompatActivity {

    private View hideView;
    ImageView profileImage;
    TextView upload, resgis, facebook, google, login, view, update, delete, back;
    int Select_Image_Value = 1;
    EditText username, userphone, useremail, userpassword;
    SQLiteDBRegistOnlineFood DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        hideView = getWindow().getDecorView();
        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    hideView.setSystemUiVisibility(hideSystemBar());
                }
            }
        });

        view = (TextView) findViewById(R.id.View12);
        update = (TextView) findViewById(R.id.update);
        delete = (TextView) findViewById(R.id.delete12);
        upload = (TextView) findViewById(R.id.uploadimage);
        resgis = (TextView) findViewById(R.id.register);
        facebook = (TextView) findViewById(R.id.facebook);
        google = (TextView) findViewById(R.id.google);
        login = (TextView) findViewById(R.id.login);
        back = (TextView) findViewById(R.id.back);
        profileImage = (ImageView) findViewById(R.id.profile_image);
        username = (EditText) findViewById(R.id.Userername);
        userphone = (EditText) findViewById(R.id.UserPhone);
        useremail = (EditText) findViewById(R.id.Useremailaddress);
        userpassword = (EditText) findViewById(R.id.Userpassword);
        DB = new SQLiteDBRegistOnlineFood(this);
        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(regis.this, "Click Back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(regis.this, BeforeHomeActivity.class);
                startActivity(intent);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(regis.this, "Upload Image", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "tittle"), Select_Image_Value);


            }
        });

        resgis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTEXT = username.getText().toString();
                String phoneTEXT = userphone.getText().toString();
                String emailTEXT = useremail.getText().toString();
                String passwordTEXT = userpassword.getText().toString();

                boolean checkinsertdata = DB.insertdata(nameTEXT, phoneTEXT, emailTEXT, passwordTEXT);
                {
                    if (checkinsertdata == true) {
                        Toast.makeText(regis.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(regis.this, "Not Data inserted", Toast.LENGTH_SHORT).show();
                    }
                }

                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                databaseHandler.create_users(
                        username.getText().toString(),
                        userpassword.getText().toString(),
                        useremail.getText().toString(),
                        userphone.getText().toString()
                );

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username.getText().toString());
                editor.putString("userphone", userphone.getText().toString());
                editor.putString("useremail", useremail.getText().toString());
                editor.putString("userpassword", userpassword.getText().toString());
                editor.commit();
                Toast.makeText(regis.this, "Register Successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(regis.this, resgInfor.class);
                startActivity(intent);


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = DB.getdata();
                if (cursor.getCount() == 0) {
                    Toast.makeText(regis.this, "No Data Exist", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(regis.this, NoData.class);
                    startActivity(intent);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("Name: " + cursor.getString(0) + "\n");
                    stringBuffer.append("phone: " + cursor.getString(1) + "\n");
                    stringBuffer.append("Email: " + cursor.getString(2) + "\n");
                    stringBuffer.append("Password: " + cursor.getString(3) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(regis.this);
                builder.setCancelable(true);
                builder.setTitle("Register User Entries");
                builder.setMessage(stringBuffer.toString());
                builder.show();


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTEXT = username.getText().toString();
                String phoneTEXT = userphone.getText().toString();
                String emailTEXT = useremail.getText().toString();
                String passwordTEXT = userpassword.getText().toString();

                boolean checkupdatedata = DB.updateuserdata(nameTEXT, phoneTEXT, emailTEXT, passwordTEXT);
                if (checkupdatedata == true) {
                    Toast.makeText(regis.this, "Data Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(regis.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTEXT = username.getText().toString();

                boolean checkupdatedata = DB.deletedata(nameTEXT);
                if (checkupdatedata == true) {
                    Toast.makeText(regis.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(regis.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(regis.this, "Click Facebook", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://web.facebook.com/campaign/landing.php?campaign_id=1653377901&extra_1=s%7Cc%7C318305677145%7Ce%7Clogin%20facebook%20account%7C&placement&creative=318305677145&keyword=login%20facebook%20account&partner_id=googlesem&extra_2=campaignid%3D1653377901%26adgroupid%3D65139787642%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-302772062139%26loc_physical_ms%3D1011082%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwsJ6TBhAIEiwAfl4TWMxU73X7LG4XsIC6bSnrZX9ewMWUsBJASWnbqKGPRhUdSsHDEgf5cxoCU6AQAvD_BwE&_rdc=1&_rdr"));
                startActivity(intent);

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(regis.this, "Click Google", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(regis.this, " Login Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(regis.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(regis.this, " Login Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            hideView.setSystemUiVisibility(hideSystemBar());
        }
    }

    private int hideSystemBar() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Uri uri = data.getData();
            profileImage.setImageURI(uri);
            upload.setText("pic Upload");
        }
    }
}