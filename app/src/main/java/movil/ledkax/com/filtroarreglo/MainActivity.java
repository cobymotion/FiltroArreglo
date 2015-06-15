package movil.ledkax.com.filtroarreglo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements SearchView.OnQueryTextListener {

    String datos[] = {"UNO","DOS","TRES"};
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView)findViewById(R.id.listaDatos);
        lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem item = menu.add("Buscar");
        item.setIcon(android.R.drawable.ic_menu_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SearchView sv = new SearchView(this);
        sv.setOnQueryTextListener(this);
        item.setActionView(sv);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ArrayList<String> listas = new ArrayList<>();
        String cad2="23";
        for(String cad: datos)
            if(cad.toUpperCase().contains (newText.toUpperCase()))
                listas.add(cad);
        String datosAux[] = new String[listas.size()];
        for(int i=0;i<listas.size();i++)
             datosAux[i] = listas.get(i);
        lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datosAux));
        return false;
    }
}
