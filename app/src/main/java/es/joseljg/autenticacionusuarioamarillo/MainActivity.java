package es.joseljg.autenticacionusuarioamarillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRAEMAIL = "es.joseljg.MainActivity.email" ;
    EditText edt_email = null;
    EditText edt_password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_email = findViewById(R.id.edt_emailr);
        edt_password = findViewById(R.id.edt_password);
    }

    public void acceder(View view) {
        String email = String.valueOf(edt_email.getText());
        String password = String.valueOf(edt_password.getText());
        if(validarcredenciales(email,password))
        {
            Intent intent = new Intent(this, ActivityHome.class);
            intent.putExtra(EXTRAEMAIL, email);
            startActivity(intent);
        }
        else
        {
            edt_email.setError("usuario o clave erroneas");
            Toast.makeText(this, "usuario o clave erroneas",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarcredenciales(String email, String password) {
        if(email.equalsIgnoreCase("usuario1@gmail.com") &&
            password.equalsIgnoreCase("1234"))
        {
            return true;
        }
        return false;
    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}