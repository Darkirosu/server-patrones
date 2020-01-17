package es.uah.cc.domain.iterator;

public class IteratorTexas implements Iterator {

    private  AgregatorConcrete agregator;
    private  int index=0;

    public IteratorTexas(AgregatorConcrete agregator) {
        this.agregator = agregator;
    }


    @Override
    public Object first() throws IndexOutOfBoundsException {
        Object object = null;
        if(!agregator.element.isEmpty()){
            index=0;
            object = agregator.element.get(0);
        }else{
            throw  new IndexOutOfBoundsException();
        }
         return object;
    }

    @Override
    public Object next() throws IndexOutOfBoundsException {
        Object object = null;
        if(index<agregator.element.size()){
            object =agregator.element.get(index);
            index++;
        }else{
            throw  new  IndexOutOfBoundsException();
        }

        return object;
    }

    @Override
    public boolean finish() {
        boolean result = true;
        if(agregator.element.isEmpty() || index==agregator.element.size()){
            result=false;
        }

        return result;
    }

    @Override
    public Object elementCurrent() throws IndexOutOfBoundsException {
       Object object = null;
       if(index< agregator.element.size()){
           object = agregator.element.get(index);
       }else{
           throw new  IndexOutOfBoundsException();
       }

        return object;
    }
}
