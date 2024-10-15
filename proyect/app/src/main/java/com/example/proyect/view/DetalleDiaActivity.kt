package com.example.proyect.view
import android.os.Bundle
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

        // Suponiendo que el día y el objetivo se pasan a través de Intent extras
        val dia = intent.getStringExtra("DIA") ?: "Lunes"
        val objetivo = intent.getStringExtra("OBJETIVO") ?: "subir"

        // Obtener el plan del día
        val planDia = obtenerPlanDelDia(dia, objetivo)

        // Mostrar los datos en la UI
        mostrarPlanComidas(planDia, dia)
    }

    private fun mostrarPlanComidas(planDia: PlanDia, dia: String) {
        findViewById<TextView>(R.id.diaTextView).text = "Planificación para $dia"

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
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible")
            )
        }
    }

    private fun planSubirPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    " Tortilla de Espinacas y Queso",
                    R.drawable.desayuno_img,
                    "Ingredientes: 3 huevos\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 taza de queso cheddar rallado\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Bate los huevos en un tazón y añade sal y pimienta.\n" +
                            "Calienta el aceite en una sartén a fuego medio y añade las espinacas hasta que se marchiten.\n" +
                            "Agrega los huevos batidos y cocina por unos minutos.\n" +
                            "Espolvorea el queso por encima y cocina hasta que los huevos estén firmes y el queso se derrita."
                ),
                Receta(
                    "Batido de Plátano y Mantequilla de Maní",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 plátano\n" +
                            "2 cucharadas de mantequilla de maní\n" +
                            "1 taza de leche (puede ser entera o de almendra)\n" +
                            "1 cucharada de miel",
                    "En una licuadora, mezcla el plátano, la mantequilla de maní, la leche y la miel.\n" +
                            "Licúa hasta obtener una mezcla homogénea y cremosa.\n" +
                            "Sirve frío."
                ),
                Receta(
                    "Ensalada de Pollo con Aguacate y Nueces",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 pechuga de pollo a la parrilla, en trozos\n" +
                            "1 aguacate, en cubos\n" +
                            "1/2 taza de nueces\n" +
                            "2 tazas de lechuga mixta\n" +
                            "Aderezo de aceite de oliva y vinagre",
                    "En un tazón grande, combina la lechuga, el pollo, el aguacate y las nueces.\n" +
                            "Rocía el aderezo por encima y mezcla suavemente para no aplastar el aguacate"
                ),
                Receta(
                    "Pasta con Salsa de Tomate y Albóndigas",
                    R.drawable.cena_img,
                    "Ingredientes: 200 g de pasta (espagueti o la que prefieras)\n" +
                            "1 taza de salsa de tomate\n" +
                            "4 albóndigas de carne (pueden ser compradas o caseras)\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Queso parmesano rallado para servir",
                    "Cocina la pasta según las instrucciones del paquete.\n" +
                            "Mientras se cocina, calienta el aceite en una sartén y agrega las albóndigas hasta que estén doradas.\n" +
                            "Añade la salsa de tomate y cocina a fuego lento durante 10 minutos.\n" +
                            "Sirve la pasta con la salsa y las albóndigas, espolvoreando queso parmesano por encima."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Panqueques de Avena y Plátano",
                    R.drawable.desayuno_img,
                    "1 taza de avena\n" +
                            "2 plátanos maduros\n" +
                            "2 huevos\n" +
                            "1/2 taza de leche\n" +
                            "1 cucharadita de polvo para hornear",
                    "En un tazón, mezcla la avena, los plátanos, los huevos, la leche y el polvo para hornear hasta obtener una mezcla homogénea.\n" +
                            "Calienta una sartén a fuego medio y vierte un poco de la mezcla para formar los panqueques.\n" +
                            "Cocina hasta que se formen burbujas en la superficie, luego voltea y cocina el otro lado.\n" +
                            "Sirve con miel o jarabe de arce."
                ),
                Receta(
                    "Tostadas de Aguacate con Salmón Ahumado",
                    R.drawable.merienda_img,
                    "Ingredientes: 2 rebanadas de pan integral\n" +
                            "1 aguacate maduro\n" +
                            "100 g de salmón ahumado\n" +
                            "Jugo de limón, sal y pimienta al gusto",
                    "Tuesta las rebanadas de pan hasta que estén doradas.\n" +
                            "Machaca el aguacate y mézclalo con el jugo de limón, sal y pimienta.\n" +
                            "Unta la mezcla de aguacate sobre las tostadas y coloca el salmón ahumado encima."
                ),
                Receta(
                    "Bowl de Arroz Integral con Pollo y Verduras",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 taza de arroz integral cocido\n" +
                            "1 pechuga de pollo, asada y desmenuzada\n" +
                            "1/2 taza de brócoli al vapor\n" +
                            "1/2 taza de pimientos rojos asados\n" +
                            "Salsa de soya al gusto",
                    "En un tazón, mezcla el arroz, el pollo, el brócoli y los pimientos.\n" +
                            "Agrega salsa de soya al gusto y mezcla bien."
                ),
                Receta(
                    " Pasta con Pesto y Pollo",
                    R.drawable.cena_img,
                    "Ingredientes: 200 g de pasta (tipo penne)\n" +
                            "1 pechuga de pollo, a la parrilla y cortada en trozos\n" +
                            "1/2 taza de pesto\n" +
                            "1/4 de taza de nueces, picadas",
                    "Cocina la pasta según las instrucciones del paquete.\n" +
                            "Mezcla la pasta cocida con el pesto y el pollo.\n" +
                            "Espolvorea las nueces por encima antes de servir."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Avena Cocida con Frutas y Nueces",
                    R.drawable.desayuno_img,
                    "1 taza de avena\n" +
                            "2 tazas de leche (puede ser entera o de almendra)\n" +
                            "1/2 manzana, en cubos\n" +
                            "1/4 de taza de nueces\n" +
                            "1 cucharadita de canela",
                    "Tuesta el pan, aplasta el aguacate sobre la tostada y sazona con sal y pimienta."
                ),
                Receta(
                    "Hummus con Palitos de Verdura",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de garbanzos cocidos\n" +
                            "2 cucharadas de tahini\n" +
                            "1 diente de ajo\n" +
                            "Jugo de 1 limón\n" +
                            "Palitos de zanahoria y apio",
                    "Mezcla los garbanzos, tahini, ajo y jugo de limón en una licuadora hasta obtener un puré suave.\n" +
                            "Sirve con los palitos de verduras."
                ),
                Receta(
                    "Tacos de Frijoles y Aguacate",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 lata de frijoles negros, escurridos\n" +
                            "1 aguacate, en rodajas\n" +
                            "4 tortillas de maíz\n" +
                            "Salsa y cilantro al gusto",
                    "Calienta las tortillas y coloca frijoles, rodajas de aguacate, salsa y cilantro.\n" +
                            "Sirve caliente."
                ),
                Receta(
                    " Salmón a la Plancha con Quinoa",
                    R.drawable.cena_img,
                    "Ingredientes:200 g de salmón\n" +
                            "1 taza de quinoa cocida\n" +
                            "1 taza de espinacas\n" +
                            "Jugo de 1 limón",
                    "Cocina el salmón a la plancha hasta que esté dorado.\n" +
                            "Sirve sobre la quinoa cocida y añade espinacas salteadas con un poco de jugo de limón."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Tortitas de Plátano y Avena",
                    R.drawable.desayuno_img,
                    "2 plátanos maduros\n" +
                            "1 taza de avena\n" +
                            "2 huevos\n" +
                            "Canela al gusto",
                    "Tritura los plátanos y mezcla con la avena, huevos y canela.\n" +
                            "Cocina pequeñas porciones en una sartén caliente hasta dorar."
                ),
                Receta(
                    "Batido de Yogur y Espinacas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de yogur natural\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 plátano\n" +
                            "1 cucharada de miel",
                    "Mezcla todos los ingredientes en una licuadora hasta obtener un batido suave."
                ),
                Receta(
                    "Wrap de Pollo y Verduras",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 tortilla integral\n" +
                            "100 g de pollo asado, en tiras\n" +
                            "1/2 taza de lechuga\n" +
                            "1/4 de taza de zanahorias ralladas\n" +
                            "Salsa de yogur",
                    "Coloca el pollo, lechuga, zanahorias y salsa en la tortilla.\n" +
                            "Enrolla y corta a la mitad para servir."
                ),
                Receta(
                    " Guiso de Lentejas",
                    R.drawable.cena_img,
                    "Ingredientes:1 taza de lentejas cocidas\n" +
                            "1 zanahoria, picada\n" +
                            "1 cebolla, picada\n" +
                            "2 tazas de caldo de verduras\n" +
                            "1 cucharada de aceite de oliva",
                    "Sofríe la cebolla y zanahoria en aceite hasta que estén tiernas.\n" +
                            "Añade las lentejas y el caldo, cocina a fuego lento durante 20 minutos."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Chía Pudding con Frutas",
                    R.drawable.desayuno_img,
                    "1/4 de taza de semillas de chía\n" +
                            "1 taza de leche de almendra\n" +
                            "1 cucharadita de miel\n" +
                            "Frutas para decorar (fresas, kiwi, etc.)",
                    " Mezcla las semillas de chía con la leche y la miel, deja reposar en el refrigerador durante la noche.\n" +
                            "Sirve con frutas por encima."
                ),
                Receta(
                    "Bolitas Energéticas de Cacao",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de dátiles\n" +
                            "1/2 taza de nueces\n" +
                            "2 cucharadas de cacao en polvo",
                    "Mezcla los dátiles, nueces y cacao en una procesadora hasta obtener una masa.\n" +
                            "Forma bolitas y refrigera."
                ),
                Receta(
                    "Ensalada de Atún y Garbanzos",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 lata de atún, escurrido\n" +
                            "1 taza de garbanzos cocidos\n" +
                            "1/2 cebolla roja, picada\n" +
                            "1/2 taza de pimientos, en cubos\n" +
                            "Aderezo de aceite de oliva y limón",
                    "Mezcla todos los ingredientes en un tazón y adereza al gusto."
                ),
                Receta(
                    " Pechuga de Pollo al Limón con Verduras Asadas",
                    R.drawable.cena_img,
                    "Ingredientes:200 g de pechuga de pollo\n" +
                            "1 taza de calabacín, en rodajas\n" +
                            "1 taza de zanahorias, en rodajas\n" +
                            "Jugo de 1 limón\n" +
                            "1 cucharada de aceite de oliva",
                    "Precalienta el horno a 200 °C.\n" +
                            "Marina el pollo con jugo de limón y aceite de oliva durante 30 minutos.\n" +
                            "Coloca el pollo y las verduras en una bandeja y hornea durante 25-30 minutos."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Tostadas Francesas con Frutas",
                    R.drawable.desayuno_img,
                    "2 rebanadas de pan integral\n" +
                            "2 huevos\n" +
                            "1/2 taza de leche\n" +
                            "1/2 cucharadita de canela\n" +
                            "Frutas para decorar (fresas, arándanos)",
                    " Bate los huevos, la leche y la canela en un tazón.\n" +
                            "Sumerge las rebanadas de pan en la mezcla y cocínalas en una sartén hasta dorar por ambos lados.\n" +
                            "Sirve con frutas por encima."
                ),
                Receta(
                    " Frutos Secos y Chocolate",
                    R.drawable.merienda_img,
                    "Ingredientes: 1/2 taza de nueces, almendras y avellanas\n" +
                            "1/4 de taza de chocolate negro",
                    "Mezcla los frutos secos con el chocolate troceado.\n" +
                            "Disfruta como snack energético."
                ),
                Receta(
                    "Bowl de Arroz y Frijoles",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 taza de arroz integral cocido\n" +
                            "1 taza de frijoles negros\n" +
                            "1/2 aguacate, en rodajas\n" +
                            "Salsa al gusto",
                    "En un tazón, coloca el arroz, los frijoles y el aguacate.\n" +
                            "Añade la salsa de tu elección y mezcla."
                ),
                Receta(
                    "Salmón al Horno con Espinacas",
                    R.drawable.cena_img,
                    "Ingredientes:200 g de salmón\n" +
                            "2 tazas de espinacas frescas\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Limón para rociar",
                    " Precalienta el horno a 180 °C.\n" +
                            "Coloca el salmón en una bandeja, rocía con aceite de oliva y limón.\n" +
                            "Hornea durante 15-20 minutos. Saltea las espinacas en una sartén hasta que se marchiten y sirve junto al salmón.\n"
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Huevos Revueltos con Espinacas y Queso",
                    R.drawable.desayuno_img,
                    "3 huevos\n" +
                            "1 taza de espinacas\n" +
                            "1/4 de taza de queso feta\n" +
                            "Sal y pimienta al gusto",
                    "Bate los huevos con sal y pimienta.\n" +
                            "Cocina las espinacas en una sartén y luego añade los huevos, revolviendo hasta que estén cocidos.\n" +
                            "Agrega el queso feta antes de servir."
                ),
                Receta(
                    " Batido de Mango y Coco",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de mango fresco o congelado\n" +
                            "1 taza de leche de coco\n" +
                            "1 plátano\n" +
                            "1 cucharada de miel (opcional)",
                    "Mezcla todos los ingredientes en una licuadora hasta que esté suave y cremoso.\n" +
                            "Sirve frío."
                ),
                Receta(
                    "Ensalada de Garbanzos y Tomate",
                    R.drawable.almuerzo_img,
                    "Ingredientes:1 taza de garbanzos cocidos\n" +
                            "1 tomate grande, picado\n" +
                            "1/4 de cebolla roja, picada\n" +
                            "Jugo de limón, sal y pimienta",
                    "Mezcla todos los ingredientes en un tazón.\n" +
                            "Añade sal, pimienta y jugo de limón al gusto."
                ),
                Receta(
                    " Pasta Integral con Salsa de Tomate y Albahaca",
                    R.drawable.cena_img,
                    "Ingredientes:1 taza de pasta integral\n" +
                            "1 taza de salsa de tomate\n" +
                            "Albahaca fresca al gusto",
                    " Cocina la pasta según las instrucciones del paquete.\n" +
                            "Mezcla con la salsa de tomate y añade albahaca fresca.\n"
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible")
            )
        }
    }

    private fun planBajarPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    "Yogur con Frutas y Semillas",
                    R.drawable.desayuno_img,
                    "Ingredientes: 1 taza de yogur natural\n" +
                            "1/2 taza de fresas picadas\n" +
                            "1/2 plátano en rodajas\n" +
                            "1 cucharada de semillas de chía",
                    "Mezcla todos los ingredientes en un tazón y disfruta."
                ),
                Receta(
                    "Palitos de Zanahoria y Hummus",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 zanahoria grande, cortada en palitos\n" +
                            "1/4 de taza de hummus",
                    "Sirve los palitos de zanahoria con hummus para mojar."
                ),
                Receta(
                    "Ensalada de Pollo a la Parrilla",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de pechuga de pollo a la parrilla\n" +
                            "2 tazas de espinacas\n" +
                            "1/2 aguacate\n" +
                            "1/2 tomate\n" +
                            "Aderezo de limón y aceite de oliva",
                    "Mezcla todos los ingredientes en un tazón y añade el aderezo."
                ),
                Receta(
                    "Pescado al Horno con Verduras",
                    R.drawable.cena_img,
                    "Ingredientes: 150 g de filete de pescado (como salmón)\n" +
                            "1 taza de brócoli\n" +
                            "1 zanahoria en rodajas\n" +
                            "1 cucharadita de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Coloca el pescado y las verduras en una bandeja para hornear, rocía con aceite, sal y pimienta. Hornea a 200°C durante 20 minutos."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Avena con Frutas",
                    R.drawable.desayuno_img,
                    "1/2 taza de avena\n" +
                            "1 taza de agua o leche\n" +
                            "1/2 manzana en trozos\n" +
                            "1 cucharada de miel",
                    "Cocina la avena en agua o leche. Añade la manzana y la miel al final."
                ),
                Receta(
                    "Batido Verde",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de espinacas\n" +
                            "1/2 plátano\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharada de mantequilla de almendra",
                    "Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Quinoa con Verduras Asadas",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1/2 taza de quinoa cocida\n" +
                            "1/2 taza de pimientos y calabacín asados\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta",
                    "Mezcla la quinoa con las verduras asadas y añade aceite, sal y pimienta."
                ),
                Receta(
                    " Sopa de Lentejas",
                    R.drawable.cena_img,
                    "Ingredientes: 1/2 taza de lentejas\n" +
                            "1 zanahoria picada\n" +
                            "1/2 cebolla picada\n" +
                            "1 litro de caldo de verduras",
                    "Cocina todos los ingredientes en una olla a fuego medio hasta que las lentejas estén tiernas."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Tostadas de Aguacate",
                    R.drawable.desayuno_img,
                    "1 rebanada de pan integral\n" +
                            "1/2 aguacate\n" +
                            "Sal y pimienta al gusto",
                    "Tuesta el pan, aplasta el aguacate sobre la tostada y sazona con sal y pimienta."
                ),
                Receta(
                    "Manzana con Mantequilla de Almendra",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 manzana\n" +
                            "1 cucharada de mantequilla de almendra",
                    "Corta la manzana en rodajas y unta la mantequilla de almendra."
                ),
                Receta(
                    "Ensalada de Garbanzos",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 taza de garbanzos cocidos\n" +
                            "1/2 pepino picado\n" +
                            "1/2 cebolla roja picada\n" +
                            "Jugo de limón\n" +
                            "Cilantro fresco",
                    "Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Tacos de Lechuga con Pavo",
                    R.drawable.cena_img,
                    "Ingredientes:150 g de pavo molido\n" +
                            "1 cucharadita de especias (comino, pimentón)\n" +
                            "Hojas de lechuga",
                    "Cocina el pavo con las especias y sirve en hojas de lechuga."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Smoothie de Plátano y Espinaca",
                    R.drawable.desayuno_img,
                    "1 plátano\n" +
                            "1 taza de espinacas\n" +
                            "1/2 taza de yogur natural\n" +
                            "1/2 taza de agua",
                    "Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Nueces y Frutas Secas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1/4 de taza de nueces\n" +
                            "1/4 de taza de frutas secas (como pasas)",
                    "Mezcla las nueces y las frutas secas."
                ),
                Receta(
                    "Wrap de Pollo y Verduras",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de pollo a la parrilla\n" +
                            "1 tortilla integral\n" +
                            "1/2 taza de lechuga\n" +
                            "1/4 de aguacate",
                    "Rellena la tortilla con pollo, lechuga y aguacate, y enrolla."
                ),
                Receta(
                    " Berenjenas al Horno",
                    R.drawable.cena_img,
                    "Ingredientes:1 berenjena\n" +
                            "2 cucharadas de aceite de oliva\n" +
                            "Sal y especias al gusto",
                    "Corta la berenjena, rocía con aceite y especias, y hornea a 200°C durante 25 minutos."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Pudding de Chía",
                    R.drawable.desayuno_img,
                    "1/4 de taza de semillas de chía\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharadita de miel\n" +
                            "Frutas al gusto",
                    " Mezcla las semillas de chía con la leche y miel, deja reposar en el refrigerador durante la noche y sirve con frutas."
                ),
                Receta(
                    " Yogur con Granola",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de yogur natural\n" +
                            "1/4 de taza de granola",
                    "Mezcla el yogur con la granola."
                ),
                Receta(
                    "Tazón de Quinoa y Frijoles",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1/2 taza de quinoa cocida\n" +
                            "1/2 taza de frijoles negros\n" +
                            "1/2 aguacate\n" +
                            "Salsa al gusto",
                    "Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Tortilla de Espinacas",
                    R.drawable.cena_img,
                    "Ingredientes:2 huevos\n" +
                            "1 taza de espinacas\n" +
                            "1/2 cebolla",
                    "Bate los huevos y mezcla con espinacas y cebolla. Cocina en una sartén antiadherente hasta que esté firme."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Panqueques de Avena",
                    R.drawable.desayuno_img,
                    "1 taza de avena\n" +
                            "1 plátano\n" +
                            "1/2 taza de leche",
                    " Mezcla todos los ingredientes y cocina en una sartén antiadherente."
                ),
                Receta(
                    " Galletas de Avena",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 plátano\n" +
                            "1/2 taza de avena",
                    "Mezcla y hornea a 180°C por 15 minutos."
                ),
                Receta(
                    "Ensalada de Atún",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1 lata de atún\n" +
                            "1/2 taza de garbanzos\n" +
                            "1/2 pepino\n" +
                            "Jugo de limón",
                    "MMezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    " Verduras Salteadas",
                    R.drawable.cena_img,
                    "Ingredientes:1 taza de verduras variadas (pimientos, brócoli, zanahorias)\n" +
                            "1 cucharada de salsa de soja",
                    " Saltea las verduras en una sartén con salsa de soja."
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Smoothie de Fresa y Yogur",
                    R.drawable.desayuno_img,
                    "1 taza de fresas\n" +
                            "1/2 taza de yogur\n" +
                            "1/2 taza de leche",
                    " Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    " Batido de Proteínas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 cucharada de proteína en polvo\n" +
                            "1 plátano\n" +
                            "1 taza de agua o leche",
                    "Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Pita de Pollo",
                    R.drawable.almuerzo_img,
                    "Ingredientes:150 g de pollo a la parrilla\n" +
                            "1 pan pita integral\n" +
                            "1/2 taza de ensalada",
                    "Rellena el pan pita con pollo y ensalada.."
                ),
                Receta(
                    " Sopa de Verduras",
                    R.drawable.cena_img,
                    "Ingredientes:1 taza de verduras mixtas\n" +
                            "1 litro de caldo de verduras",
                    " Cocina todos los ingredientes en una olla hasta que las verduras estén tiernas."
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible")
            )
        }
    }

    private fun planMantenerPeso(dia: String): PlanDia {
        return when (dia) {
            "Lunes" -> PlanDia(
                Receta(
                    "Avena con Frutas y Nueces",
                    R.drawable.desayuno_img,
                    "Ingredientes: 1/2 taza de avena\n" +
                            "1 taza de leche o agua\n" +
                            "1/2 plátano en rodajas\n" +
                            "1 cucharada de nueces picadas",
                    "Cocina la avena con agua o leche, luego añade el plátano y las nueces."
                ),
                Receta(
                    "Yogur Griego con Miel",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de yogur griego\n" +
                            "1 cucharadita de miel",
                    "Mezcla el yogur con la miel y disfruta."
                ),
                Receta(
                    "Ensalada de Quinoa y Garbanzos",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1/2 taza de quinoa cocida\n" +
                            "1/2 taza de garbanzos cocidos\n" +
                            "1/2 pepino picado\n" +
                            "1/2 aguacate\n" +
                            "Jugo de limón",
                    "Mezcla todos los ingredientes en un tazón."
                ),
                Receta(
                    "Salmón al Horno con Espárragos",
                    R.drawable.cena_img,
                    "Ingredientes: 150 g de salmón\n" +
                            "1 taza de espárragos\n" +
                            "1 cucharada de aceite de oliva\n" +
                            "Sal y pimienta al gusto",
                    "Hornea el salmón y los espárragos a 200°C durante 15-20 minutos."
                )
            )

            "Martes" -> PlanDia(
                Receta(
                    "Yogur con Semillas de Chía y Frutas",
                    R.drawable.desayuno_img,
                    "1 taza de yogur natural\n" +
                            "1 cucharada de semillas de chía\n" +
                            "1/2 taza de fresas o arándanos",
                    " Mezcla el yogur con las semillas de chía y añade las frutas."
                ),
                Receta(
                    "Hummus con Palitos de Pepino",
                    R.drawable.merienda_img,
                    "Ingredientes: 1/4 de taza de hummus\n" +
                            "1 pepino cortado en palitos",
                    "Sirve el hummus con los palitos de pepino para mojar."
                ),
                Receta(
                    "Wrap de Pavo y Espinacas",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de pechuga de pavo\n" +
                            "1 tortilla integral\n" +
                            "1 taza de espinacas\n" +
                            "Rodajas de tomate",
                    "Rellena la tortilla con el pavo, espinacas y tomate, y enrolla."
                ),
                Receta(
                    " Sopa de Verduras",
                    R.drawable.cena_img,
                    "Ingredientes: 1 taza de verduras mixtas (zanahoria, calabacín, apio)\n" +
                            "1 litro de caldo de verduras",
                    "Cocina las verduras en el caldo hasta que estén tiernas."
                )
            )

            "Miercoles" -> PlanDia(
                Receta(
                    "Avena Nocturna",
                    R.drawable.desayuno_img,
                    "1/2 taza de avena\n" +
                            "1 taza de leche de almendras\n" +
                            "1 cucharada de miel\n" +
                            "1/2 cucharadita de canela",
                    "Mezcla todos los ingredientes en un recipiente y deja reposar en el refrigerador durante la noche."
                ),
                Receta(
                    "Frutas con Yogur",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de frutas mixtas (kiwi, piña, fresas)\n" +
                            "1/2 taza de yogur griego",
                    "Mezcla las frutas con el yogur y disfruta."
                ),
                Receta(
                    "Filete de Pescado a la Plancha",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de filete de pescado (merluza o tilapia)\n" +
                            "1 taza de espinacas salteadas\n" +
                            "1 cucharada de aceite de oliva",
                    "Cocina el pescado en una sartén a fuego medio con aceite de oliva y sirve con las espinacas."
                ),
                Receta(
                    " Ensalada de Atún",
                    R.drawable.cena_img,
                    "Ingredientes:1 lata de atún\n" +
                            "1/2 taza de garbanzos\n" +
                            "1/2 cebolla roja\n" +
                            "2 tazas de lechuga",
                    " Mezcla todos los ingredientes y añade un poco de jugo de limón."
                )
            )

            "Jueves" -> PlanDia(
                Receta(
                    "Smoothie de Mango y Espinacas",
                    R.drawable.desayuno_img,
                    "1 taza de espinacas\n" +
                            "1/2 taza de mango congelado\n" +
                            "1 plátano\n" +
                            "1 taza de agua o leche",
                    "Mezcla todos los ingredientes en una licuadora hasta que esté suave."
                ),
                Receta(
                    "Nueces y Pasas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1/4 de taza de nueces\n" +
                            "1/4 de taza de frutas secas (como pasas)",
                    "Mezcla y disfruta como un snack."
                ),
                Receta(
                    "Quinoa con Verduras Asadas",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 1/2 taza de quinoa cocida\n" +
                            "1 taza de verduras asadas (calabacín, pimientos, berenjena)\n" +
                            "1 cucharada de aceite de oliva",
                    "Mezcla la quinoa con las verduras asadas y añade un poco de aceite."
                ),
                Receta(
                    " Tortilla de Espinacas y Champiñones",
                    R.drawable.cena_img,
                    "Ingredientes:2 huevos\n" +
                            "1/2 taza de espinacas\n" +
                            "1/2 taza de champiñones",
                    "Bate los huevos y añade las espinacas y champiñones. Cocina en una sartén hasta que estén firmes."
                )
            )

            "Viernes" -> PlanDia(
                Receta(
                    "Parfait de Yogur y Granola",
                    R.drawable.desayuno_img,
                    "1 taza de yogur natural\n" +
                            "1/2 taza de granola\n" +
                            "1/2 taza de frutas mixtas",
                    "  Alterna capas de yogur, granola y frutas en un vaso."
                ),
                Receta(
                    " Batido de Frutas y Espinacas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de espinacas\n" +
                            "1 plátano\n" +
                            "1/2 taza de fresas\n" +
                            "1 taza de leche de almendras",
                    "Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Pollo al Curry con Arroz Integral",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de pechuga de pollo\n" +
                            "1/2 taza de arroz integral cocido\n" +
                            "1 cucharada de curry en polvo",
                    "Cocina el pollo en una sartén con curry y sirve sobre el arroz."
                ),
                Receta(
                    " Pizza de Coliflor",
                    R.drawable.cena_img,
                    "Ingredientes:1 taza de coliflor rallada\n" +
                            "1 huevo\n" +
                            "1/2 taza de queso mozzarella\n" +
                            "Salsa de tomate\n" +
                            "Verduras al gusto",
                    "Mezcla la coliflor, huevo y queso, forma la base y hornea. Agrega salsa y verduras y vuelve a hornear."
                )
            )
            "Sabado" -> PlanDia(
                Receta(
                    " Tostadas Francesas Saludables",
                    R.drawable.desayuno_img,
                    "1 rebanada de pan integral\n" +
                            "1 huevo\n" +
                            "1/4 de taza de leche\n" +
                            "Canela al gusto",
                    " Mezcla el huevo, leche y canela. Remoja el pan y cocina en una sartén hasta dorar."
                ),
                Receta(
                    " Galletas de Plátano y Avena",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 plátano maduro\n" +
                            "1/2 taza de avena",
                    "Mezcla y hornea a 180°C durante 15 minutos."
                ),
                Receta(
                    " Ensalada de Pollo y Mango",
                    R.drawable.almuerzo_img,
                    "Ingredientes: 150 g de pechuga de pollo\n" +
                            "1/2 mango en cubos\n" +
                            "2 tazas de lechuga",
                    "Cocina el pollo y mézclalo con mango y lechuga."
                ),
                Receta(
                    " Salteado de Tofu y Verduras",
                    R.drawable.cena_img,
                    "Ingredientes:150 g de tofu\n" +
                            "1 taza de verduras mixtas (brócoli, zanahoria, pimientos)\n" +
                            "Salsa de soja al gusto",
                    " Cocina el tofu y las verduras en una sartén con salsa de soja."
                )
            )
            "Domingo" -> PlanDia(
                Receta(
                    " Tortilla de Claras con Espinacas y Tomate",
                    R.drawable.desayuno_img,
                    "4 claras de huevo\n" +
                            "1 taza de espinacas frescas\n" +
                            "1/2 tomate picado\n" +
                            "Sal y pimienta al gusto",
                    " Bate las claras y vierte en una sartén caliente. Agrega las espinacas y el tomate. Cocina hasta que las claras estén firmes."
                ),
                Receta(
                    " Batido de Frutas",
                    R.drawable.merienda_img,
                    "Ingredientes: 1 taza de frutas mixtas (fresas, plátano)\n" +
                            "1 taza de leche de almendras",
                    "Mezcla todos los ingredientes en una licuadora."
                ),
                Receta(
                    "Hamburguesa de Pavo",
                    R.drawable.almuerzo_img,
                    "Ingredientes:150 g de carne de pavo\n" +
                            "1 pan integral\n" +
                            "Lechuga, tomate y cebolla al gusto",
                    "Cocina la carne de pavo y sirve en el pan con las verduras."
                ),
                Receta(
                    " Ensalada de Espinacas y Fresas",
                    R.drawable.cena_img,
                    "Ingredientes:2 tazas de espinacas\n" +
                            "1/2 taza de fresas en rodajas\n" +
                            "1/4 de taza de nueces\n" +
                            "Vinagreta al gusto",
                    " Mezcla todos los ingredientes en un tazón."
                )
            )
            // Agregar los demás días de la semana aquí
            else -> PlanDia(
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible"),
                Receta("No disponible", R.drawable.default_img, "No disponible", "No disponible")
            )
        }
    }
}