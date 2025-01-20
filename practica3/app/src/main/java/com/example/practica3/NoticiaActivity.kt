package com.example.practica3

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica3.data.noticia

class NoticiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_noticia)
        getNoticias()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noticias:List<noticia> = getNoticias()
        // Asigna el adaptador con los datos
        val adapter = CardAdapter(this, noticias)
        recyclerView.adapter = adapter
        val sharedPref = getSharedPreferences("ultima_noticia", Context.MODE_PRIVATE)
        if (sharedPref.contains("noticia")){
            Toast.makeText(
                this, sharedPref.getString("noticia", null),
                Toast.LENGTH_LONG).show()
        }
    }

    fun saveUltimaNoticia(noticia:noticia){
        val sharedPref = getSharedPreferences("ultima_noticia", Context.MODE_PRIVATE)
        with (sharedPref.edit()){
            putString("noticia", noticia.titulo)
            apply()
        }
    }

    private fun getNoticias(): List<noticia> {
        val noticiasList: List<noticia> = listOf(
        noticia(0, "Mercado de fichajes, en directo: última hora de Real Madrid, " +
                "Barcelona, Atlético", "Sigue las últimas noticias y rumores sobre los " +
                "movimientos de fichajes en los principales equipos de La Liga. Desde renovaciones " +
                "hasta posibles incorporaciones, se analizan los cambios que pueden definir la " +
                "próxima temporada.", "https://img.asmedia.epimg.net/resizer/v2/ZOPLKOG6ARFFRH3WHEQ475BKXY.jpeg?auth=9e4d993542d5230742f85a546836a16072a8f0ce800e9e3c3f2fcdeec8d4b7d1&width=644&height=362&focal=505%2C688",
            "https://as.com/futbol/primera/mercado-de-fichajes-en-directo-ultima-hora-de-ral-madrid-barcelona-atletico-n-2/" ),
        noticia(1,"Pedro Sánchez y su posible dimisión como presidente del" +
                " Gobierno, en directo: carta abierta, reacciones y últimas noticias de hoy",
            "En un momento político crítico, Pedro Sánchez reflexiona públicamente sobre su" +
                    " continuidad en el cargo. Una carta abierta y las reacciones de líderes políticos " +
                    "y ciudadanos marcan el debate sobre su futuro como presidente.", "https://fotografias.larazon.es/clipping/cmsimages01/2024/04/18/B87C49E2-CC5D-4F74-88F7-5E462E46FE89/98.jpg?crop=2000,1125,x0,y104&width=1900&height=1069&optimize=low&format=webply",
            "https://www.larazon.es/espana/directo-ultimas-noticias-amenaza-dimision-pedro-sanchez-urge-responderme-pregunta-debo-continuar-frente-gobierno_20240424662945aac18d4000019736f2.html"),

        noticia(2, "Una asociación de militares se niega a romper su acuerdo de colaboración con el club ultra Desokupa",
            "La Asociación de Tropa y Marinería Española (ATME) enfrenta críticas tras mantener su colaboración con " +
                    "Desokupa, un grupo conocido por sus vínculos con la extrema derecha.",
            "https://imagenes.elpais.com/resizer/v2/M2TMJAS7CVCCBJRDD7MCF3KFLY.jpg?auth=37d0427b65d52ee09a4982593929e6b43f82839dc5fd28c1e08caa2a76043aec&width=1200",
            "https://elpais.com/espana/2024-12-19/una-asociacion-de-militares-se-niega-a-romper-su-acuerdo-de-colaboracion-con-el-club-ultra-desokupa.html"),

        noticia(3, "El Congreso debate este martes una propuesta de Junts para frenar la \"multirreincidencia\"",
            "Junts per Catalunya propone una reforma del Código Penal y la Ley de Enjuiciamiento Criminal para endurecer las penas contra delincuentes multirreincidentes.",
            "https://fotografias.larazon.es/clipping/cmsimages01/2024/02/27/3800C56C-933B-44E0-B046-4A55BEFB8EB8/98.jpg?crop=4302,2420,x0,y224&width=1900&height=1069&optimize=low&format=webply",
            "https://www.larazon.es/espana/congreso-debate-este-martes-propuesta-junts-frenar-multirreincidencia_2024091666e7f8f0b3741e0001e7852f.html"),

        noticia(4, "El incendio de un camión provoca un atasco de 10 kilómetros en la A-7",
            "El incidente, según informa la Dirección General de Tráfico, se ha producido a las 18:30 horas de la tarde de este martes y afecta a la circulación en sentido Barcelona",
            "https://s3.ppllstatics.com/lasprovincias/www/multimedia/2025/01/14/camion-kd6B-U230533968467a5E-1200x840@Las%20Provincias.jpeg",
            "https://www.lasprovincias.es/comunitat/incendio-vehiculo-provoca-atasco-ap7-altura-betera-20250114183714-nt.html"),

        noticia(5, "Bebé nace a bordo de una embarcación de migrantes que viajaba rumbo a España",
            "Una mujer da a luz en condiciones extremas mientras viajaba en una embarcación precaria hacia España.",
            "https://media.cnn.com/api/v1/images/stellar/prod/bebe-nacio-en-bote.jpg?c=16x9&q=h_653,w_1160,c_fill/f_webp",
            "https://cnnespanol.cnn.com/2024/12/19/bebe-nace-embarcacion-migrantes-espana-trax/"),

        noticia(6, "El Gobierno justifica los viajes de Begoña Gómez con Sánchez por \"necesidades de protocolo\"",
            "La presencia de Begoña Gómez, esposa de Pedro Sánchez, en viajes oficiales genera controversia.",
            "https://fotografias.larazon.es/clipping/cmsimages01/2024/06/04/9640079D-BF7F-4B58-9084-9E23A4417156/file-spanish-prime-minister-pedro-sanchez-and-his-wife-begona-gomez-arrive-10-downing-street-london-dec-3-2019-spanish-investigative-judge-has-summone_98.jpg?crop=2396,1348,x0,y0&width=1900&height=1069&optimize=low&format=webply",
            "https://www.larazon.es/espana/gobierno-justifica-viajes-begona-gomez-sanchez-necesidades-protocolo_20240424662945aac18d4000019736f2.html"),

        noticia(7, "Cómo activar la opción de WhatsApp para transcribir audios",
            "WhatsApp lanza una nueva función que permite convertir mensajes de voz en texto. Aquí te explicamos cómo activarla paso a paso.",
            "https://imagenes.elpais.com/resizer/v2/L46M6WXILRBADPU5MP6A6DW4XE.jpg?auth=c1eaaad1d463096bb4bfc64d9e7cef7dddbc98e342b74dfff2920eebeedb4306&width=1200",
            "https://elpais.com/tecnologia/2024-12-19/como-activar-la-opcion-de-whatsapp-para-transcribir-audios.html"),

        noticia(8, "Incendios en Los Ángeles, en directo | Suben a 16 los muertos por los incendios en el sur de California",
            "Los incendios forestales en California continúan causando estragos, dejando al menos 16 fallecidos y miles de personas evacuadas.",
            "https://fotografias.lasexta.com/clipping/cmsimages01/2025/01/08/6414901A-5514-4040-A4EC-6A7F74D0552C/gran-llama-angeles_103.jpg?crop=1707,1280,x213,y0&width=1200&height=900&optimize=low&format=webply",
            "https://www.lasexta.com/noticias/internacional/incendios-los-angeles-directo-suben-16-muertos-incendios-sur-california_20241219201714.html")
        )
        return noticiasList
    }
}