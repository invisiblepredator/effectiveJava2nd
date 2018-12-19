package EffectiveJava.chapter_3_MethodsForAllObjects.article11_Clone;

import java.util.HashMap;

public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //Рекурсивно копирует связный спиcок начинающийся с указанной записи
//        Entry deepCopy(){
//            return new Entry(key, value, next == null ? null : next.deepCopy());
//        }


        //Итеративно
        Entry deepCopy(){
            Entry result = new Entry(key, value, next);

            for(Entry p = result; p.next !=null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            return result;
        }
    }

    @Override
    public HashTable clone() throws CloneNotSupportedException {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i = 0; i<buckets.length; i++){
                if(buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
                    return result;
            }
        } catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
        return null;
    }
    //... Остальное опущено.
}
