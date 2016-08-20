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
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import arena.com.petagram.R;

public class favoritas extends AppCompatActivity {
Toolbar toolbar;
LinearLayoutManager linearLayoutManager2;
    RecyclerView recyclerView2;
    ArrayList<Perro> listaPerros2;
    ArrayList<Integer> likes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        //definimos la toolbar como actionbar
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //habilitar flecha arriba
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quitamos el título
        getSupportActionBar().setTitle(null);

        //recibimos los extra (numero de likes)

        Bundle extras = getIntent().getExtras();
        if (extras !=null) {
            likes = extras.getIntegerArrayList(getResources().getString(R.string.idLikesPerros));
        }

     //colocamos el layoutmanager para el recycler view
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        //inicializamos los datos
        inicializarDatos();

        //colcamos el adaptador para nuestro recycler view2
        PerroAdaptador2 adaptador = new PerroAdaptador2(listaPerros2,likes, this);
        recyclerView2.setAdapter(adaptador);

    }




//Inicializo aquí de nuevo porque al final la posicion no cambia
    public void inicializarDatos()
    {
        listaPerros2 = new ArrayList<Perro>();

        listaPerros2.add(new Perro("Coraje", R.drawable.coraje));
        listaPerros2.add(new Perro("Pichula",R.drawable.pichula));
        listaPerros2.add(new Perro("Brako", R.drawable.brako));
        listaPerros2.add(new Perro("Pechocho", R.drawable.perroprecioso));
        listaPerros2.add(new Perro("Verga", R.drawable.verga));

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
                Toast.makeText(this, "Ya estás en favoritos", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.informacion:
                abrirInformacion();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);

        }}

    public void abrirInformacion()
    {
        Intent intent = new Intent(this, informacion.class);
        startActivity(intent);
    }

}
