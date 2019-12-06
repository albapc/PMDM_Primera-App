package com.pmdm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*
import android.widget.TextView
import org.jetbrains.anko.design.snackbar


class MainActivity : AppCompatActivity() {

    //inicializamos elementos de la interfaz.
    private var texto: TextView? = null
    private var bAceptar: Button? = null

    // se activa cuando el sistema crea la actividad por primera vez. Debe ocurrir una sola vez en toda la vida de la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        //crea la activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mensaje en la consola que se muestra al llamar al metodo
        Log.d("MisMensajes", "Estoy en el OnCreate")

        //asociamos las variables a los elementos
        texto = findViewById(R.id.textView)

        bAceptar = findViewById(R.id.accept)

        //accion que se ejecutara al pulsar el boton
        bAceptar?.setOnClickListener {
            cambiarMensaje(it)
        }
    }

    fun cambiarMensaje(v: View) {
        //variable que almacena el formato de hora
        val formato = SimpleDateFormat("HH:mm:ss")
        //variable que almacena la fecha actual
        val fechaActual = Calendar.getInstance().getTime()

        val s = formato.format(fechaActual)
        //muestra la hora en la caja de texto
        texto?.setText(String.format("Botón presionado: %s", s))

        //mensaje toast
        //toast(R.string.toast)

        //mensaje snackbar
        v.snackbar(R.string.toast)
    }


    //hace que el usuario pueda ver la actividad, mientras la app se prepara para que esta entre en primer plano y se convierta en interactiva
    override fun onStart() {
        super.onStart()
        Log.d("MisMensajes", "Estoy en el OnStart")
    }

    /*
    Cuando la actividad entra en el estado Resumed, pasa al primer plano y, a continuación, el sistema invoca la devolución de llamada onResume().
    Este es el estado en el que la app interactúa con el usuario. La app permanece en este estado hasta que ocurre algún evento que la quita de foco.
    Tal evento podría ser, por ejemplo, recibir una llamada telefónica, que el usuario navegue a otra actividad o que se apague la pantalla del dispositivo.
     */
    override fun onResume() {
        super.onResume()
        Log.d("MisMensajes", "Estoy en el OnResume")
    }

    /*
     indica que la actividad ya no está en primer plano (aunque puede seguir siendo visible si el usuario está en el modo multiventana).
     Utiliza el método onPause() para pausar o ajustar las operaciones que no deben continuar (o que deben continuar con moderación) mientras
     Activity se encuentra en estado Paused, y que esperas reanudar en breve.
     */
    override fun onPause() {
        super.onPause()
        Log.d("MisMensajes", "Estoy en el OnPause")
    }

    /*
    Cuando el usuario ya no puede ver tu actividad, significa que ha entrado en el estado Stopped, y el sistema invoca la devolución de llamada onStop().
    Esto puede ocurrir, por ejemplo, cuando una actividad recién lanzada cubre toda la pantalla. El sistema también puede llamar a onStop() cuando haya
    terminado la actividad y esté a punto de finalizar.
     */
    override fun onStop() {
        super.onStop()
        Log.d("MisMensajes", "Estoy en el OnStop")
    }

    /*
    Se le llama antes de que finalice la actividad. El sistema invoca esta devolución de llamada por los siguientes motivos:
    1.- La actividad está terminando (debido a que el usuario la descarta por completo o a que se llama a finish()).
    2.- El sistema está finalizando temporalmente la actividad debido a un cambio de configuración (como la rotación de la pantalla o el modo multiventana).
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MisMensajes", "Estoy en el OnDestroy")
    }
}
