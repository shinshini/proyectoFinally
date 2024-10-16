package com.example.proyect.view
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyect.R
import com.example.proyect.model.PlanDia
import com.example.proyect.model.Receta

class DetalleDiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_dia)

        // Obtener el día y el objetivo a través de Intent extras
        val dia = intent.getStringExtra("DIA") ?: "Lunes"
        val objetivo = intent.getStringExtra("OBJETIVO") ?: "subir"
        Log.d("DetalleDiaActivity", "Día recibido: $dia, Objetivo recibido: $objetivo")

        // Mostrar el día en el TextView
        findViewById<TextView>(R.id.diaTextView).text = "Planificación para $dia"

        // Obtener el plan del día
        val planDia = obtenerPlanDelDia(dia, objetivo)

        // Mostrar los datos en la UI
        mostrarPlanComidas(planDia)

        val volverButton: Button = findViewById(R.id.volverAPlanificacionButton)
        volverButton.setOnClickListener {
            // Iniciar la actividad de "Planificación"
            val intent = Intent(this, PlanificacionActivity::class.java)
            intent.putExtra("OBJETIVO", "bajar") // O el objetivo seleccionado por el usuario
            startActivity(intent)
        }

    }


    private fun mostrarPlanComidas(planDia: PlanDia) {

        // Desayuno
        findViewById<TextView>(R.id.desayunoTextView).text = planDia.desayuno.titulo
        findViewById<ImageView>(R.id.desayunoImageView).setImageResource(planDia.desayuno.imagenResId)
        findViewById<TextView>(R.id.desayunoIngredientesTextView).text = planDia.desayuno.ingredientes
        findViewById<TextView>(R.id.desayunoPreparacionTextView).text = planDia.desayuno.preparacion

        // Merienda
        findViewById<TextView>(R.id.meriendaTextView).text = planDia.merienda.titulo
        findViewById<ImageView>(R.id.meriendaImageView).setImageResource(planDia.merienda.imagenResId)
        findViewById<TextView>(R.id.meriendaIngredientesTextView).text = planDia.merienda.ingredientes
        findViewById<TextView>(R.id.meriendaPreparacionTextView).text = planDia.merienda.preparacion

        // Almuerzo
        findViewById<TextView>(R.id.almuerzoTextView).text = planDia.almuerzo.titulo
        findViewById<ImageView>(R.id.almuerzoImageView).setImageResource(planDia.almuerzo.imagenResId)
        findViewById<TextView>(R.id.almuerzoIngredientesTextView).text = planDia.almuerzo.ingredientes
        findViewById<TextView>(R.id.almuerzoPreparacionTextView).text = planDia.almuerzo.preparacion

        // Cena
        findViewById<TextView>(R.id.cenaTextView).text = planDia.cena.titulo
        findViewById<ImageView>(R.id.cenaImageView).setImageResource(planDia.cena.imagenResId)
        findViewById<TextView>(R.id.cenaIngredientesTextView).text = planDia.cena.ingredientes
        findViewById<TextView>(R.id.cenaPreparacionTextView).text = planDia.cena.preparacion
    }

    private fun obtenerPlanDelDia(dia: String, objetivo: String): PlanDia {
        return when (objetivo) {
            "subir" -> planSubirPeso(dia)
            "bajar" -> planBajarPeso(dia)
            "mantener" -> planMantenerPeso(dia)
            else -> PlanDia(
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible")
            )
        }
    }

    private fun planSubirPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    " Tortilla de Espinacas y Queso",
                    R.drawable.tortilla,
                    "Ingredientes:\n " +
                            "3 huevos\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 taza de queso cheddar rallado\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Bate los huevos en un tazón y añade sal y pimienta.\n" +
                            "2.- Calienta el aceite en una sartén a fuego medio y añade las espinacas hasta que se marchiten.\n" +
                            "3.- Agrega los huevos batidos y cocina por unos minutos.\n" +
                            "4.- Espolvorea el queso por encima y cocina hasta que los huevos estén firmes y el queso se derrita."
                ),
                Receta(
                    "Batido de Plátano y Mantequilla de Maní",
                    R.drawable.plamani,
                    "Ingredientes:\n" +
                            " 1 plátano\n" +
                            "2 cucharadas de mantequilla de maní\n" +
                            "1 taza de leche (puede ser entera o de almendra)\n" +
                            "1 cucharada de miel",
                    "Preparacion:\n" +
                            "En una licuadora, mezcla el plátano, la mantequilla de maní, la leche y la miel.\n" +
                            "Licúa hasta obtener una mezcla homogénea y cremosa.\n" +
                            "Sirve frío."
                ),
                Receta(
                    "Ensalada de Pollo con Palta y Nueces",
                    R.drawable.ensapollo,
                    "Ingredientes: \n" +
                            "1 pechuga de pollo a la parrilla, en trozos\n" +
                            "1 Palta, en cubos\n" +
                            "1/2 taza de nueces\n" +
                            "2 tazas de lechuga mixta\n" +
                            "Aderezo de aceite de oliva y vinagre",
                    "Preparacion: \n" +
                            "1.-En un tazón grande, combina la lechuga, el pollo, el aguacate y las nueces.\n" +
                            "2.-Rocía el aderezo por encima y mezcla suavemente para no aplastar el aguacate"
                ),
                Receta(
                    "Pasta con Salsa de Tomate y Albóndigas",
                    R.drawable.pastatoma,
                    "Ingredientes:\n" +
                            " 200 g de pasta (espagueti o la que prefieras)\n" +
                            "1 taza de salsa de tomate\n" +
                            "4 albóndigas de carne (pueden ser compradas o caseras)\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Queso parmesano rallado para servir",
                    "Preparacion \n" +
                            "1.-Cocina la pasta según las instrucciones del paquete.\n" +
                            "2.-Mientras se cocina, calienta el aceite en una sartén y agrega las albóndigas hasta que estén doradas.\n" +
                            "3.-Añade la salsa de tomate y cocina a fuego lento durante 10 minutos.\n" +
                            "4.-Sirve la pasta con la salsa y las albóndigas, espolvoreando queso parmesano por encima."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Panqueques de Avena y Plátano",
                    R.drawable.panqueavena,
                    "Ingredientes:\n" +
                            "1 taza de avena\n" +
                            "2 plátanos maduros\n" +
                            "2 huevos\n" +
                            "1/2 taza de leche\n" +
                            "1 cucharadita de polvo para hornear",
                    "Preparacion:\n" +
                            "1.-En un tazón, mezcla la avena, los plátanos, los huevos, la leche y el polvo para hornear hasta obtener una mezcla homogénea.\n" +
                            "2.-Calienta una sartén a fuego medio y vierte un poco de la mezcla para formar los panqueques.\n" +
                            "3.-Cocina hasta que se formen burbujas en la superficie, luego voltea y cocina el otro lado.\n" +
                            "4.-Sirve con miel o jarabe de arce."
                ),
                Receta(
                    "Tostadas de Aguacate con Salmón Ahumado",
                    R.drawable.tostadosalmo,
                    "Ingredientes: \n" +
                            "2 rebanadas de pan integral\n" +
                            "1 aguacate maduro\n" +
                            "100 g de salmón ahumado\n" +
                            "Jugo de limón, sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Tuesta las rebanadas de pan hasta que estén doradas.\n" +
                            "2.- Machaca el aguacate y mézclalo con el jugo de limón, sal y pimienta.\n" +
                            "3.- Unta la mezcla de aguacate sobre las tostadas y coloca el salmón ahumado encima."
                ),
                Receta(
                    "Bowl de Arroz Integral con Pollo y Verduras",
                    R.drawable.bowlarroz,
                    "Ingredientes:\n" +
                            " 1 taza de arroz integral cocido\n" +
                            "1 pechuga de pollo, asada y desmenuzada\n" +
                            "1/2 taza de brócoli al vapor\n" +
                            "1/2 taza de pimientos rojos asados\n" +
                            "Salsa de soya al gusto",
                    "Preparacion:\n" +
                            "1.- En un tazón, mezcla el arroz, el pollo, el brócoli y los pimientos.\n" +
                            "2.- Agrega salsa de soya al gusto y mezcla bien."
                ),
                Receta(
                    " Pasta con Pesto y Pollo",
                    R.drawable.pastapesto,
                    "Ingredientes:\n" +
                            " 200 g de pasta (tipo penne)\n" +
                            "1 pechuga de pollo, a la parrilla y cortada en trozos\n" +
                            "1/2 taza de pesto\n" +
                            "1/4 de taza de nueces, picadas",
                    "Preparacion:\n" +
                            "1.-Cocina la pasta según las instrucciones del paquete.\n" +
                            "2.-Mezcla la pasta cocida con el pesto y el pollo.\n" +
                            "3.-Espolvorea las nueces por encima antes de servir."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Avena Cocida con Frutas y Nueces",
                    R.drawable.avenaconfrutas,
                    "Ingredientes:\n" +
                            "1 taza de avena\n" +
                            "2 tazas de leche (puede ser entera o de almendra)\n" +
                            "1/2 manzana, en cubos\n" +
                            "1/4 de taza de nueces\n" +
                            "1 cucharadita de canela",
                    "Preparacion:\n" +
                            "Tuesta el pan, aplasta el aguacate sobre la tostada y sazona con sal y pimienta."
                ),
                Receta(
                    "Hummus con Palitos de Verdura",
                    R.drawable.hummusverdura,
                    "Ingredientes:\n" +
                            " 1 taza de garbanzos cocidos\n" +
                            "2 cucharadas de tahini\n" +
                            "1 diente de ajo\n" +
                            "Jugo de 1 limón\n" +
                            "Palitos de zanahoria y apio",
                    "Preparacion:\n" +
                            "1.-Mezcla los garbanzos, tahini, ajo y jugo de limón en una licuadora hasta obtener un puré suave.\n" +
                            "2.-Sirve con los palitos de verduras."
                ),
                Receta(
                    "Tacos de Frijoles y Aguacate",
                    R.drawable.tacosfrijo,
                    "Ingredientes:\n " +
                            "1 lata de frijoles negros, escurridos\n" +
                            "1 aguacate, en rodajas\n" +
                            "4 tortillas de maíz\n" +
                            "Salsa y cilantro al gusto",
                    "Preparacion:\n" +
                            "1.-Calienta las tortillas y coloca frijoles, rodajas de aguacate, salsa y cilantro.\n" +
                            "2.-Sirve caliente."
                ),
                Receta(
                    " Salmón a la Plancha con Quinoa",
                    R.drawable.salmonquinua,
                    "Ingredientes:\n" +
                            "200 g de salmón\n" +
                            "1 taza de quinoa cocida\n" +
                            "1 taza de espinacas\n" +
                            "Jugo de 1 limón",
                    "Preparacion:\n" +
                            "1.- Cocina el salmón a la plancha hasta que esté dorado.\n" +
                            "2.- Sirve sobre la quinoa cocida y añade espinacas salteadas con un poco de jugo de limón."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Tortitas de Plátano y Avena",
                    R.drawable.tortitaaven,
                    "Ingredientes:\n" +
                            "2 plátanos maduros\n" +
                            "1 taza de avena\n" +
                            "2 huevos\n" +
                            "Canela al gusto",
                    "Preparacion:\n" +
                            "1.- Tritura los plátanos y mezcla con la avena, huevos y canela.\n" +
                            "2.- Cocina pequeñas porciones en una sartén caliente hasta dorar."
                ),
                Receta(
                    "Batido de Yogur y Espinacas",
                    R.drawable.yogurespinaca,
                    "Ingredientes:\n" +
                            " 1 taza de yogur natural\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 plátano\n" +
                            "1 cucharada de miel",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora hasta obtener un batido suave."
                ),
                Receta(
                    "Wrap de Pollo y Verduras",
                    R.drawable.wrappollo,
                    "Ingredientes:\n" +
                            " 1 tortilla integral\n" +
                            "100 g de pollo asado, en tiras\n" +
                            "1/2 taza de lechuga\n" +
                            "1/4 de taza de zanahorias ralladas\n" +
                            "Salsa de yogur",
                    "Preparacion:\n" +
                            "1.- Coloca el pollo, lechuga, zanahorias y salsa en la tortilla.\n" +
                            "2.- Enrolla y corta a la mitad para servir."
                ),
                Receta(
                    " Guiso de Lentejas",
                    R.drawable.guisolenteja,
                    "Ingredientes:\n" +
                            "1 taza de lentejas cocidas\n" +
                            "1 zanahoria, picada\n" +
                            "1 cebolla, picada\n" +
                            "2 tazas de caldo de verduras\n" +
                            "1 cucharada de aceite de oliva",
                    "Preparacion:\n" +
                            "1.- Sofríe la cebolla y zanahoria en aceite hasta que estén tiernas.\n" +
                            "2.- Añade las lentejas y el caldo, cocina a fuego lento durante 20 minutos."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Chía Pudding con Frutas",
                    R.drawable.puddingchia,
                    "ingredientes:\n" +
                            "1/4 de taza de semillas de chía\n" +
                            "1 taza de leche de almendra\n" +
                            "1 cucharadita de miel\n" +
                            "Frutas para decorar (fresas, kiwi, etc.)",
                    "Preparacion:\n " +
                            "1.-Mezcla las semillas de chía con la leche y la miel, deja reposar en el refrigerador durante la noche.\n" +
                            "2.-Sirve con frutas por encima."
                ),
                Receta(
                    "Bolitas Energéticas de Cacao",
                    R.drawable.bolitascacao,
                    "Ingredientes:\n" +
                            " 1 taza de dátiles\n" +
                            "1/2 taza de nueces\n" +
                            "2 cucharadas de cacao en polvo",
                    "Preparacion:\n" +
                            "1.- Mezcla los dátiles, nueces y cacao en una procesadora hasta obtener una masa.\n" +
                            "2.- Forma bolitas y refrigera."
                ),
                Receta(
                    "Ensalada de Atún y Garbanzos",
                    R.drawable.ensaatun,
                    "Ingredientes:\n" +
                            " 1 lata de atún, escurrido\n" +
                            "1 taza de garbanzos cocidos\n" +
                            "1/2 cebolla roja, picada\n" +
                            "1/2 taza de pimientos, en cubos\n" +
                            "Aderezo de aceite de oliva y limón",
                    "Preparacion:\n" +
                            "Mezcla todos los ingredientes en un tazón y adereza al gusto."
                ),
                Receta(
                    " Pechuga de Pollo al Limón con Verduras Asadas",
                    R.drawable.polloverduasada,
                    "Ingredientes:\n" +
                            "200 g de pechuga de pollo\n" +
                            "1 taza de calabacín, en rodajas\n" +
                            "1 taza de zanahorias, en rodajas\n" +
                            "Jugo de 1 limón\n" +
                            "1 cucharada de aceite de oliva",
                    "Preparacion:\n" +
                            "1.- Precalienta el horno a 200 °C.\n" +
                            "2.- Marina el pollo con jugo de limón y aceite de oliva durante 30 minutos.\n" +
                            "3.- Coloca el pollo y las verduras en una bandeja y hornea durante 25-30 minutos."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Tostadas Francesas con Frutas",
                    R.drawable.tostadafruta,
                    "Ingredientes:\n" +
                            "2 rebanadas de pan integral\n" +
                            "2 huevos\n" +
                            "1/2 taza de leche\n" +
                            "1/2 cucharadita de canela\n" +
                            "Frutas para decorar (fresas, arándanos)",
                    "Preparacion:\n" +
                            "1.- Bate los huevos, la leche y la canela en un tazón.\n" +
                            "2.- Sumerge las rebanadas de pan en la mezcla y cocínalas en una sartén hasta dorar por ambos lados.\n" +
                            "3.- Sirve con frutas por encima."
                ),
                Receta(
                    " Frutos Secos y Chocolate",
                    R.drawable.frutochoco,
                    "Ingredientes:\n" +
                            " 1/2 taza de nueces, almendras y avellanas\n" +
                            "1/4 de taza de chocolate negro",
                    "Preparacion:\n" +
                            "1.- Mezcla los frutos secos con el chocolate troceado.\n" +
                            "2.- Disfruta como snack energético."
                ),
                Receta(
                    "Bowl de Arroz y Frijoles",
                    R.drawable.arrozfrijol,
                    "Ingredientes:\n" +
                            " 1 taza de arroz integral cocido\n" +
                            "1 taza de frijoles negros\n" +
                            "1/2 palta, en rodajas\n" +
                            "Salsa al gusto",
                    "Preparacion:\n" +
                            "1.- En un tazón, coloca el arroz, los frijoles y el aguacate.\n" +
                            "2.- Añade la salsa de tu elección y mezcla."
                ),
                Receta(
                    "Salmón al Horno con Espinacas",
                    R.drawable.salmonhorno,
                    "Ingredientes:\n" +
                            "200 g de salmón\n" +
                            "2 tazas de espinacas frescas\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Limón para rociar",
                    "Preparacion:\n" +
                            "1.- Precalienta el horno a 180 °C.\n" +
                            "2.- Coloca el salmón en una bandeja, rocía con aceite de oliva y limón.\n" +
                            "3.- Hornea durante 15-20 minutos. Saltea las espinacas en una sartén hasta que se marchiten y sirve junto al salmón.\n"
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Huevos Revueltos con Espinacas y Queso",
                    R.drawable.huevorevuelto,
                    "Ingredientes:\n" +
                            "3 huevos\n" +
                            "1 taza de espinacas\n" +
                            "1/4 de taza de queso feta\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Bate los huevos con sal y pimienta.\n" +
                            "2.- Cocina las espinacas en una sartén y luego añade los huevos, revolviendo hasta que estén cocidos.\n" +
                            "3.- Agrega el queso feta antes de servir."
                ),
                Receta(
                    " Batido de Mango y Coco",
                    R.drawable.mangococo,
                    "Ingredientes:\n" +
                            " 1 taza de mango fresco o congelado\n" +
                            "1 taza de leche de coco\n" +
                            "1 plátano\n" +
                            "1 cucharada de miel (opcional)",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora hasta que esté suave y cremoso.\n" +
                            "2.- Sirve frío."
                ),
                Receta(
                    "Ensalada de Garbanzos y Tomate",
                    R.drawable.garbanzotomate,
                    "Ingredientes:\n" +
                            "1 taza de garbanzos cocidos\n" +
                            "1 tomate grande, picado\n" +
                            "1/4 de cebolla roja, picada\n" +
                            "Jugo de limón, sal y pimienta",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón.\n" +
                            "2.- Añade sal, pimienta y jugo de limón al gusto."
                ),
                Receta(
                    " Pasta Integral con Salsa de Tomate y Albahaca",
                    R.drawable.pastatomatealbahaca,
                    "Ingredientes:\n" +
                            "1 taza de pasta integral\n" +
                            "1 taza de salsa de tomate\n" +
                            "Albahaca fresca al gusto",
                    "Preparacion:\n" +
                            "1.- Cocina la pasta según las instrucciones del paquete.\n" +
                            "2.- Mezcla con la salsa de tomate y añade albahaca fresca.\n"
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible")
            )
        }
    }

    private fun planBajarPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    "Yogur con Frutas y Semillas",
                    R.drawable.yogurfrutillasemilla,
                    "Ingredientes:\n" +
                            " 1 taza de yogur natural\n" +
                            "1/2 taza de fresas picadas\n" +
                            "1/2 plátano en rodajas\n" +
                            "1 cucharada de semillas de chía",
                    "Preparacion:\n" +
                            "Mezcla todos los ingredientes en un tazón y disfruta."
                ),
                Receta(
                    "Palitos de Zanahoria y Hummus",
                    R.drawable.palitoszanahoria,
                    "Ingredientes:\n" +
                            " 1 zanahoria grande, cortada en palitos\n" +
                            "1/4 de taza de hummus",
                    "Preparaion:\n" +
                            "1.- Sirve los palitos de zanahoria con hummus para mojar."
                ),
                Receta(
                    "Ensalada de Pollo a la Parrilla",
                    R.drawable.polloparilla,
                    "Ingredientes:\n" +
                            " 150 g de pechuga de pollo a la parrilla\n" +
                            "2 tazas de espinacas\n" +
                            "1/2 aguacate\n" +
                            "1/2 tomate\n" +
                            "Aderezo de limón y aceite de oliva",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón y añade el aderezo."
                ),
                Receta(
                    "Pescado al Horno con Verduras",
                    R.drawable.hornoverdura,
                    "Ingredientes:\n" +
                            " 150 g de filete de pescado (como salmón)\n" +
                            "1 taza de brócoli\n" +
                            "1 zanahoria en rodajas\n" +
                            "1 cucharadita de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Coloca el pescado y las verduras en una bandeja para hornear, rocía con aceite, sal y pimienta. Hornea a 200°C durante 20 minutos."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Avena con Frutas",
                    R.drawable.avenamanzana,
                    "Ingredientes:\n" +
                            "1/2 taza de avena\n" +
                            "1 taza de agua o leche\n" +
                            "1/2 manzana en trozos\n" +
                            "1 cucharada de miel",
                    "preparacion:\n" +
                            "1.-Cocina la avena en agua o leche. Añade la manzana y la miel al final."
                ),
                Receta(
                    "Batido Verde",
                    R.drawable.batidoverde,
                    "Ingredientes:\n" +
                            " 1 taza de espinacas\n" +
                            "1/2 plátano\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharada de mantequilla de almendra",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Quinoa con Verduras Asadas",
                    R.drawable.quinuaasada,
                    "Ingredientes:\n " +
                            "1/2 taza de quinoa cocida\n" +
                            "1/2 taza de pimientos y calabacín asados\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta",
                    "Preparacion:\n" +
                            "1.-Mezcla la quinoa con las verduras asadas y añade aceite, sal y pimienta."
                ),
                Receta(
                    " Sopa de Lentejas",
                    R.drawable.sopalenteja,
                    "Ingredientes:\n" +
                            " 1/2 taza de lentejas\n" +
                            "1 zanahoria picada\n" +
                            "1/2 cebolla picada\n" +
                            "1 litro de caldo de verduras",
                    "Preparacion:\n" +
                            "1.- Cocina todos los ingredientes en una olla a fuego medio hasta que las lentejas estén tiernas."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Tostadas de Palta",
                    R.drawable.tostadapalta,
                    "Ingredientes:\n" +
                            "1 rebanada de pan integral\n" +
                            "1/2 aguacate\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Tuesta el pan, aplasta el aguacate sobre la tostada y sazona con sal y pimienta."
                ),
                Receta(
                    "Manzana con Mantequilla de Almendra",
                    R.drawable.manzamante,
                    "Ingredientes:\n" +
                            " 1 manzana\n" +
                            "1 cucharada de mantequilla de almendra",
                    "Preparacion:\n" +
                            "1.- Corta la manzana en rodajas y unta la mantequilla de almendra."
                ),
                Receta(
                    "Ensalada de Garbanzos",
                    R.drawable.esnsagarbanzo,
                    "Ingredientes:\n" +
                            " 1 taza de garbanzos cocidos\n" +
                            "1/2 pepino picado\n" +
                            "1/2 cebolla roja picada\n" +
                            "Jugo de limón\n" +
                            "Cilantro fresco",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Tacos de Lechuga con Pavo",
                    R.drawable.tacolechuga,
                    "Ingredientes:\n" +
                            "150 g de pavo molido\n" +
                            "1 cucharadita de especias (comino, pimentón)\n" +
                            "Hojas de lechuga",
                    "Preparacion:\n" +
                            "1.- Cocina el pavo con las especias y sirve en hojas de lechuga."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Smoothie de Plátano y Espinaca",
                    R.drawable.smotieplatano,
                    "Ingredientes:\n" +
                            "1 plátano\n" +
                            "1 taza de espinacas\n" +
                            "1/2 taza de yogur natural\n" +
                            "1/2 taza de agua",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Nueces y Frutas Secas",
                    R.drawable.frutoseconuez,
                    "Ingredientes:\n" +
                            " 1/4 de taza de nueces\n" +
                            "1/4 de taza de frutas secas (como pasas)",
                    "Preparacion:\n" +
                            "1.- Mezcla las nueces y las frutas secas."
                ),
                Receta(
                    "Wrap de Pollo y Verduras",
                    R.drawable.pollover,
                    "Ingredientes:\n" +
                            " 150 g de pollo a la parrilla\n" +
                            "1 tortilla integral\n" +
                            "1/2 taza de lechuga\n" +
                            "1/4 de aguacate",
                    "Preparacion:\n" +
                            "1.- Rellena la tortilla con pollo, lechuga y aguacate, y enrolla."
                ),
                Receta(
                    " Berenjenas al Horno",
                    R.drawable.berenjenahorno,
                    "Ingredientes:\n" +
                            "1 berenjena\n" +
                            "2 cucharadas de aceite de oliva\n" +
                            "Sal y especias al gusto",
                    "Preparacion:\n" +
                            "1.- Corta la berenjena, rocía con aceite y especias, y hornea a 200°C durante 25 minutos."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Pudding de Chía",
                    R.drawable.pudingchi,
                    "Ingredientes:\n" +
                            "1/4 de taza de semillas de chía\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharadita de miel\n" +
                            "Frutas al gusto",
                    " Preparacion:\n" +
                            "1.- Mezcla las semillas de chía con la leche y miel, deja reposar en el refrigerador durante la noche y sirve con frutas."
                ),
                Receta(
                    " Yogur con Granola",
                    R.drawable.yogurgranola,
                    "Ingredientes:\n" +
                            " 1 taza de yogur natural\n" +
                            "1/4 de taza de granola",
                    "Preparacion:\n" +
                            "1.- Mezcla el yogur con la granola."
                ),
                Receta(
                    "Tazón de Quinoa y Frijoles",
                    R.drawable.tazonquinua,
                    "Ingredientes:\n" +
                            " 1/2 taza de quinoa cocida\n" +
                            "1/2 taza de frijoles negros\n" +
                            "1/2 aguacate\n" +
                            "Salsa al gusto",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Tortilla de Espinacas",
                    R.drawable.tortillaespinaca,
                    "Ingredientes:\n" +
                            "2 huevos\n" +
                            "1 taza de espinacas\n" +
                            "1/2 cebolla",
                    "Preparacion:\n" +
                            "1.- Bate los huevos y mezcla con espinacas y cebolla. Cocina en una sartén antiadherente hasta que esté firme."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Panqueques de Avena",
                    R.drawable.panqueavenaaa,
                    "Ingredientes:\n" +
                            "1 taza de avena\n" +
                            "1 plátano\n" +
                            "1/2 taza de leche",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes y cocina en una sartén antiadherente."
                ),
                Receta(
                    " Galletas de Avena",
                    R.drawable.galletaavena,
                    "Ingredientes:\n" +
                            " 1 plátano\n" +
                            "1/2 taza de avena",
                    "Preparacion:\n" +
                            "1.- Mezcla y hornea a 180°C por 15 minutos."
                ),
                Receta(
                    "Ensalada de Atún",
                    R.drawable.ensaladaatun,
                    "Ingredientes:\n" +
                            " 1 lata de atún\n" +
                            "1/2 taza de garbanzos\n" +
                            "1/2 pepino\n" +
                            "Jugo de limón",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Verduras Salteadas",
                    R.drawable.verdusalteada,
                    "Ingredientes:\n" +
                            "1 taza de verduras variadas (pimientos, brócoli, zanahorias)\n" +
                            "1 cucharada de salsa de soja",
                    "Preparacion:\n" +
                            "1.- Saltea las verduras en una sartén con salsa de soja."
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Smoothie de Fresa y Yogur",
                    R.drawable.smotiefruti,
                    "Ingredientes:\n" +
                            "1 taza de fresas\n" +
                            "1/2 taza de yogur\n" +
                            "1/2 taza de leche",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    " Batido de Proteínas",
                    R.drawable.batidoproteina,
                    "Ingredientes:\n" +
                            " 1 cucharada de proteína en polvo\n" +
                            "1 plátano\n" +
                            "1 taza de agua o leche",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Pita de Pollo",
                    R.drawable.pitapollo,
                    "Ingredientes:\n" +
                            "150 g de pollo a la parrilla\n" +
                            "1 pan pita integral\n" +
                            "1/2 taza de ensalada",
                    "Preparacion:\n" +
                            "1.-Rellena el pan pita con pollo y ensalada.."
                ),
                Receta(
                    " Sopa de Verduras",
                    R.drawable.sopaver,
                    "Ingredientes:\n" +
                            "1 taza de verduras mixtas\n" +
                            "1 litro de caldo de verduras",
                    "Preparacion:\n" +
                            "1.- Cocina todos los ingredientes en una olla hasta que las verduras estén tiernas."
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible")
            )
        }
    }

    private fun planMantenerPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    " Crepes de Avena",
                    R.drawable.grepeavena,
                    "Ingredientes:\n" +
                            " 1 taza de avena\n" +
                            "1 taza de leche\n" +
                            "1 huevo\n" +
                            "Frutas para rellenar",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes y cocina en una sartén como crepes. Rellena con frutas."
                ),
                Receta(
                    "Yogur Griego con Miel",
                    R.drawable.yogurmiel,
                    "Ingredientes:\n" +
                            " 1 taza de yogur griego\n" +
                            "1 cucharadita de miel",
                    "Preparacion:\n" +
                            "1.- Mezcla el yogur con la miel y disfruta."
                ),
                Receta(
                    "Ensalada de Quinoa y Garbanzos",
                    R.drawable.ensaquinuagarbazo,
                    "Ingredientes:\n" +
                            " 1/2 taza de quinoa cocida\n" +
                            "1/2 taza de garbanzos cocidos\n" +
                            "1/2 pepino picado\n" +
                            "1/2 aguacate\n" +
                            "Jugo de limón",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    "Salmón al Horno con Espárragos",
                    R.drawable.salmonesparago,
                    "Ingredientes:\n" +
                            " 150 g de salmón\n" +
                            "1 taza de espárragos\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Hornea el salmón y los espárragos a 200°C durante 15-20 minutos."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Yogur con Semillas de Chía y Frutas",
                    R.drawable.yogursemillas,
                    "Ingredientes:\n" +
                            "1 taza de yogur natural\n" +
                            "1 cucharada de semillas de chía\n" +
                            "1/2 taza de fresas o arándanos",
                    " Preparacion:\n" +
                            "1.- Mezcla el yogur con las semillas de chía y añade las frutas."
                ),
                Receta(
                    "Hummus con Palitos de Pepino",
                    R.drawable.palitospepino,
                    "Ingredientes:\n" +
                            " 1/4 de taza de hummus\n" +
                            "1 pepino cortado en palitos",
                    "Preparacion:\n " +
                            "1.- Sirve el hummus con los palitos de pepino para mojar."
                ),
                Receta(
                    "Wrap de Pavo y Espinacas",
                    R.drawable.wrappavo,
                    "Ingredientes:\n" +
                            " 150 g de pechuga de pavo\n" +
                            "1 tortilla integral\n" +
                            "1 taza de espinacas\n" +
                            "Rodajas de tomate",
                    "Preparacion:\n" +
                            "1.- Rellena la tortilla con el pavo, espinacas y tomate, y enrolla."
                ),
                Receta(
                    " Pimientos Rellenos de Quinoa",
                    R.drawable.pimentos,
                    "Ingredientes:\n" +
                            "2 pimientos (rojo o verde)\n" +
                            "1 taza de quinoa cocida\n" +
                            "1/2 taza de frijoles negros, escurridos\n" +
                            "1/4 de taza de maíz\n" +
                            "1 cucharadita de comino\n" +
                            "Sal y pimienta al gusto",
                            "Preparacion:\n" +
                                    "1.- Precalienta el horno a 180 °C. Corta los pimientos por la mitad y retira las semillas. Mezcla la quinoa, frijoles, maíz y especias. Rellena los pimientos y hornea durante 25-30 minutos."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Avena Nocturna",
                    R.drawable.avenanortuna,
                    "Ingredientes:\n" +
                            "1/2 taza de avena\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharada de miel\n" +
                            "1/2 cucharadita de canela",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un recipiente y deja reposar en el refrigerador durante la noche."
                ),
                Receta(
                    "Frutas con Yogur",
                    R.drawable.frutayogurt,
                    "Ingredientes:\n" +
                            " 1 taza de frutas mixtas (kiwi, piña, fresas)\n" +
                            "1/2 taza de yogur griego",
                    "Preparacion:\n" +
                            "1.- Mezcla las frutas con el yogur y disfruta."
                ),
                Receta(
                    "Filete de Pescado a la Plancha",
                    R.drawable.filetedepescado,
                    "Ingredientes:\n" +
                            " 150 g de filete de pescado (merluza o tilapia)\n" +
                            "1 taza de espinacas salteadas\n" +
                            "1 cucharada de aceite de oliva",
                    "Preparacion:\n" +
                            "1.- Cocina el pescado en una sartén a fuego medio con aceite de oliva y sirve con las espinacas."
                ),
                Receta(
                    " Fajitas de Pollo",
                    R.drawable.fajitapollo,
                    "Ingredientes:\n" +
                            "2 pechugas de pollo, en tiras\n" +
                            "1 pimiento rojo, en tiras\n" +
                            "1 pimiento verde, en tiras\n" +
                            "1 cebolla, en tiras\n" +
                            "Especias al gusto (comino, paprika)",
                    " Preparacion:\n" +
                            "1.- Sofríe el pollo y las verduras con las especias. Sirve en tortillas integrales."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Smoothie de Mango y Espinacas",
                    R.drawable.mangoespinaca,
                    "Ingrdientes:\n" +
                            "1 taza de espinacas\n" +
                            "1/2 taza de mango congelado\n" +
                            "1 plátano\n" +
                            "1 taza de agua o leche",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora hasta que esté suave."
                ),
                Receta(
                    "Nueces y Pasas",
                    R.drawable.nuecespasas,
                    "Ingredientes:\n" +
                            " 1/4 de taza de nueces\n" +
                            "1/4 de taza de frutas secas (como pasas)",
                    "Preparacion:\n" +
                            "1.- Mezcla y disfruta como un snack."
                ),
                Receta(
                    "Sopa de Calabaza",
                    R.drawable.sopacalabaza,
                    "Ingredientes:\n" +
                            "500 g de calabaza, pelada y en cubos\n" +
                            "1 cebolla, picada\n" +
                            "2 tazas de caldo de verduras\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Sofríe la cebolla, añade la calabaza y el caldo. Cocina hasta que la calabaza esté tierna. Tritura hasta obtener una textura suave."
                ),
                Receta(
                    " Tortilla de Espinacas y Champiñones",
                    R.drawable.toritllaespinaca,
                    "Ingredientes:\n" +
                            "2 huevos\n" +
                            "1/2 taza de espinacas\n" +
                            "1/2 taza de champiñones",
                    "Preparacion:\n" +
                            "1.- Bate los huevos y añade las espinacas y champiñones. Cocina en una sartén hasta que estén firmes."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Parfait de Yogur y Granola",
                    R.drawable.yogurgranola,
                    "Ingredientes:\n" +
                            "1 taza de yogur natural\n" +
                            "1/2 taza de granola\n" +
                            "1/2 taza de frutas mixtas",
                    "Preparacion:\n" +
                            "1.-  Alterna capas de yogur, granola y frutas en un vaso."
                ),
                Receta(
                    " Batido de Frutas y Espinacas",
                    R.drawable.frutaespina,
                    "Ingredientes:\n" +
                            " 1 taza de espinacas\n" +
                            "1 plátano\n" +
                            "1/2 taza de fresas\n" +
                            "1 taza de leche de almendras",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Pollo al Curry con Arroz Integral",
                    R.drawable.pollocurry,
                    "Ingredientes:\n" +
                            " 150 g de pechuga de pollo\n" +
                            "1/2 taza de arroz integral cocido\n" +
                            "1 cucharada de curry en polvo",
                    "Preparacion:\n " +
                            "1.- Cocina el pollo en una sartén con curry y sirve sobre el arroz."
                ),
                Receta(
                    " Pizza de Coliflor",
                    R.drawable.pizzacolifor,
                    "Ingredientes:\n" +
                            "1 taza de coliflor rallada\n" +
                            "1 huevo\n" +
                            "1/2 taza de queso mozzarella\n" +
                            "Salsa de tomate\n" +
                            "Verduras al gusto",
                    "Preparacion:\n" +
                            "1.- Mezcla la coliflor, huevo y queso, forma la base y hornea. Agrega salsa y verduras y vuelve a hornear."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Tostadas Francesas Saludables",
                    R.drawable.tostadasaludable,
                    "Ingredientes:\n" +
                            "1 rebanada de pan integral\n" +
                            "1 huevo\n" +
                            "1/4 de taza de leche\n" +
                            "Canela al gusto",
                    "Preparacion:\n" +
                            "1.- Mezcla el huevo, leche y canela. Remoja el pan y cocina en una sartén hasta dorar."
                ),
                Receta(
                    " Galletas de Plátano y Avena",
                    R.drawable.galletaavenaplan,
                    "Ingredientes:\n" +
                            " 1 plátano maduro\n" +
                            "1/2 taza de avena",
                    "Preparacion:\n" +
                            "1.-Mezcla y hornea a 180°C durante 15 minutos."
                ),
                Receta(
                    " Ensalada de Pollo y Mango",
                    R.drawable.ensapollomango,
                    "Ingredientes:\n" +
                            " 150 g de pechuga de pollo\n" +
                            "1/2 mango en cubos\n" +
                            "2 tazas de lechuga",
                    "Preparacion:\n " +
                            "1.- Cocina el pollo y mézclalo con mango y lechuga."
                ),
                Receta(
                    " Salteado de Tofu y Verduras",
                    R.drawable.saltetofu,
                    "Ingredientes:\n" +
                            "150 g de tofu\n" +
                            "1 taza de verduras mixtas (brócoli, zanahoria, pimientos)\n" +
                            "Salsa de soja al gusto",
                    "Preparacion:\n" +
                            "1.- Cocina el tofu y las verduras en una sartén con salsa de soja."
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Tortilla de Claras con Espinacas y Tomate",
                    R.drawable.tortillaespitoma,
                    "Ingredientes:\n" +
                            "4 claras de huevo\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 tomate picado\n" +
                            "Sal y pimienta al gusto",
                    "Preparacion:\n" +
                            "1.- Bate las claras y vierte en una sartén caliente. Agrega las espinacas y el tomate. Cocina hasta que las claras estén firmes."
                ),
                Receta(
                    " Batido de Frutas",
                    R.drawable.batidofruta,
                    "Ingredientes:\n" +
                            " 1 taza de frutas mixtas (fresas, plátano)\n" +
                            "1 taza de leche de almendras",
                    "Preparacion:\n " +
                            "1.- Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Hamburguesa de Pavo",
                    R.drawable.hanburpavo,
                    "Ingredientes:\n" +
                            "150 g de carne de pavo\n" +
                            "1 pan integral\n" +
                            "Lechuga, tomate y cebolla al gusto",
                    "Preparacion:\n" +
                            "1.- Cocina la carne de pavo y sirve en el pan con las verduras."
                ),
                Receta(
                    " Ensalada de Espinacas y Fresas",
                    R.drawable.ensaespinacafresa,
                    "Ingredientes:\n" +
                            "2 tazas de espinacas\n" +
                            "1/2 taza de fresas en rodajas\n" +
                            "1/4 de taza de nueces\n" +
                            "Vinagreta al gusto",
                    "Preparacion:\n" +
                            "1.- Mezcla todos los ingredientes en un tazón."
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.defaulttt, "No disponible", "No disponible")
            )
        }
    }
}