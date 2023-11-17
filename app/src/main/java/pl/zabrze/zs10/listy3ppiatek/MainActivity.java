package pl.zabrze.zs10.listy3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewMysli;
    private ArrayList<String> mysli = new ArrayList<>();
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysli.add("Kto jada ostatki ten jest tłusty i gładki");
        mysli.add("Lepszy rydz niż nic");
        mysli.add("Nic nie jest szczególnie trudne, jeżeli podzielisz to na małe zadania.");
        mysli.add("Nie odniosłem porażki. Po prostu odkryłem 10.000 błędnych rozwiązań. ");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mysli
        );
        listViewMysli = findViewById(R.id.listView2);
        listViewMysli.setAdapter(adapter);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextMysl);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String mysl = editText.getText().toString();
                        mysli.add(mysl);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                }
        );
        listViewMysli.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        mysli.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }
}