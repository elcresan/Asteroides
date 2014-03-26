package org.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {
	private Button bAcercaDe;
	private Button bPunt;
	private Button bPref;
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bAcercaDe =(Button) findViewById(R.id.button03);
        bAcercaDe.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View view){
        		lanzarAcercaDe(null);	
        	}
        });
        //Servicio para escuchar musica
        startService(new Intent(this, ServicioMusica.class));
        
        bPunt =(Button) findViewById(R.id.button04);
        bPunt.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View view){
        		lanzarPuntuaciones(null);
        	}
        });
        bPref = (Button) findViewById(R.id.button02);
        bPref.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View view){
        		lanzarPreferencias(null);
        	}
        });
    }
    
     @Override
     public void onDestroy(){
    	 super.onDestroy();
    	 stopService(new Intent(this, ServicioMusica.class));
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.acercaDe:
    		lanzarAcercaDe(null);
    		break;
    	case R.id.config:
    		lanzarPreferencias(null);
    		break;
    	}
    	return true;
    }
    
    public void lanzarJuego(View view){

        Intent i = new Intent(this, Juego.class);
        startActivity(i);
      }
    
    public void lanzarPuntuaciones(View view){

        Intent i = new Intent(this, Puntuaciones.class);
        startActivity(i);
      }   
    public void lanzarAcercaDe(View view){

        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
      }

    public void lanzarPreferencias(View view){

        Intent i = new Intent(this, Preferencias.class);
        startActivity(i);
      }

}
