package com.sena.konstruapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sena.konstruapp.Fragmentos.FragmentCarrito
import com.sena.konstruapp.Fragmentos.FragmentInicio
import com.sena.konstruapp.Fragmentos.FragmentPerfil
import com.sena.konstruapp.databinding.ActivityMainBinding

/*@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val items = listOf(
            GridItem(R.drawable.image1, "Título 1", "Descripción 1"),
            GridItem(R.drawable.image2, "Título 2", "Descripción 2"),
            GridItem(R.drawable.image3, "Título 3", "Descripción 3"),
            GridItem(R.drawable.image4, "Título 4", "Descripción 4"),
            GridItem(R.drawable.image5, "Título 5", "Descripción 5"),
            GridItem(R.drawable.image6, "Título 6", "Descripción 6"),
            GridItem(R.drawable.image7, "Título 7", "Descripción 7"),
            GridItem(R.drawable.image8, "Título 8", "Descripción 8"),
            GridItem(R.drawable.image9, "Título 9", "Descripción 9"),
            GridItem(R.drawable.image10, "Título 10", "Descripción 10"),
            GridItem(R.drawable.image11, "Título 11", "Descripción 11"),
            GridItem(R.drawable.image12, "Título 12", "Descripción 12"),
            // Agrega más elementos si es necesario
        )

        val adapter = GridAdapter(items)
        recyclerView.adapter = adapter


        // Configura el toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Deshabilita el tiúlo por defecto

        // Configura el bottom navigation menu
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Item_Inicio -> {
                    // Maneja la selección del elemento "Inicio"
                    true
                }
                R.id.Item_Perfil -> {
                    // Maneja la selección del elemento "Perfil"
                    true
                }
                R.id.Item_Carrito -> {
                    // Maneja la selección del elemento "Carrito"
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú desde el archivo de recursos
        menuInflater.inflate(R.menu.menu_main, menu)

        // Configura la búsqueda
        val searchMenuItem = menu?.findItem(R.id.action_search)
        searchView = SearchView(this)
        searchView.queryHint = "Buscar..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    performSearch(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        searchMenuItem?.actionView = searchView

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Maneja las acciones de los elementos del menú
        return when (item.itemId) {
            R.id.action_notifications -> {
                // Acción para el elemento de notificaciones
                true
            }
            R.id.toolbar->{
             // Acción para la barra superior del icono de menu
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun performSearch(query: String) {
        // Aquí puedes realizar la acción de búsqueda con el texto ingresado
        // Por ejemplo, puedes filtrar una lista o navegar a una actividad de resultados de búsqueda
        // ...
    }
}
*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verFragmentInicio()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Item_Inicio -> {
                    // Maneja la selección del elemento "Inicio"
                    verFragmentInicio()
                    true
                }

                R.id.Item_Perfil -> {
                    // Maneja la selección del elemento "Perfil"
                    verFragmentPerfil()
                    true
                }

                R.id.Item_Carrito -> {
                    // Maneja la selección del elemento "Carrito"
                    verFragmentCarrito()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
    private fun verFragmentInicio() {
        binding.TituloRl.text = "Inicio"
        val fragment = FragmentInicio ()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentInicio").commit()

    }
    private fun verFragmentPerfil() {
        binding.TituloRl.text = "Perfil"
        val fragment = FragmentPerfil ()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentPerfil").commit()

    }
    private fun verFragmentCarrito() {
        binding.TituloRl.text = "Carrito"
        val fragment = FragmentCarrito ()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id,fragment,"FragmentCarrito").commit()

    }
}