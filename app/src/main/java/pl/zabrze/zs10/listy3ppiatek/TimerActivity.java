package pl.zabrze.zs10.listy3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {
    private Button buttonStart, buttonStop,buttonZapisz,buttonReset;
    private TextView textViewCzas;
    private ListView listViewCzasy;
    private int sekundy =0;
    private boolean czyDziala = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        buttonStart =findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonReset = findViewById(R.id.buttonReset);
        buttonZapisz = findViewById(R.id.buttonZapisz);
        textViewCzas = findViewById(R.id.textViewCzas);
        listViewCzasy = findViewById(R.id.listViewCzas);
        liczCzas();
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala = true;
                    }
                }
        );
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala = false;
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy = 0;
                        wyswietlCzas(sekundy);
                    }
                }
        );
        ArrayList<String> zapisaneCzasy = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,zapisaneCzasy);
        listViewCzasy.setAdapter(adapter);
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zapisaneCzasy.add(wyswietlCzas(sekundy));
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        listViewCzasy.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        zapisaneCzasy.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                }
        );

    }
    private void liczCzas(){
        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        //co powtarzamy
                        if(czyDziala)
                            sekundy++;
                        //wyswietlanie czasu
                        wyswietlCzas(sekundy);
                        handler.postDelayed(this,1000);//jak często powtarzamy
                    }
                }
        );
    }
    private String wyswietlCzas(int sek){
        int s = sek%60;
        int h = sek/3600;
        int m = (sek/60)%60;
        String czas =String.format("%02d:%02d:%02d",h,m,s);
        textViewCzas.setText(String.format("%02d:%02d:%02d",h,m,s));
        return czas;
    }
}