package arena.com.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Perro> listaPerros;
    private RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //definir la toolbar como actionbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //quitamos el título
        getSupportActionBar().setTitle(null);


        inicializarDatos();
        inicializarAdaptador();

    }



    private void inicializarAdaptador() {

        PerroAdaptador adaptador = new PerroAdaptador(listaPerros, this);
        recyclerView.setAdapter(adaptador);

    }

    //Inicializando el pollo (POJO)
   public void inicializarDatos()
    {
        listaPerros = new ArrayList<Perro>();

        listaPerros.add(new Perro("Coraje", R.drawable.coraje));
        listaPerros.add(new Perro("Pichula",R.drawable.pichula));
        listaPerros.add(new Perro("Brako", R.drawable.brako));
        listaPerros.add(new Perro("Pechocho", R.drawable.perroprecioso));
        listaPerros.add(new Perro("Verga", R.drawable.verga));

    }

    //inflo el menu para esta activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return  super.onCreateOptionsMenu(menu);

    }

    //coloco un "listener" de los elementos del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.verFavoritos:
                abrirFavoritos();
                return true;

            case R.id.informacion:
                abrirInformacion();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }

    }

    public void abrirFavoritos()
    {


        Intent intent = new Intent(this, favoritas.class);
        ArrayList<Integer> likes = new ArrayList<Integer>();

        for(Perro perro: listaPerros)
        {
            likes.add(perro.getLikes());
        }

        intent.putExtra(getResources().getString(R.string.idLikesPerros), likes);
          startActivity(intent);
    }

    public void abrirInformacion()
    {
        Intent intent = new Intent(this, informacion.class);
        startActivity(intent);
    }

}
