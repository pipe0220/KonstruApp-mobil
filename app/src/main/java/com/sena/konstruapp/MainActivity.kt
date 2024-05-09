package com.sena.konstruapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

/*class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura el toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configura el bottom navigation menu
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Maneja la selección del elemento "Inicio"
                    true
                }
                R.id.nav_favorites -> {
                    // Maneja la selección del elemento "Favoritos"
                    true
                }
                R.id.nav_settings -> {
                    // Maneja la selección del elemento "Ajustes"
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Infla el menú desde el archivo de recursos
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Maneja las acciones de los elementos del menú
        return when (item.itemId) {
            R.id.action_notifications -> {
                // Acción para el elemento de notificaciones
                true
            }
            R.id.action_search -> {
                // Acción para el elemento de búsqueda
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}*/
class MainActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configura el toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configura el bottom navigation menu
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Maneja la selección del elemento "Inicio"
                    true
                }
                R.id.nav_favorites -> {
                    // Maneja la selección del elemento "Favoritos"
                    true
                }
                R.id.nav_settings -> {
                    // Maneja la selección del elemento "Ajustes"
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
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun performSearch(query: String) {
        // Aquí puedes realizar la acción de búsqueda con el texto ingresado
        // Por ejemplo, puedes filtrar una lista o navegar a una actividad de resultados de búsqueda
        // ...
    }
}