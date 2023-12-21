package org.example;

//В языке Java массивы имеют фиксированную длину. Для обхода этого ограничения создайте класс DynamicArray, который должен быть обобщенным (generic).
//
//        Требования:
//        Создайте класс DynamicArray, который должен быть обобщенным (generic).
//        В классе DynamicArray должны быть следующие публичные методы:
//        void add(T el) - добавляет элемент в массив. При переполнении текущего массива, должен создаваться новый, большего размера
//        void remove(int index) - удаляет элемент из массива по указанному индексу.
//        T get(int index) - извлекает элемент из массива по указанному индексу. Если метод get вызывается с некорректным индексом (меньше 0 или больше или равно текущей длине массива), ожидается, что метод выбросит исключение ArrayIndexOutOfBoundsException.
//        Класс DynamicArray должен иметь приватные поля (при необходимости) для хранения данных и длины с следующими именами:
//        data - для хранения элементов.
//        size - для хранения текущей длины.
//        Класс DynamicArray должен иметь публичный конструктор по умолчанию.
//        Методы класса DynamicArray должны работать согласно описанным требованиям.


public class DynamicArray<T> {
    private int size;
    private T[] data;

    public DynamicArray() {
        this.data = (T[]) new Object[7];
    }

    public void add(T el) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length + 1);
        }
        data[size++] = el;

    }

    public void remove(int index) {
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;

    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];

    }
}