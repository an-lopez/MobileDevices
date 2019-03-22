package com.escom.ipn.mx.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chargeList(View view) {
        Intent intent = new Intent(this, Ejercicio1Activity.class);

        ArrayList al = new ArrayList<ListaEntrada>();

        al.add(new ListaEntrada(R.drawable.buho,
                "BUHO", "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o"
                + "aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen"
                + "plumas alzadas que parecen orejas."));
        al.add(new ListaEntrada(R.drawable.colibri,
                "COLIBRÍ", "Los troquilinos (Trochilinae) son una subfamilia de aves apodiformes de la familia"
                + "Trochilidae, conocidas vulgarmente como colibríes, quindes, tucusitos, picaflores, chupamirtos,"
                + "chuparrosas, huichichiquis (idioma nahuatl), mainumby (idioma guaraní) o guanumby."));
        al.add(new ListaEntrada(R.drawable.cuervo,
                "CUERVO", "El cuervo común (Corvus corax) es una especie de ave paseriforme de la familia de los"
                + "córvidos(Corvidae).Presente en todo el hemisferio septentrional, es la especie de córvido con la"
                + "mayor superficie de distribución."));
        al.add(new ListaEntrada(R.drawable.flamenco,
                "FLAMENCO", "Los fenicopteriformes (Phoenicopteriformes), los cuales reciben el nombre vulgar de"
                + "flamencos, son un orden de aves neognatas, con un único género viviente:Phoenicopterus."));
        al.add(new ListaEntrada(R.drawable.kiwi,
                "KIWI", "Los kiwis (Apterix, gr. 'sin alas') son un género de aves paleognatas compuesto por cinco"
                + "especies endémicas de Nueva Zelanda .1 2 Son aves no voladoras pequeñas, aproximadamente del tamaño de una gallina. "));
        al.add(new ListaEntrada(R.drawable.loro,
                "LORO", "Las Psitácidas (Psittacidae) son una familia de aves psitaciformes llamadas comúnmente"
                + "loros o papagayos, e incluye a los guacamayos, las cotorras, los periquitos, los agapornis y formas afines."));
        al.add(new ListaEntrada(R.drawable.pavo,
                "PAVO", "Pavo es un género de aves galliformes de la familia Phasianidae, que incluye dos especies,"
                + "el pavo real común(Pavo cristatus)y el pavo real cuelliverde(Pavo muticus)."));
        al.add(new ListaEntrada(R.drawable.pinguino,
                "PINGÜINO", "Los pingüinos (familia Spheniscidae, orden Sphenisciformes) son un grupo de aves"
                + "marinas, no voladoras, que se distribuyen únicamente en el Hemisferio Sur, sobre todo en sus altas latitudes."));

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", al);

        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void chargeList2(View view) {
        Intent intent = new Intent(this, Ejercicio1Activity.class);

        ArrayList al = new ArrayList<ListaEntrada>();

        al.add(new ListaEntrada(R.drawable.manzana,
                "MANZANA", "La manzana es una fruta pomácea comestible, fruta del manzano comestible " +
                "(Malus domestica), otros manzanos (especies del género Malus) o híbridos de aquel."));

        al.add(new ListaEntrada(R.drawable.pera,
                "PERA", "Se denomina pera al fruto de distintas especies del género Pyrus, " +
                "integrado por árboles caducifolios conocidos comúnmente como perales."));

        al.add(new ListaEntrada(R.drawable.sandia,
                "SANDÍA", "Citrullus lanatus, comúnmente llamada sandía, síndria, patilla, aguamelón o " +
                "melón de agua es una fruta de la familia Cucurbitaceae originaria de África, pero tiene una " +
                "gran presencia y difusión en Asia."));

        al.add(new ListaEntrada(R.drawable.melon,
                "MELÓN", "El melón es una planta herbácea monoica de tallos rastreros. Se cultiva por su " +
                "fruto, una baya pepónide de temporada veraniega con un gran contenido de agua y de sabor dulce."));

        al.add(new ListaEntrada(R.drawable.kiwif,
                "KIWI", "El kiwi es la baya de la enredadera Actinidia deliciosa. Es originaria de una gran" +
                " área de China, sobre todo de los bosques del valle del río Yangtsé. Introducida en Nueva Zelanda " +
                "en 1904, fue cultivada desde entonces en muchas regiones templadas por su fruto comestible.. "));

        al.add(new ListaEntrada(R.drawable.jicama,
                "JICAMA", "La jícama, pelenga o nabo mexicano es una planta leguminosa originaria de México, " +
                "cultivada especialmente por sus raíces tuberosas, las cuales son comestibles. El origen de la " +
                "palabra jícama es del náhuatl xīcama o xīcamatl que quiere decir, raíz acuosa."));

        al.add(new ListaEntrada(R.drawable.pepino,
                "PEPINO", "Cucumis sativus, conocido popularmente como pepino, es una " +
                "planta anual de la familia de las cucurbitáceas. "));

        al.add(new ListaEntrada(R.drawable.banana,
                "BANANA", "La banana, plátano, guineo, " +
                "banano o cambur en Venezuela, es un fruto comestible, botánicamente una baya, de varios tipos de grandes " +
                "plantas herbáceas del género Musa.La banana, plátano, guineo, banano o cambur en Venezuela, es un " +
                "fruto comestible, botánicamente una baya, de varios tipos de grandes plantas herbáceas del género Musa."));

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", al);

        intent.putExtras(bundle);
        startActivity(intent);

    }
}
