package pl.zabrze.zs10.listy3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class GaleriaActivity extends AppCompatActivity {
    private ImageView imageView;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        imageView = findViewById(R.id.imageView);
        int obrazki [] =new int[]{
                R.drawable.szczeliniec,
                R.drawable.bledne,
                R.drawable.grzyb
        };
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int ktory =i;
                        imageView.setImageResource(obrazki[ktory]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
    }
}