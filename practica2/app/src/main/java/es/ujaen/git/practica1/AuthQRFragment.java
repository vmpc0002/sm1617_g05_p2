package es.ujaen.git.practica1;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AuthQRFragment extends Fragment {

    private Button mButton;
    private TextView textView;
    public AuthQRFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmento = inflater.inflate(R.layout.fragment_auth_qr, container, false);
        mButton = (Button) fragmento.findViewById(R.id.autenticacionQR_scan_button);
        textView = (TextView) fragmento.findViewById(R.id.textView);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });
        return fragmento;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == MainActivity.RESULT_OK) {
                //Quiere decir que se obtuvo resultado pro lo tanto:
                //Desplegamos en pantalla el contenido del código de barra scaneado
                String contents = data.getStringExtra("SCAN_RESULT");
                textView.setText(contents);
                //Desplegamos en pantalla el nombre del formato del código de barra scaneado
                //String scanFormat = scanningResult.getFormatName();
                //formatTxt.setText("Formato: " + scanFormat);
            } else {
                //Quiere decir que NO se obtuvo resultado
                Toast toast = Toast.makeText(getActivity(),
                        "No scan data received!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
