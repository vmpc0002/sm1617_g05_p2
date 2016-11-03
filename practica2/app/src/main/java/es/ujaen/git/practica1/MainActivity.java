package es.ujaen.git.practica1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Emilio Sánchez Catalán y Víctor Manuel Pérez Cámara
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Metodo encargado de crear la Activity principal. Donde se vincula la activity al layout principal
     * y realiza la transacción con el fragmento Authfragment.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentActivity = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentActivity.beginTransaction();

        Fragment f = fragmentActivity.findFragmentById(R.id.fragment);
        if (f == null) {
            AuthFragment authFragment = new AuthFragment().newInstance("User", "Pass", "127.0.0.1", 0);
            fragmentTransaction.add(R.id.fragment, authFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}


