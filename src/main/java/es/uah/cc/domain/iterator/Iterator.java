package es.uah.cc.domain.iterator;

public interface Iterator {

    Object first() throws  IndexOutOfBoundsException;

    Object next() throws  IndexOutOfBoundsException;

    boolean finish();

    Object elementCurrent() throws  IndexOutOfBoundsException;
}
