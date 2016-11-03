package es.ujaen.git.practica1;

/**
 * @author Emilio Sánchez Catalán y Víctor Manuel Pérez Cámara
 * @version 1.0
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ServicioRemotoActivity extends AppCompatActivity {
    TextView user, pass, port, ip;

    /**
     * Metodo encargado de la recepción de los valores de autentificación.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String muser, mpass, mip;
        int mport;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicio_remoto);
        user = (TextView) findViewById(R.id.servicio_remoto_user_textview);
        pass = (TextView) findViewById(R.id.servicio_remoto_pass_textview);
        port = (TextView) findViewById(R.id.servicio_remoto_port_textview);
        ip = (TextView) findViewById(R.id.servicio_remoto_ip_textview);
        muser = getIntent().getStringExtra("user");
        mpass = getIntent().getStringExtra("pass");
        mport = getIntent().getIntExtra("port", 4);
        mip = getIntent().getStringExtra("ip");

        user.setText(muser);
        pass.setText(mpass);
        port.setText(Integer.toString(mport));
        ip.setText(mip);
    }
}
