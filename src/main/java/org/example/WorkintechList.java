package org.example;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class WorkintechList<E> extends ArrayList<E> {

    private final Locale turkishLocale = new Locale("tr", "TR");

    public WorkintechList() {
    }

    public void sort() {
        // Türkçe Locale ayarını kullanarak sıralama
        if (!this.isEmpty() && this.get(0) instanceof String) {
            Collator collator = Collator.getInstance(turkishLocale);
            this.sort((o1, o2) -> {
                String s1 = ((String) o1).toLowerCase(turkishLocale);
                String s2 = ((String) o2).toLowerCase(turkishLocale);
                return collator.compare(s1, s2);
            });
        } else {
            this.sort(null);
        }
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        }
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        boolean result = super.remove(o);
        if (result) {
            sort();
        }
        return result;
    }
}