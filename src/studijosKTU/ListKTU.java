package studijosKTU;
/**
 * Tai pirmoji kompleksinės duomenų struktūros klasė, kuri leidžia
 * apjungti atskirus objektus į vieną visumą - sąrašą.
 * Objektai, kurie bus dedami į sąrašą, turi tenkinti interfeisą dataKTU.
 *
 * @užduotis Peržiūrėkite ir išsiaiškinkite pateiktus metodus.
 *
 * @author Eimutis Karčiauskas, KTU programinės įrangos katedra
 */

public class ListKTU<Data> implements ListADT<Data> {

    private Node<Data> first;   // rodyklė į pirmą mazgą
    private Node<Data> last;    // rodyklė į paskutinį mazgą
    private Node<Data> current; // rodyklė į einamąjį mazgą, naudojama getNext
    private int size;           // sąrašo dydis, tuo pačiu elementų skaičius
    /**
     * Constructs an empty list.
     */
    public ListKTU() {
    }
    public boolean add(Data data) {      // įdeda elementą į sąrašo pabaigą
        if(data==null) return false;        // nuliniai objektai nepriimami
        if (first == null) {
            first = new Node<Data>(data, first);
            last = first;
        } else {
            Node<Data> e1 = new Node(data, null);
            last.next = e1;
            last = e1;
        }
        size++;
        return true;
    }
    public boolean add(int k, Data data){  // įterpia prieš k-ąją poziciją
        if(data==null) return false;       // nuliniai objektai nepriimami
        if (k<0||k>=size)return false;     // jei k yra blogas, grąžina null
        throw new UnsupportedOperationException
                ("Studentams reikia realizuoti add(int k, Data data)");
    }
    public int size() {     // grąžinamas sąrašo dydis (elementų kiekis)
        return size;
    }
    public boolean isEmpty() {      // patikrina ar sąrašas yra tuščias
        return first == null;
    }
    public void clear() {
        size = 0;
        first = null;
        last = null;
        current = null;
    }
    public Data get(int k){           // grąžiną k-ojo elemento reikšmę
        if (k<0||k>=size)return null; // jei k yra blogas, gąžina null
        current=first.findNode(k);    // ir tuo pačiu nustato current
        return current.element;
    }
    public Data set(int k, Data data){   // suformuoja k-ojo elemento reikšmę
        if(data==null) return null;      // nuliniai objektai nepriimami
        throw new UnsupportedOperationException
                ("Studentams reikia realizuoti set(int k, Data d)");
    }
    public Data getNext(){       //pereina prie kitos reikšmės ir ją grąžina
        if(current==null) return null;
        current=current.next;
        if(current==null) return null;
        return current.element;
    }
    public Data remove(int k) {
       throw new UnsupportedOperationException
                ("Studentams reikia realizuoti remove(int k)");
    }

class Node<Data> {          // vidinė klasė, užtikrinanti inkapsuliaciją
    public Data element;    // ji nematoma už klasės ListKTU ribų
    public Node<Data> next; // next - kaip įprasta - nuoroda į kitą mazgą

    Node(Data data, Node<Data> next) { //mazgo konstruktorius
        this.element = data;
        this.next = next;
    }
    public Node<Data> findNode(int k){ // suranda k-ąjį mazgą
        Node<Data> e=this;
        for(int i=0;i<k;i++){
           e=e.next;
        }
        return e;
    }
}
}


