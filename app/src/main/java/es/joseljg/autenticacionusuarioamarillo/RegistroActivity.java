package es.joseljg.autenticacionusuarioamarillo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import clases.Usuario;

public class RegistroActivity extends AppCompatActivity {

    public static final String EXTRA_OBJETO_USUARIO = "es.joseljg.RegistroActivity.objeto_usuario";
    EditText edt_nombrer = null;
    EditText edt_emailr = null;
    EditText edt_passwordr1 = null;
    EditText edt_passwordr2 = null;
    EditText edt_telefonor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edt_nombrer = (EditText)findViewById(R.id.edt_nombrer);
        edt_emailr = (EditText) findViewById(R.id.edt_emailr);
        edt_passwordr1 = (EditText) findViewById(R.id.edt_passwordr1);
        edt_passwordr2 = (EditText) findViewById(R.id.edt_passwordr2);
        edt_telefonor = (EditText) findViewById(R.id.edt_telefonor);

    }

    public void registrarse(View view) {
        String contrasena1 = String.valueOf(edt_passwordr1.getText());
        String contrasena2 = String.valueOf(edt_passwordr2.getText());
        if(!contrasena1.equals(contrasena2))
        {
            edt_passwordr1.setError("las contraseñas no coinciden");
            Toast.makeText(this,"las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            return;
        }
        String nombre = String.valueOf(edt_nombrer.getText());
        String email = String.valueOf(edt_emailr.getText());
        String telefono = String.valueOf(edt_telefonor);
        Usuario user1 = new Usuario(email, nombre, contrasena1 , telefono);
        Intent intent = new Intent(this, ActivityHome.class);
        intent.putExtra(EXTRA_OBJETO_USUARIO, user1);
        startActivity(intent);
        finish();
    }

    public void volverlogin(View view) {
        finish();
    }
}