package es.ujaen.git.practica1;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AuthFragment(), "clientes");
        adapter.addFragment(new AuthQRFragment(), "propietarios");
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        /*FragmentManager fragmentActivity = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentActivity.beginTransaction();

        Fragment f = fragmentActivity.findFragmentById(R.id.fragment);
        if (f == null) {
            AuthFragment authFragment = new AuthFragment().newInstance("User", "Pass", "127.0.0.1", 0);
            fragmentTransaction.add(R.id.fragment, authFragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();*/

    }

}


