package Java_lab14;
import java.util.Map;

public class MyHashMap implements Java_lab14.MyMap {

    private int size = 0; // количество пар в контейнере
    private static final int INITIAL_CAPACITY = 16; // начальный размер массива
    private static final double LOAD_FACTOR = 0.75; // коэффициент загруженности
    // если size/source.length >= LOAD_FACTOR то нужно перебалансировать
    // для равномерного распределения элементов чтобы не было длинных цепочек

    private Pair [] source = new Pair[INITIAL_CAPACITY]; // массив для хранения "голов" цепочек

    private static class Pair { // элемент
        String key; // ключ
        String value; // значение
        Pair next; // ссылка на следующий элемент в цепочке
        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(String key, String value) {
        if(size > LOAD_FACTOR*source.length)
            resize();
        Pair pair = findPair(key); // поиск пары по ключу
        if(pair == null) // нужно вставить новую пару
        {
            int bucket = findBucket(key); // найдем номер ведра по ключу
            pair = new Pair(key, value, source[bucket]);
            source[bucket] = pair; // делаем новую пару корнем цепочки
            size++;
        }
        else {
            pair.value = value; // такая пара уже есть, просто меняем значение
        }
    }

    private int findBucket(String key)
    { // по ключу находим хэш и по хэшу находим бакет
        return Math.abs(key.hashCode()) % source.length;
    }

    // поиск пары по ключу
    private Pair findPair(String key)
    {
        // найдем ведро по ключу
        int bucket = findBucket(key);
        Pair currentPair = source[bucket]; // корень цепочки
        while (currentPair != null)
        {
            if(currentPair.key.equals(key))
                return currentPair;
            currentPair = currentPair.next; // следующая пара по цепочке
        }
        return null; // пара с ключом key не найдена
    }

    // перебалансировка массива - создание массива в два раза больше и перенос
    // туда всех элементов
    private void resize()
    {
        Pair[] temp = new Pair[source.length * 2];
        for (Pair i : source)
        {
            while (i != null)
            {
                int pos = i.hashCode() % temp.length;
                if (temp[pos] != null)
                    i.next = temp[pos];
                temp[pos] = i;
                i = i.next;
            }
        }
        source = temp;
    }

    @Override
    public String get(String key) { // найти значение в паре с ключом key
        Pair pair = findPair(key);
        if(pair == null)
            return null;
        return pair.value;
    }

    @Override
    public String remove(String key)
    {
        int bucket = findBucket(key);
        Pair currentPair = source[bucket];
        if (currentPair.key.equals(key))
        {
            source[bucket] = currentPair.next;
            return currentPair.value;
        }
        while (true)
        {
            if (currentPair.next == null)
                return null;
            if (currentPair.next.key.equals(key)) {
                Pair temp = currentPair.next;
                currentPair.next = temp.next;
                return temp.value;
            }
            currentPair = currentPair.next;
        }
    }

    @Override
    public boolean contains(String key) {
        int bucket = findBucket(key);
        Pair currentPair = source[bucket];
        while (currentPair != null)
        {
            if(currentPair.key.equals(key))
                return true;
            currentPair = currentPair.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
