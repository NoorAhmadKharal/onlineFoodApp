package com.example.onlinefoodapplicationproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private View hideView;
    TextView back,signIn, facebook, google, regist, view, delete, updata;
    EditText phone, password;
    SQLiteDBLoginOnlineFood DB;
    ContentValues values = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        view = (TextView) findViewById(R.id.insert);
        delete = (TextView) findViewById(R.id.delete);
        updata = (TextView) findViewById(R.id.updata);
        back = (TextView) findViewById(R.id.back);
        signIn = (TextView) findViewById(R.id.signin);
        facebook = (TextView) findViewById(R.id.facebook);
        google = (TextView) findViewById(R.id.google);
        regist = (TextView) findViewById(R.id.backRegis);
        phone = (EditText) findViewById(R.id.editTextPhone2);
        password = (EditText) findViewById(R.id.editTextTextPassword3);

        // intial SQLite DataBase
        DB = new SQLiteDBLoginOnlineFood(this);

        // Back Button Code
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, " Click Back ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, BeforeHomeActivity.class);
                startActivity(intent);
            }
        });

        // Sign Code
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get data fron edittext
                String phoneTEXT = phone.getText().toString();
                String passwordTEXT = password.getText().toString();

                // Content Provider //

                values.put("Phone", phoneTEXT);
                values.put("Password", passwordTEXT);

                // uri create
                Uri uri = getContentResolver().insert(DetailProvider.CONTENT_URI, values);
                Toast.makeText(LoginActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
                // end //

                // data insert into DB
             //   boolean checkinsertdata = DB.insertuserdata(phoneTEXT,passwordTEXT);
                boolean checkinsertdata = DB.saveOder(phoneTEXT,passwordTEXT);
                if (checkinsertdata == true)
                {
                    Toast.makeText(LoginActivity.this, "New Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "New Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

                final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("PhoneNo", phone.getText().toString());
                editor.putString("Password", password.getText().toString());
                editor.commit();
                Toast.makeText(LoginActivity.this, " Sign In Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, loginInfor.class);
                startActivity(intent);




            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phonTEXT = phone.getText().toString();

                boolean checkupdatedata = DB.deletedata(phonTEXT);
                if (checkupdatedata == true)
                {
                    Toast.makeText(LoginActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, NoData.class);
                    startActivity(intent);
                }
            }
        });

        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneTEXT = phone.getText().toString();
                String passwordTEXT = password.getText().toString();

                boolean checkupdatedata = DB.updateuserdata(phoneTEXT, passwordTEXT);
                if (checkupdatedata == true)
                {
                    Toast.makeText(LoginActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, NoData.class);
                    startActivity(intent);

                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Content Provider //

                Cursor cr = getContentResolver().query(DetailProvider.CONTENT_URI, null, null, null, "id");
                StringBuilder SB = new StringBuilder();
                while (cr.moveToNext()){
                    int id = cr.getInt(0);
                    String s1 = cr.getString(1);
                    String s2 = cr.getString(2);
                    SB.append(id+" "+s1+" "+s2+ " "+"\n");
                }
                Toast.makeText(LoginActivity.this, SB.toString(), Toast.LENGTH_SHORT).show();

                // End //

                Cursor cursor = DB.getdata();
                if (cursor.getCount()==0)
                {
                    Toast.makeText(LoginActivity.this, "No Data Exist", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, NoData.class);
                    startActivity(intent);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext())
                {
                    stringBuffer.append("phone: "+cursor.getString(0)+"\n");
                    stringBuffer.append("password: "+cursor.getString(1)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(stringBuffer.toString());
                builder.show();


            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Click Facebook", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://web.facebook.com/campaign/landing.php?campaign_id=1653377901&extra_1=s%7Cc%7C318305677145%7Ce%7Clogin%20facebook%20account%7C&placement&creative=318305677145&keyword=login%20facebook%20account&partner_id=googlesem&extra_2=campaignid%3D1653377901%26adgroupid%3D65139787642%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-302772062139%26loc_physical_ms%3D1011082%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwsJ6TBhAIEiwAfl4TWMxU73X7LG4XsIC6bSnrZX9ewMWUsBJASWnbqKGPRhUdSsHDEgf5cxoCU6AQAvD_BwE&_rdc=1&_rdr"));
                startActivity(intent);

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Click Google", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
                startActivity(intent);
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, " Click Login ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, regis.class);
                startActivity(intent);
            }
        });


        hideView = getWindow().getDecorView();
        hideView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0)
                {
                    hideView.setSystemUiVisibility(hideSystemBar());
                }
            }
        });
    }





    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {
            hideView.setSystemUiVisibility(hideSystemBar());
        }
    }

    private int hideSystemBar()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}