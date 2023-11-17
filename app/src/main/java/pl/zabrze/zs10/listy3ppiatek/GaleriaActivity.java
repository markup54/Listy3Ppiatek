package pl.zabrze.zs10.listy3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class GaleriaActivity extends AppCompatActivity {
    private ImageView imageView;
    private Spinner spinner;
    private Button buttonWstecz, buttonDalej;
    private int aktualny = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        imageView = findViewById(R.id.imageView);
        buttonDalej = findViewById(R.id.buttonDalej);
        buttonWstecz = findViewById(R.id.buttonWstecz);
        int obrazki [] =new int[]{
                R.drawable.szczeliniec,
                R.drawable.bledne,
                R.drawable.grzyb
        };
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualny --;
                        if(aktualny <0)
                            aktualny = obrazki.length-1;
                        imageView.setImageResource(obrazki[aktualny]);
                    }
                }
        );
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        aktualny =i;
                        imageView.setImageResource(obrazki[aktualny]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
    }
}