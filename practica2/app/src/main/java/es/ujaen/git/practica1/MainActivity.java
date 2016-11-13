package es.ujaen.git.practica1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * @author Emilio Sánchez Catalán y Víctor Manuel Pérez Cámara
 * @version 1.0
 */
public class MainActivity extends Activity {

    /**
     * Metodo encargado de crear la Activity principal. Donde se vincula la activity al layout principal
     * y realiza la transacción con el fragmento Authfragment.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentActivity = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentActivity.beginTransaction();

        Fragment f = fragmentActivity.findFragmentById(R.id.main_fragment);

        if (f == null) {
            AuthQRFragment authQRFragment = new AuthQRFragment();
            fragmentTransaction.add(R.id.main_fragment, authQRFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();

    }


}


